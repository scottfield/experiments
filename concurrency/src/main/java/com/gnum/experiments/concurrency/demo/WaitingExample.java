/*
 * Globalroam 2015 @copyright
 */
package com.gnum.experiments.concurrency.demo;

/**
 * @author chenglong
 * @description
 */
public class WaitingExample {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        try {
            System.out.println("i am waiting for my child thread");
            thread.join();
            System.out.println("child thread is finish");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
