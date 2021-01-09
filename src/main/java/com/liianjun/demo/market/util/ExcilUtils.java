package com.liianjun.demo.market.util;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;

import java.text.ParseException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@Component
public class ExcilUtils {

 /*   private static final String[] arrays=new String[]{"省级指标1","省级指标2","本地网指标1","本地网指标2","本地网指标3","本地网指标4"};

    @Test
    public void readMarket() throws Exception {
        for (String array : arrays) {
            ExcelReader excelReader = ExcelUtil.getReader(new FileInputStream(new File("C:\\Users\\Administrator\\Desktop\\数字化大屏数据提供模板11月 - 副本.xlsx")),array);
            List<List<Object>> read = excelReader.read();
            String localDateTime=getData(read);
            switch(array){
                case Constant.PROVINCIAL1:
                    insertProvincial1(read,localDateTime);
                case Constant.PROVINCIAL2:
                case Constant.LABORCOSTREVENUE:
                case Constant.LABORCOSTCREATION:
                case Constant.FULLCALIBEREMPLOYMENTSTRUCTURE:
                case Constant.LOCALNETWORK2:
                case Constant.LOCALNETWORK1:
                case Constant.LOCALNETWORK3:
                case Constant.LOCALNETWORK4:
                default:
                    log.error("没有这种类型");
            }
        }

    }

    private void insertProvincial1(List<List<Object>> read, String localDateTime) {
        for (List<Object> objectList : read) {
            System.out.println(objectList.toString());
        }
    }


    private  String getData(List<List<Object>> read) throws ParseException {
        List<Object> objects = read.get(1);
        return String.valueOf(objects.get(2)) + "-" + String.valueOf(objects.get(4));
    }
*/
}
