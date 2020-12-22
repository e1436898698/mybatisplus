package com.liianjun.demo.utils;


import java.util.Arrays;

public class test {

    public static void main(String[] args) {
      test1();
//        test2();
    }

    private static void test2() {
        int a=123;
    }

    private static void test1() {
        String str="123789456";
        char[] chars = str.toCharArray();
        char temp;
        for (int i = 0; i < chars.length/2; i++) {
                temp=chars[chars.length-i-1];
                chars[chars.length-i-1]=chars[i];
                chars[i]=temp;
        }
        System.out.println(Arrays.toString(chars));
    }
}
