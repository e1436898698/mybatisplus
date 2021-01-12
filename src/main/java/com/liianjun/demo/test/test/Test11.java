package com.liianjun.demo.test.test;


import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.liianjun.demo.test.doman.TestA;
import com.liianjun.demo.test.doman.data;

import java.util.Arrays;
import java.util.Comparator;

public class Test11 {

    public static void main(String[] args) {
        String str="{\n" +
                "  \"data\": [\n" +
                "    {\n" +
                "      \"completionValue\": 61423.68,\n" +
                "      \"area\": \"哈尔滨\",\n" +
                "      \"incomeProportion\": \"26.45%\",\n" +
                "      \"incomeRranking\": 4,\n" +
                "      \"proportion\": \"-1.46%\",\n" +
                "      \"ranking\": 6\n" +
                "    },\n" +
                "    {\n" +
                "      \"completionValue\": 14877.43,\n" +
                "      \"area\": \"齐齐哈尔\",\n" +
                "      \"incomeProportion\": \"28.08%\",\n" +
                "      \"incomeRranking\": 7,\n" +
                "      \"proportion\": \"6.63%\",\n" +
                "      \"ranking\": 10\n" +
                "    },\n" +
                "    {\n" +
                "      \"completionValue\": 9914.53,\n" +
                "      \"area\": \"牡丹江\",\n" +
                "      \"incomeProportion\": \"29.21%\",\n" +
                "      \"incomeRranking\": 8,\n" +
                "      \"proportion\": \"-5.87%\",\n" +
                "      \"ranking\": 4\n" +
                "    },\n" +
                "    {\n" +
                "      \"completionValue\": 11746.19,\n" +
                "      \"area\": \"佳木斯\",\n" +
                "      \"incomeProportion\": \"32.90%\",\n" +
                "      \"incomeRranking\": 11,\n" +
                "      \"proportion\": \"3.01%\",\n" +
                "      \"ranking\": 9\n" +
                "    },\n" +
                "    {\n" +
                "      \"completionValue\": 14335.92,\n" +
                "      \"area\": \"大庆\",\n" +
                "      \"incomeProportion\": \"27.24%\",\n" +
                "      \"incomeRranking\": 5,\n" +
                "      \"proportion\": \"-11.04%\",\n" +
                "      \"ranking\": 3\n" +
                "    },\n" +
                "    {\n" +
                "      \"completionValue\": 5471.71,\n" +
                "      \"area\": \"鸡西\",\n" +
                "      \"incomeProportion\": \"24.12%\",\n" +
                "      \"incomeRranking\": 2,\n" +
                "      \"proportion\": \"-12.69%\",\n" +
                "      \"ranking\": 2\n" +
                "    },\n" +
                "    {\n" +
                "      \"completionValue\": 5400.64,\n" +
                "      \"area\": \"双鸭山\",\n" +
                "      \"incomeProportion\": \"33.60%\",\n" +
                "      \"incomeRranking\": 12,\n" +
                "      \"proportion\": \"-1.67%\",\n" +
                "      \"ranking\": 5\n" +
                "    },\n" +
                "    {\n" +
                "      \"completionValue\": 4033.6,\n" +
                "      \"area\": \"伊春\",\n" +
                "      \"incomeProportion\": \"27.40%\",\n" +
                "      \"incomeRranking\": 6,\n" +
                "      \"proportion\": \"-0.46%\",\n" +
                "      \"ranking\": 7\n" +
                "    },\n" +
                "    {\n" +
                "      \"completionValue\": 3698.85,\n" +
                "      \"area\": \"七台河\",\n" +
                "      \"incomeProportion\": \"37.56%\",\n" +
                "      \"incomeRranking\": 13,\n" +
                "      \"proportion\": \"13.19%\",\n" +
                "      \"ranking\": 12\n" +
                "    },\n" +
                "    {\n" +
                "      \"completionValue\": 5359.33,\n" +
                "      \"area\": \"鹤岗\",\n" +
                "      \"incomeProportion\": \"29.57%\",\n" +
                "      \"incomeRranking\": 9,\n" +
                "      \"proportion\": \"37.98%\",\n" +
                "      \"ranking\": 13\n" +
                "    },\n" +
                "    {\n" +
                "      \"completionValue\": 13546.43,\n" +
                "      \"area\": \"绥化\",\n" +
                "      \"incomeProportion\": \"25.89%\",\n" +
                "      \"incomeRranking\": 3,\n" +
                "      \"proportion\": \"2.27%\",\n" +
                "      \"ranking\": 8\n" +
                "    },\n" +
                "    {\n" +
                "      \"completionValue\": 1988.07,\n" +
                "      \"area\": \"大兴安岭\",\n" +
                "      \"incomeProportion\": \"22.79%\",\n" +
                "      \"incomeRranking\": 1,\n" +
                "      \"proportion\": \"-16.52%\",\n" +
                "      \"ranking\": 1\n" +
                "    },\n" +
                "    {\n" +
                "      \"completionValue\": 6442.27,\n" +
                "      \"area\": \"黑河\",\n" +
                "      \"incomeProportion\": \"20.89%\",\n" +
                "      \"incomeRranking\": 10,\n" +
                "      \"proportion\": \"9.25%\",\n" +
                "      \"ranking\": 11\n" +
                "    }\n" +
                "  ],\n" +
                "  \"title\": {\n" +
                "    \"area\": \"地域\",\n" +
                "    \"completionValue\": \"完成值(万元)\",\n" +
                "    \"incomeProportion\": \"占收比\",\n" +
                "    \"incomeRranking\": \"占收比排名\",\n" +
                "    \"proportion\": \"同比\",\n" +
                "    \"ranking\": \"同比排名\"\n" +
                "  }\n" +
                "}";

        System.out.println("-----完成值");
        String wcz = getWCZ(str);
        System.out.println(wcz);
        System.out.println("-----完成值");

        System.out.println("-----占收比");
        String zxb = getZXB(str);
        System.out.println(zxb);
        System.out.println("-----占收比");

        System.out.println("-----占收比排名");
        String zxbpm = getTBPM(str);
        System.out.println(zxbpm);
        System.out.println("-----占收比排名");

        System.out.println("-----同比");
        String tb = getZXBPM(str);
        System.out.println(tb);
        System.out.println("-----同比");

        System.out.println("-----同比排名");
        String tbpm = getTb(str);
        System.out.println(tbpm);
        System.out.println("-----同比同比");

    }

    /**
     * 完成值
     * @param str
     * @return
     */
    private static String getWCZ(String str) {
        TestA testA = JSONUtil.toBean(str, TestA.class);
        for (data datum : testA.getData()) {
            datum.setCompletionValues(Double.valueOf(datum.getCompletionValue()));
        }
        testA.getData().sort(Comparator.comparing(data::getCompletionValues).reversed());

        testA.setWarningIndex(Arrays.asList(10,11,12));
        return JSON.toJSONString(testA);
    }

    /**
     * 占收比排名
     * @param str
     * @return
     */
    private static String getTBPM(String str) {
        TestA testA = JSONUtil.toBean(str, TestA.class);
        testA.getData().sort(Comparator.comparing(data::getIncomeRranking));
        testA.setWarningIndex(Arrays.asList(10,11,12));
        return  JSON.toJSONString(testA);
    }
    /**
     * 占收比
     * @param str
     * @return
     */
    private static String getZXB(String str) {
        TestA testA = JSONUtil.toBean(str, TestA.class);
        for (data datum : testA.getData()) {
              String[] split = datum.getIncomeProportion().split("%");
              datum.setCompletionValues(Double.valueOf(split[0]));
        }
        testA.getData().sort(Comparator.comparing(data::getCompletionValues).reversed());
        testA.setWarningIndex(Arrays.asList(10,11,12));
       return  JSON.toJSONString(testA);
    }

    /**
     * 同比
     * @param str
     * @return
     */
    private static String getZXBPM(String str) {
        TestA testA = JSONUtil.toBean(str, TestA.class);
        for (data datum : testA.getData()) {
            String[] split = datum.getProportion().split("%");
            datum.setCompletionValues(Double.valueOf(split[0]));

        }
        testA.getData().sort(Comparator.comparing(data::getCompletionValues).reversed());
        testA.setWarningIndex(Arrays.asList(10,11,12));
        return  JSON.toJSONString(testA);


    }

    /**
     * 同比排名
     * @param str
     * @return
     */
    private static String getTb(String str) {
         TestA testA = JSONUtil.toBean(str, TestA.class);
        testA.getData().sort(Comparator.comparing(data::getRanking));
        testA.setWarningIndex(Arrays.asList(10,11,12));
        return  JSON.toJSONString(testA);
    }




}
