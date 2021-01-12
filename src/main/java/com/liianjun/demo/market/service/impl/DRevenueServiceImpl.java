package com.liianjun.demo.market.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liianjun.demo.common.Response;
import com.liianjun.demo.market.constant.Constant;
import com.liianjun.demo.market.district.DateUtils;
import com.liianjun.demo.market.model.auto.DRevenue;
import com.liianjun.demo.market.mapper.auto.DRevenueMapper;
import com.liianjun.demo.market.model.auto.vo.DRevenueVo;
import com.liianjun.demo.market.model.auto.vo.PopUpsVo;
import com.liianjun.demo.market.service.IDRevenueService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liianjun.demo.market.util.CalculationUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author astupidcoder
 * @since 2021-01-09
 */
@Service
@Slf4j
public class DRevenueServiceImpl extends ServiceImpl<DRevenueMapper, DRevenue> implements IDRevenueService {

    @Autowired
    private DRevenueMapper dRevenueMapper;

    @Override
    @Transactional
    public PopUpsVo getPopUps(DRevenue dRevenue) {
        PopUpsVo popUpsVo = new PopUpsVo();
        switch (String.valueOf(dRevenue.getType())) {
            case Constant.PROVINCE:
                popUpsVo = getCity(popUpsVo);
                break;
            case Constant.CITY:
                popUpsVo = getArea(dRevenue, popUpsVo);
                break;
            default:
                log.error("没有这种类型");
        }
        return popUpsVo;
    }

    @Override
    @Transactional
    public List<DRevenueVo> getPercentage(DRevenue dRevenue) {
        List<DRevenueVo> dRevenueVoList = new ArrayList<>();
        switch (String.valueOf(dRevenue.getType())) {
            case Constant.PROVINCE:
                dRevenueVoList = getProvinceList(dRevenueVoList);
                break;
            case Constant.CITY:
                dRevenueVoList = getCityList(dRevenue, dRevenueVoList);
                break;
            case Constant.AREA:
                dRevenueVoList = getAreaList(dRevenue, dRevenueVoList);
                break;
            default:
                log.error("没有这种类型");

        }
        return dRevenueVoList;
    }

    /**
     * 获取指定准利润区县占收比
     * @return
     */
    private List<DRevenueVo> getAreaList(DRevenue dRevenue, List<DRevenueVo> dRevenueVoList) {
        QueryWrapper qw = new QueryWrapper<>();
        qw.like(StringUtils.isNoneBlank(dRevenue.getCityName()), "d_district", dRevenue.getCityName());
        List<DRevenue> dRevenueList = dRevenueMapper.selectList(qw);
        dRevenueList= dRevenueList.stream().filter(e -> e.getCreateTime().equals(DateUtils.getDate(LocalDateTime.now()))).collect(Collectors.toList());
        if (CollUtil.isEmpty(dRevenueList)) {
            return dRevenueVoList;
        }
        dRevenueVoList.add(DRevenueVo.builder().cityName(dRevenueList.get(0).getDCity()).dDistrict(dRevenueList.get(0).getDDistrict()).Percentage(dRevenueList.get(0).getDPercentage()).build());
        return dRevenueVoList;
    }

    /**
     * 获取指定城市县占收比
     * @return
     */
    private List<DRevenueVo> getCityList(DRevenue dRevenue, List<DRevenueVo> dRevenueVoList) {
        Map<String, List<DRevenue>> map = super.list().stream().filter(e -> e.getCreateTime().equals(DateUtils.getDate(LocalDateTime.now()))).collect(Collectors.groupingBy(DRevenue::getDCity));
        for (Map.Entry<String, List<DRevenue>> entity : map.entrySet()) {
            if (entity.getKey().contains(dRevenue.getCityName())) {
                Double main = entity.getValue().stream().map(DRevenue::getDMain).reduce(BigDecimal.ZERO, BigDecimal::add).doubleValue();
                Double innovation = entity.getValue().stream().map(DRevenue::getDInnovation).reduce(BigDecimal.ZERO, BigDecimal::add).doubleValue();
                String percentage = CalculationUtils.getPercentage(innovation, main);
                dRevenueVoList.add(DRevenueVo.builder().Percentage(percentage).cityName(entity.getKey()).build());
            }
        }
        return dRevenueVoList;
    }


    /**
     * 获取全省区县占收比
     * @return
     */
    private List<DRevenueVo> getProvinceList(List<DRevenueVo> dRevenueVoList) {
        List<DRevenue> dRevenueList = super.list().stream().filter(e -> e.getCreateTime().equals(DateUtils.getDate(LocalDateTime.now()))).collect(Collectors.toList());
        Double main = dRevenueList.stream().map(DRevenue::getDMain).reduce(BigDecimal.ZERO, BigDecimal::add).doubleValue();
        Double innovation = dRevenueList.stream().map(DRevenue::getDInnovation).reduce(BigDecimal.ZERO, BigDecimal::add).doubleValue();
        dRevenueVoList.add(DRevenueVo.builder().Percentage(CalculationUtils.getPercentage(innovation, main)).cityName("黑龙江").build());
        return dRevenueVoList;
    }

    /**
     * 获取准利润区县占收比
     * @return
     */
    private PopUpsVo getArea(DRevenue dRevenue, PopUpsVo popUpsVo) {
        Map<String, List<DRevenue>> map = super.list().stream().filter(e -> e.getCreateTime().equals(DateUtils.getDate(LocalDateTime.now()))).collect(Collectors.groupingBy(DRevenue::getDCity));
        for (Map.Entry<String, List<DRevenue>> entity : map.entrySet()) {
            if (entity.getKey().contains(dRevenue.getCityName())) {
                List<Map<String, Object>> dataList = new ArrayList<>();
                entity.getValue().forEach(e -> {
                    Map<String, Object> dataMap = new HashMap<>();
                    dataMap.put("cityName", e.getDDistrict().replaceAll("分公司",""));
                    dataMap.put("percentage", e.getDPercentage());
                    dataMap.put("telPhone", Arrays.asList(Long.valueOf(Constant.PHONE1), Long.valueOf(Constant.PHONE2)));
                    dataList.add(dataMap);
                });
                popUpsVo.setData(dataList);
            }
        }
        popUpsVo.setTitle(getTitle());
        return popUpsVo;
    }


    /**
     * 获取13地市区县占收比
     * @return
     */
    private PopUpsVo getCity(PopUpsVo popUpsVo) {
        Map<String, List<DRevenue>> map = super.list().stream().filter(e -> e.getCreateTime().equals(DateUtils.getDate(LocalDateTime.now()))).collect(Collectors.groupingBy(DRevenue::getDCity));
        List<Map<String, Object>> dataList = new ArrayList<>();
        for (String area : Constant.AREAS) {
            for (Map.Entry<String, List<DRevenue>> entity : map.entrySet()) {
                if (entity.getKey().contains(area)) {
                    Map<String, Object> dataMap = new HashMap<>();
                    Double main = entity.getValue().stream().map(DRevenue::getDMain).reduce(BigDecimal.ZERO, BigDecimal::add).doubleValue();
                    Double innovation = entity.getValue().stream().map(DRevenue::getDInnovation).reduce(BigDecimal.ZERO, BigDecimal::add).doubleValue();
                    String percentage = CalculationUtils.getPercentage(innovation, main);
                    dataMap.put("cityName", entity.getKey().replaceAll("分公司",""));
                    dataMap.put("percentage", percentage);
                    dataMap.put("telPhone", Arrays.asList(Long.valueOf(Constant.PHONE1), Long.valueOf(Constant.PHONE2)));
                    dataList.add(dataMap);
                }
            }
        }
        popUpsVo.setData(dataList);
        popUpsVo.setTitle(getTitle());
        return popUpsVo;
    }

    /**
     * 获取弹窗列表头
     * @return
     */
    private List<Map<String, Object>> getTitle() {
        List<Map<String, Object>> titleList = new ArrayList<>();
        Map<String, Object> titleMap = new HashMap<>();
        titleMap.put("cityName", "地域");
        titleMap.put("percentage", "区 县占收比");
        titleMap.put("telPhone", "电话号");
        titleList.add(titleMap);
        return titleList;
    }


}
