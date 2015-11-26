package com.gnum.experiments;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jackie
 * @date 2015/10/13
 */
public abstract class New {
    public static  <K, V> Map<K, V> map() {
        return new HashMap<K,V>();
    }
}
