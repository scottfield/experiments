/*
 * Globalroam 2015 @copyright
 */
package com.gnum.experiments.concurrency.demo;

import java.util.concurrent.CountDownLatch;

/**
 * @author chenglong
 * @description
 */
public class DeadLockDemo {
    /*
    * This method request two locks, first String and then Integer
    */
    public void method1() {
        synchronized (String.class) {
            System.out.println("Aquired lock on String.class object");

            synchronized (Integer.class) {
                System.out.println("Aquired lock on Integer.class object");
            }
        }
    }

    /*
     * This method also requests same two lock but in exactly
     * Opposite order i.e. first Integer and then String.
     * This creates potential deadlock, if one thread holds String lock
     * and other holds Integer lock and they wait for each other, forever.
     */
    public void method2() {
        synchronized (Integer.class) {
            System.out.println("Aquired lock on Integer.class object");

            synchronized (String.class) {
                System.out.println("Aquired lock on String.class object");
            }
        }
    }

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        DeadLockDemo lockDemo = new DeadLockDemo();
        Thread t1 = new Thread() {
            @Override
            public void run() {
                lockDemo.method1();
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                lockDemo.method2();
            }
        };
        t1.start();
        t2.start();
    }
}
