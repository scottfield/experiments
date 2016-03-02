/*
 * Globalroam 2015 @copyright
 */
package com.gnum.experiments.concurrency.demo;

/**
 * @author chenglong
 * @description
 */
public class DeadLockDemo2 {

    public static void main(String[] args) {
        final Counter obj1 = new Counter("obj1");
        final Counter obj2 = new Counter("obj2");

        new Thread(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName("first");
                obj1.display(obj2);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName("second");
                obj2.display(obj1);
            }
        }).start();
    }
}

class Counter extends Thread {
    int i = 10;
    String name;

    public Counter(String name) {
        this.name = name;
    }

    public synchronized void display(Counter obj) {
        try {
            Thread.sleep(5);
            obj.increment(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void increment(Counter obj) {
        System.out.println(++i);
    }
}
