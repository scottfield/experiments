/*
 * Globalroam 2015 @copyright
 */
package com.gnum.experiments.concurrency.demo;

import java.util.Objects;

/**
 * @author chenglong
 * @description
 */
public class OrderedThreading implements Runnable{
    private final Thread predecessor;
    public OrderedThreading(Thread predecessor) {
        this.predecessor = predecessor;
    }

    @Override
    public void run() {
        if (Objects.nonNull(predecessor)) {
            predecessor.start();
            try {
                predecessor.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+" doing some work.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"finish work.");
    }

    public static void main(String[] args) {
        Thread first = new Thread(new OrderedThreading(null),"first");
        Thread second = new Thread(new OrderedThreading(first),"second");
        Thread last = new Thread(new OrderedThreading(second),"last");
        last.start();
    }
}
