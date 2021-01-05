package com.liianjun.demo.utils;


import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class test {


    public  static String [] strArray={"哈尔滨","齐齐哈尔","牡丹江","佳木斯","大庆","鸡西","双鸭山","伊春","七台河","鹤岗","绥化","大兴安岭","黑河"};
    public static void main(String[] args) throws FileNotFoundException {
        ExcelReader read = ExcelUtil.getReader(new FileInputStream(new File("C:\\Users\\Administrator\\Desktop\\数字化大屏数据提供模板11月.xlsx")), "本地网指标4");
        List<List<Object>> read1 = read.read();
        for (List<Object> objects : read1) {
            String s = String.valueOf(objects.get(2)).trim();
            switch(s){
                case "应收账款":
                    xcjson(objects,s);
                    break;
                case "政企渠道应收账款":
                    xcjson(objects,s);
                    break;
                case "其他渠道应收账款":
                    xcjson(objects,s);
                        break;
                case "新兴ICT应收账款":
                    xcjson(objects,s);
                    break;

            }
        }

    }

    private static void xcjson(List<Object> objects,String s1) {
        String objectList1 = String.valueOf(objects.get(1));  //地市
        String objectList3 = String.valueOf(objects.get(3));  //累计余额
        String objectList4 = String.valueOf(objects.get(4));  //环比增长额
        String objectList5 = String.valueOf(objects.get(5));  //同比增长额
        String objectList6 = String.valueOf(objects.get(6));  //占收比
        String objectList7 = String.valueOf(objects.get(7));  //占收比排名
            for (String s : strArray) {
                if(objectList1.equals(s)){
                    List<Map<String,Object> > list=new ArrayList<>();
                    Map<String,Object> map=new HashMap<>();
                    System.out.println(s);
                    map.put("indexName",s1);
                    map.put("yoy",objectList4);
                    map.put("mom",0);
                    map.put("percentage",objectList5);
                    map.put("rink",objectList7);
                    map.put("total",objectList3);
                    list.add(map);
                    JSONArray jsonArray = JSONUtil.parseArray(list);
                    System.out.println(jsonArray.toString());
                 }
            }



    }

}
