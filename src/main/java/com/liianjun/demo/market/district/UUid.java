package com.liianjun.demo.market.district;


import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.UUID;

public class UUid {


    public static String  getUUID(){
         return UUID.randomUUID().toString().replace("-","");
    }


}
