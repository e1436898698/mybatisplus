package com.liianjun.demo.business.test;


import java.util.UUID;

public class UUid {


    public static String  getUUID(){
         return UUID.randomUUID().toString().replace("-","");
    }

}
