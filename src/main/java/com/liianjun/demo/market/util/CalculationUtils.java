package com.liianjun.demo.market.util;

import java.math.BigDecimal;


public class CalculationUtils {
    public  static String getPercentage(Double dInnovation,Double main){
        Double percent = dInnovation / main*100;
        BigDecimal bg = new BigDecimal(percent);
        double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        return String.valueOf(f1)+"%";
    }

    /**
     * 求环比 环比增长率=(本期数-上期数)/上期数×100%
     * @param mainMonth 本期
     * @param mainMonthl 上期
     * @return
     */
    public  static Double getSequential(Double mainMonth,Double mainMonthl){
        if(mainMonth==0.0){
            mainMonth=0.01;
        }
        if(mainMonthl==0.0){
            mainMonthl=0.01;
        }
        Double percent = (mainMonth-mainMonthl) / mainMonthl*100;
        BigDecimal bg = new BigDecimal(percent);
        Double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        return f1;
    }

    /**
     * 格式化日期
     */
    public  static Double getScale(Double mainMonth){
        BigDecimal bg = new BigDecimal(mainMonth);
        Double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        return f1;
    }

}
