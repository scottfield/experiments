package com.gnum.experiments;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author jackie
 * @date 2015/10/14
 */
public class Tuple {
    void m1() {
        List<Date> list = new ArrayList<Date>();
        m2(list);
    }
    void m2(Object arg) {
        List<String> list = (List<String>) arg;    // unchecked warning
        m3(list);
    }
    void m3(List<String> list) {
        String s = list.get(0);      // ClassCastException
    }
}
