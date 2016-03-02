/*
 * Globalroam 2015 @copyright
 */
package com.gnum.experiments.concurrency.demo;

import java.util.concurrent.CountDownLatch;

/**
 * @author chenglong
 * @description
 */
public class ThreadExample {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        MyThread t1 = new MyThread(latch);
        MyThread t2 = new MyThread(latch);
        Thread jackie = new Thread(t1, "jackie");
        jackie.start();
        Thread tom = new Thread(t2, "tom");
        tom.start();
        //Do whatever you want
//        latch.countDown();          //This will inform all the threads to start
        Thread.sleep(3000);
        latch.countDown();          //This will inform all the threads to start
        System.out.println(Thread.currentThread().getName());
    }
}

class MyThread implements Runnable {
    CountDownLatch latch;

    public MyThread(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            latch.await();          //The thread keeps waiting till it is informed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " do some useful thing");
    }
}
