package com.gnum.experiments;

import java.util.Map;

/**
 * @author jackie
 * @date 2015/10/13
 */
public class Demo {
    public static void main(String[] args) {
        Map<String, String> map = New.<String,String>map();
        map.put("dafda", "dafda");
        System.out.println(map);
    }
}
