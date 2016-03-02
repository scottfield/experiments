/*
 * Globalroam 2015 @copyright
 */
package com.gnum.experiments.concurrency.demo;

/**
 * @author chenglong
 * @description
 */
public class MultiThreading {
    private static class MyThread extends Thread {
        public MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread("myThread");
        myThread.start();
    }

}
