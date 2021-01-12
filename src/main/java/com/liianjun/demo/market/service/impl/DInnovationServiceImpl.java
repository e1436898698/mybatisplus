package com.liianjun.demo.market.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liianjun.demo.market.constant.Constant;
import com.liianjun.demo.market.district.DateUtils;
import com.liianjun.demo.market.mapper.auto.DInnovationMapper;
import com.liianjun.demo.market.model.auto.DInnovation;
import com.liianjun.demo.market.model.auto.vo.DinnovationVo;
import com.liianjun.demo.market.model.auto.vo.PopUpsVo;
import com.liianjun.demo.market.service.IDInnovationService;
import com.liianjun.demo.market.util.CalculationUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 创新收入 服务实现类
 * </p>
 *
 * @author astupidcoder
 * @since 2021-01-11
 */
@Service
public class DInnovationServiceImpl extends ServiceImpl<DInnovationMapper, DInnovation> implements IDInnovationService {
    @Autowired
    private DInnovationMapper dInnovationMapper;

    @Override
    public DinnovationVo getPercentage(DInnovation dInnovation) {
        DinnovationVo dinnovationVo=null;
        switch(String.valueOf(dInnovation.getType())){
            case Constant.PROVINCE:
                dinnovationVo=getProvinceList(dInnovation);
                break;
            case Constant.CITY:
                dinnovationVo=getCityList(dInnovation);
                break;
            case Constant.AREA:
                dinnovationVo=getAreaList(dInnovation);
                break;
            default:
                log.error("没有这种类型");
        }
        return dinnovationVo;
    }

    @Override
    public PopUpsVo getPopUps(DInnovation dInnovation) {
        PopUpsVo popUpsVo=new PopUpsVo();
        switch(String.valueOf(dInnovation.getType())){
            case Constant.PROVINCE:
                popUpsVo=getProvince(popUpsVo);
                break;
            case Constant.CITY:
                popUpsVo=getCity(dInnovation,popUpsVo);
                break;
            default:
                log.error("没有这种类型");
        }
        return popUpsVo;
    }

    private PopUpsVo getCity(DInnovation dInnovation, PopUpsVo popUpsVo) {
        Map<String, List<DInnovation>> list = super.list().stream().filter(e -> e.getCreateTime().equals(DateUtils.getDateTo(LocalDateTime.now()))).collect(Collectors.groupingBy(DInnovation::getCityName));
        List<Map<String,Object>> mapList=new ArrayList<>();
        for (Map.Entry<String, List<DInnovation>> entity : list.entrySet()) {
               if(entity.getKey().contains(dInnovation.getCityName())){
                   for (DInnovation innovations : entity.getValue()) {
                       Map<String,Object> map=new HashMap<>();
                       map.put("mainMonth",innovations.getMainMonth());
                       map.put("mainSequential",CalculationUtils.getSequential(innovations.getMainMonth().doubleValue(),innovations.getMainMonthl().doubleValue()));
                       map.put("innovation",innovations.getInnovationMonth());
                       map.put("innoSequential",CalculationUtils.getSequential(innovations.getInnovationMonth().doubleValue(),innovations.getInnovationMonthl().doubleValue()));
                       map.put("cityName",innovations.getDistrict().replaceAll("分公司",""));
                       mapList.add(map);
                   }
               }
        }
        popUpsVo.setData(mapList);
        popUpsVo.setTitle(this.getTitle());
        return popUpsVo;
    }

    private PopUpsVo getProvince( PopUpsVo popUpsVo) {
        Map<String, List<DInnovation>> list = super.list().stream().filter(e -> e.getCreateTime().equals(DateUtils.getDateTo(LocalDateTime.now()))).collect(Collectors.groupingBy(DInnovation::getCityName));
        List<Map<String,Object>> mapList=new ArrayList<>();
        for (String area : Constant.AREAS) {
            for (Map.Entry<String, List<DInnovation>> entity : list.entrySet()) {
                if(entity.getKey().contains(area)){
                    Map<String,Object> map=new HashMap<>();
                    Double mainMonth = entity.getValue().stream().map(DInnovation::getMainMonth).reduce(BigDecimal.ZERO, BigDecimal::add).doubleValue();
                    Double innovation = entity.getValue().stream().map(DInnovation::getInnovationMonth).reduce(BigDecimal.ZERO, BigDecimal::add).doubleValue();
                    Double mainMonthl = entity.getValue().stream().map(DInnovation::getMainMonthl).reduce(BigDecimal.ZERO, BigDecimal::add).doubleValue();
                    Double innovationl = entity.getValue().stream().map(DInnovation::getInnovationMonthl).reduce(BigDecimal.ZERO, BigDecimal::add).doubleValue();
                    map.put("mainMonth",mainMonth);
                    map.put("mainSequential",CalculationUtils.getSequential(mainMonth,mainMonthl));
                    map.put("innovation",innovation);
                    map.put("innoSequential",CalculationUtils.getSequential(innovation,innovationl));
                    map.put("cityName",entity.getKey().replaceAll("分公司",""));
                    mapList.add(map);
                }
            }
        }
        popUpsVo.setData(mapList);
        popUpsVo.setTitle(this.getTitle());
        return popUpsVo;
    }

    private DinnovationVo getProvinceList(DInnovation dInnovation) {
        List<DInnovation> list = super.list().stream().filter(e -> e.getCreateTime().equals(DateUtils.getDateTo(LocalDateTime.now()))).collect(Collectors.toList());
        Double mainMonth = list.stream().map(DInnovation::getMainMonth).reduce(BigDecimal.ZERO, BigDecimal::add).doubleValue();
        Double innovation = list.stream().map(DInnovation::getInnovationMonth).reduce(BigDecimal.ZERO, BigDecimal::add).doubleValue();
        Double mainMonthl = list.stream().map(DInnovation::getMainMonthl).reduce(BigDecimal.ZERO, BigDecimal::add).doubleValue();
        Double innovationl = list.stream().map(DInnovation::getInnovationMonthl).reduce(BigDecimal.ZERO, BigDecimal::add).doubleValue();
        return  DinnovationVo.builder().cityName("黑龙江").mainCompletion(CalculationUtils.getScale(mainMonth)).innoCompletion(CalculationUtils.getScale(innovation)).innoSequential(CalculationUtils.getSequential(innovation,innovationl)).mainSequential(CalculationUtils.getSequential(mainMonth,mainMonthl)).build();
    }
    private DinnovationVo getCityList(DInnovation dInnovation) {
        Map<String, List<DInnovation>> list = super.list().stream().filter(e -> e.getCreateTime().equals(DateUtils.getDateTo(LocalDateTime.now()))).collect(Collectors.groupingBy(DInnovation::getCityName));
        for (Map.Entry<String, List<DInnovation>> entity : list.entrySet()) {
            if(entity.getKey().contains(dInnovation.getCityName())){
                Double mainMonth = entity.getValue().stream().map(DInnovation::getMainMonth).reduce(BigDecimal.ZERO, BigDecimal::add).doubleValue();
                Double innovation = entity.getValue().stream().map(DInnovation::getInnovationMonth).reduce(BigDecimal.ZERO, BigDecimal::add).doubleValue();
                Double mainMonthl = entity.getValue().stream().map(DInnovation::getMainMonthl).reduce(BigDecimal.ZERO, BigDecimal::add).doubleValue();
                Double innovationl = entity.getValue().stream().map(DInnovation::getInnovationMonthl).reduce(BigDecimal.ZERO, BigDecimal::add).doubleValue();
                return DinnovationVo.builder().cityName(entity.getKey()).mainCompletion(CalculationUtils.getScale(mainMonth)).innoCompletion(CalculationUtils.getScale(innovation)).innoSequential(CalculationUtils.getSequential(innovation,innovationl)).mainSequential(CalculationUtils.getSequential(mainMonth,mainMonthl)).build();
            }
        }
        return null;
    }
    private DinnovationVo getAreaList(DInnovation dInnovation) {
        QueryWrapper qw = new QueryWrapper<>();
        qw.like(StringUtils.isNoneBlank(dInnovation.getCityName()), "district", dInnovation.getCityName());
        List<DInnovation> dInnovationList = dInnovationMapper.selectList(qw);
        dInnovationList= dInnovationList.stream().filter(e -> e.getCreateTime().equals(DateUtils.getDateTo(LocalDateTime.now()))).collect(Collectors.toList());
        if (CollUtil.isEmpty(dInnovationList)) {
            return null;
        }
        return  DinnovationVo.builder().cityName(dInnovationList.get(0).getDistrict()).mainCompletion(CalculationUtils.getScale(dInnovationList.get(0).getMainMonth().doubleValue())).innoCompletion(CalculationUtils.getScale(dInnovationList.get(0).getInnovationMonth().doubleValue())).innoSequential(CalculationUtils.getSequential(dInnovationList.get(0).getInnovationMonth().doubleValue(),dInnovationList.get(0).getInnovationMonthl().doubleValue())).mainSequential(CalculationUtils.getSequential(dInnovationList.get(0).getMainMonth().doubleValue(),dInnovationList.get(0).getMainMonthl().doubleValue())).build();
    }

     private List<Map<String,Object>> getTitle(){
        List<Map<String,Object>> mapList=new ArrayList<>();
        Map<String,Object> map=new HashMap<>();
        map.put("mainMonth","主营收入完成值");
        map.put("mainSequential","主营收入环比");
        map.put("innovation","创新收入完成值");
        map.put("innoSequential","创新收入环比");
        map.put("cityName","地域");
        mapList.add(map);
        return mapList;
    }


}
