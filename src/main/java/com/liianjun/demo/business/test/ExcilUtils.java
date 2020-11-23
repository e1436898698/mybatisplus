package com.liianjun.demo.business.test;


import cn.hutool.core.collection.CollUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liianjun.demo.business.constant.Constant;
import com.liianjun.demo.business.model.auto.*;
import com.liianjun.demo.business.model.auto.vo.DCityVo;
import com.liianjun.demo.business.service.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.formula.functions.Index;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;


import java.io.File;
import java.io.FileInputStream;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@Component
public class ExcilUtils {
    @Autowired
    private IDIndexService idIndexService;
    @Autowired
    private IDItemService idItemService;
    @Autowired
    private IDProvinceService idProvinceService;
    @Autowired
    private IDValueService idValueService;
    @Autowired
    private IDCityService idCityService;

    private static final String filePath="C:\\Users\\Administrator\\Desktop\\合并黑龙江省级指标 (2).xlsx";
    private static final String[] arrays=new String[]{"省级指标1","省级指标2","本地网指标1","本地网指标2","本地网指标3","本地网指标4"};


    private  TreeSet<String> treeList=new TreeSet<>();
    private List<DCity> dCities=new ArrayList<>();
    private List<DItem> dItems=new ArrayList<>();
    private List<DValue> dValues=new ArrayList<>();
    private List<DCityVo> dCityList = new ArrayList<>();
    private  List<DIndex> IndexList=new ArrayList<>();
    private List<String> itemNameList=new ArrayList<>();
    private List<DProvince> provincesList=new ArrayList<>();

    @Test
    public   void readExcil() throws Exception {
        for (String array : arrays) {
            ExcelReader excelReader = ExcelUtil.getReader(new FileInputStream(new File(filePath)),array);
            List<List<Object>> read = excelReader.read();
            String localDateTime=getData(read);
            read.remove(0);
            switch(array){
                case Constant.PROVINCIAL1:
                    //insertData(localDateTime,read);
                    break;
                case Constant.PROVINCIAL2:
                    //insertData(localDateTime,read);
                    break;
                case Constant.LOCALNETWORK1:
                   // insertCity(localDateTime,read);
                    break;
                case Constant.LOCALNETWORK2:
                   // insertCityTo(localDateTime,read);
                    break;
                case Constant.LOCALNETWORK3:
                  /*  insertCity(localDateTime,read);*/
                    break;
                case Constant.LOCALNETWORK4:
                   // insertCity(localDateTime,read);
                    break;
                default:
                    log.error("没有这种类型");
            }
        }

    }

    /**
     * 插入市级
     * @param date
     * @param read
     */
    private void insertCityTo(String date, List<List<Object>> read) {
        List<DProvince> list=getProvinceData();
        for (int i = 2; i < read.size(); i++) {
            treeList.add(read.get(i).get(1).toString());
        }
        treeList.forEach(e->{
            List<DCity> list1 = idCityService.list(new QueryWrapper<DCity>().lambda().eq(DCity::getCName, e));
            if(CollUtil.isEmpty(list1)){
                dCities.add(DCity.builder().cId(UUid.getUUID()).cName(e).dpId(list.get(0).getPId()).build());
            }else{
                dCities.add(DCity.builder().cId(list1.get(0).getCId()).cName(e).dpId(list.get(0).getPId()).build());
            }
        });

        for (int i = 2; i < read.size(); i++) {
            List<Object> objects = read.get(1);
            for (int j = 2; j < objects.size(); j++) {
                dCityList.add(DCityVo.builder().cityName(String.valueOf(read.get(i).get(1).toString())).indexName(String.valueOf(objects.get(j))).build());
            }
        }
        Map<String, List<DCityVo>> collect = dCityList.stream().collect(Collectors.groupingBy(DCityVo::getCityName));
        for (DCity dCity : dCities) {
            List<DCityVo> dCityVos = collect.get(dCity.getCName());
            for (DCityVo dCityVo : dCityVos) {
                IndexList.add(DIndex.builder().iId(UUid.getUUID()).iName(dCityVo.getIndexName()).isProvincial(0).pcId(dCity.getCId()).build());
            }
        }
        List<Object> itemList = read.get(1);
        for (int i = 3; i < itemList.size(); i++) {
            for (int j = 2; j < read.size(); j++) {
                List<Object> objects = read.get(j);
                int x=2;
                for (DIndex dIndex : IndexList) {
                    String uuid = UUid.getUUID();
                    dItems.add(DItem.builder().iId(uuid)
                            .iName(String.valueOf(itemList.get(i)))
                            .indexId(dIndex.getIId())
                            .build());
                    dValues.add(DValue.builder().iId(uuid)
                            .vValue(String.valueOf(objects.get(x)))
                            .vId(UUid.getUUID())
                            .date(date)
                            .build());
                    x++;
                    if(x==3){
                        x=2;
                    }
                }
            }
        }
        List<DCity> newArray=new ArrayList<>();
        for (DCity dCity : dCities) {
            DCity city = idCityService.getById(dCity.getCId());
            if(city==null){
                newArray.add(dCity);
            }
        }
        if(CollUtil.isNotEmpty(newArray)){
            idCityService.saveBatch(newArray);
        }
        idIndexService.saveBatch(IndexList);
        idItemService.saveBatch(dItems);
        idValueService.saveBatch(dValues);
    }


    /**
     * 插入市级
     * @param date
     * @param read
     */
    private void insertCity(String date, List<List<Object>> read) {
        List<DProvince> list=getProvinceData();
        for (int i = 2; i < read.size(); i++) {
            treeList.add(read.get(i).get(1).toString());
        }
        treeList.forEach(e->{
            List<DCity> list1 = idCityService.list(new QueryWrapper<DCity>().lambda().eq(DCity::getCName, e));
            if(CollUtil.isEmpty(list1)){
                dCities.add(DCity.builder().cId(UUid.getUUID()).cName(e).dpId(list.get(0).getPId()).build());
            }else{
                dCities.add(DCity.builder().cId(list1.get(0).getCId()).cName(e).dpId(list.get(0).getPId()).build());
            }
        });
        for (int i = 2; i < read.size(); i++) {
            dCityList.add(DCityVo.builder().cityName(String.valueOf(read.get(i).get(1).toString())).indexName(read.get(i).get(2).toString()).build());
        }
        Map<String, List<DCityVo>> map = dCityList.stream().collect(Collectors.groupingBy(DCityVo::getCityName));
        for (DCity dCity : dCities) {
            List<DCityVo> dCityVos = map.get(dCity.getCName());
            for (DCityVo dCityVo : dCityVos) {
                IndexList.add(DIndex.builder().iId(UUid.getUUID()).isProvincial(0).iName(dCityVo.getIndexName()).pcId(dCity.getCId()).build());
            }

        }
        //获取指标项
        List<Object> itemList = read.get(1);
        for (int i = 3; i < itemList.size(); i++) {
            for (int j = 2; j < read.size(); j++) {
                List<Object> objects = read.get(j);
                for (DIndex dIndex : IndexList) {
                    if (String.valueOf(objects.get(2)).equals(dIndex.getIName())) {
                        if (StringUtils.isNoneEmpty(String.valueOf(objects.get(i)))) {
                            String uuid = UUid.getUUID();
                            dItems.add(DItem.builder().iId(uuid)
                                    .iName(String.valueOf(itemList.get(i)))
                                    .indexId(dIndex.getIId())
                                    .build());
                            dValues.add(DValue.builder().iId(uuid)
                                    .vValue(String.valueOf(read.get(j).get(i)))
                                    .vId(UUid.getUUID())
                                    .date(date)
                                    .build());
                        }
                    }
                }
            }
        }
        List<DCity> newArray=new ArrayList<>();
        for (DCity dCity : dCities) {
            DCity city = idCityService.getById(dCity.getCId());
            if(city==null){
                newArray.add(dCity);
            }
        }
        if(CollUtil.isNotEmpty(newArray)){
            idCityService.saveBatch(newArray);
        }
        idIndexService.saveBatch(IndexList);
        idItemService.saveBatch(dItems);
        idValueService.saveBatch(dValues);



    }

    private List<DProvince> getProvinceData() {
        return  idProvinceService.list();
    }

    /**
     * 插入省级
     * @param date
     * @param read
     */
    private void insertData(String date, List<List<Object>> read) {
        for (int i = 2; i < read.size(); i++) {
            treeList.add(read.get(i).get(1).toString());
        }
        treeList.forEach(e->{
            List<DProvince> list = idProvinceService.list(new QueryWrapper<DProvince>().lambda().eq(DProvince::getPName,e));
            if(CollUtil.isEmpty(list)){
                provincesList.add(DProvince.builder().pId(UUid.getUUID()).pName(e).build());
            }else{
                provincesList.add(DProvince.builder().pId(list.get(0).getPId()).pName(e).build());
            }
        });
        for (int i = 2; i < read.size(); i++) {
            itemNameList.add(read.get(i).get(2).toString());
        }
        itemNameList.forEach(e->{
            IndexList.add(DIndex.builder().iId(UUid.getUUID()).isProvincial(1).pcId(provincesList.get(0).getPId()).iName(e).build());
        });
        //获取指标项
        List<Object> itemList = read.get(1);
        for (int i = 3; i < itemList.size(); i++) {
            for (int j = 2; j < read.size(); j++) {
                List<Object> objects = read.get(j);
                for (DIndex dIndex : IndexList) {
                    if (String.valueOf(objects.get(2)).equals(dIndex.getIName())) {
                        if (StringUtils.isNoneEmpty(String.valueOf(objects.get(i)))) {
                            String uuid = UUid.getUUID();
                            dItems.add(DItem.builder().iId(uuid)
                                    .iName(String.valueOf(itemList.get(i)))
                                    .indexId(dIndex.getIId())
                                    .build());
                            dValues.add(DValue.builder().iId(uuid)
                                    .vValue(String.valueOf(read.get(j).get(i)))
                                    .vId(UUid.getUUID())
                                    .date(date)
                                    .build());
                        }
                    }
                }
            }
        }
        DProvince dp = idProvinceService.getById(provincesList.get(0).getPId());
        if(dp==null){
            idProvinceService.saveBatch(provincesList);
        }
        idIndexService.saveBatch(IndexList);
        idItemService.saveBatch(dItems);
        idValueService.saveBatch(dValues);
    }

    private  String getData(List<List<Object>> read) throws ParseException {
        List<Object> objects = read.get(1);
        return String.valueOf(objects.get(2)) + "-" + String.valueOf(objects.get(4));
    }




}
