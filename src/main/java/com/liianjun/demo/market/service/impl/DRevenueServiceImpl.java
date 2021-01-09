package com.liianjun.demo.market.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liianjun.demo.common.Response;
import com.liianjun.demo.market.constant.Constant;
import com.liianjun.demo.market.model.auto.DRevenue;
import com.liianjun.demo.market.mapper.auto.DRevenueMapper;
import com.liianjun.demo.market.model.auto.vo.PopUpsVo;
import com.liianjun.demo.market.service.IDRevenueService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liianjun.demo.market.util.CalculationUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
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
    public PopUpsVo getPopUps(DRevenue dRevenue) {
        PopUpsVo popUpsVo=new PopUpsVo();
        switch(String.valueOf(dRevenue.getType())){
            case Constant.PROVINCE:
                popUpsVo=getCity(popUpsVo);
                break;
            case Constant.CITY:
                popUpsVo=getArea(dRevenue,popUpsVo);
                break;
            default:
             log.error("没有这种类型");
        }
        return popUpsVo;
    }

    private PopUpsVo getArea(DRevenue dRevenue, PopUpsVo popUpsVo) {
        Map<String, List<DRevenue>> map = super.list().stream().collect(Collectors.groupingBy(DRevenue::getDCity));
        for (Map.Entry<String, List<DRevenue>> entity : map.entrySet()) {
             if(entity.getKey().contains(dRevenue.getCityName())){
                 List<Map<String,Object>> dataList=new ArrayList<>();
                 entity.getValue().forEach(e->{
                 Map<String,Object> dataMap=new HashMap<>();
                 dataMap.put("cityName",e.getDDistrict());
                 dataMap.put("percentage",e.getDPercentage());
                 dataMap.put("telPhone",Arrays.asList(Long.valueOf(Constant.PHONE1),Long.valueOf(Constant.PHONE2)));
                     dataList.add(dataMap);
                 });
                 popUpsVo.setData(dataList);
             }
        }
        popUpsVo.setTitle(getTitle());
        return popUpsVo;
    }

    private PopUpsVo getCity(PopUpsVo popUpsVo) {
        Map<String, List<DRevenue>> map = super.list().stream().collect(Collectors.groupingBy(DRevenue::getDCity));
        List<Map<String,Object>> dataList=new ArrayList<>();
        for (Map.Entry<String, List<DRevenue>> entity : map.entrySet()) {
            Map<String,Object> dataMap=new HashMap<>();
            Double main = entity.getValue().stream().map(DRevenue::getDMain).reduce(BigDecimal.ZERO, BigDecimal::add).doubleValue();
            Double innovation = entity.getValue().stream().map(DRevenue::getDInnovation).reduce(BigDecimal.ZERO, BigDecimal::add).doubleValue();
            String percentage = CalculationUtils.getPercentage(innovation, main);
            dataMap.put("cityName",entity.getKey());
            dataMap.put("percentage",percentage);
            dataMap.put("telPhone",Arrays.asList(Long.valueOf(Constant.PHONE1),Long.valueOf(Constant.PHONE2)));
            dataList.add(dataMap);
        }
        popUpsVo.setData(dataList);
        popUpsVo.setTitle(getTitle());
        return popUpsVo;
    }

    private List<Map<String, Object>> getTitle() {
        List<Map<String,Object>> titleList=new ArrayList<>();
        Map<String,Object> titleMap=new HashMap<>();
        titleMap.put("cityName","地域");
        titleMap.put("percentage","区 县占收比");
        titleMap.put("telPhone","电话号");
        titleList.add(titleMap);
        return titleList;
    }


}
