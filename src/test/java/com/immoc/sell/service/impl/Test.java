package com.immoc.sell.service.impl;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();
        list.add("20190112");
        list.add("20190213");
        list.add("20190422");
        list.add("20190502");
        list.add("20170214");

        Collections.max(list);
        System.out.println("最大值："+Collections.max(list));
    }
}
