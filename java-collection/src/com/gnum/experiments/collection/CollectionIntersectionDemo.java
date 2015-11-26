package com.gnum.experiments.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jackie
 * @date 2015/11/26
 */
public class CollectionIntersectionDemo {
    public static void main(String[] args) {
        List<String> listA = new ArrayList<>();
        List<String> listB = new ArrayList<>();
        List<String> intersection = new ArrayList<>();
        listA.add("a");
        listA.add("b");
        listA.add("c");
        listA.add("d");

        intersection.addAll(listA);
        listB.add("b");
        listB.add("c");
        listB.add("d");
        listB.add("e");

        boolean isRetain = intersection.retainAll(listB);
        System.out.println("is retain:"+isRetain);
        System.out.println("listA"+listA);
        System.out.println("listB:"+listB);
        System.out.println("intersection:"+intersection);

    }
}
