package com.liianjun.demo.market.util;

import java.text.NumberFormat;

public class CalculationUtils {
    public  static String getPercentage(Double dInnovation,Double main){
        Double percent = dInnovation / main*100;
        NumberFormat nt = NumberFormat.getPercentInstance();
        nt.setMinimumFractionDigits(2);
        return nt.format(percent);
    }
}
