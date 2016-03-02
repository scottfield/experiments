/*
 * Globalroam 2015 @copyright
 */
package com.gnum.experiments.concurrency.demo;

/**
 * @author chenglong
 * @description
 */
public class SubClass extends SuperClass {
    int number;

    public SubClass() {
        number = 2;
    }

    public synchronized void doSomethingDangerous() {
        System.out.println("the number value==>" +number);
        if (number == 2) {
            System.out.println("everything OK");
        } else {
            System.out.println("we have a problem.");
        }
    }

    public static void main(String[] args) {
        SubClass s = new SubClass();
    }
}
