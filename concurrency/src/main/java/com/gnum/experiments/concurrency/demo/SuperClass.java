/*
 * Globalroam 2015 @copyright
 */
package com.gnum.experiments.concurrency.demo;

/**
 * @author chenglong
 * @description
 */
public abstract class SuperClass {
    public SuperClass() {
       /* new Thread("evil") { public void run() {

        }}.start();*/
        doSomethingDangerous();
       /* try {
            Thread.sleep(5000);
        }
        catch(InterruptedException ex) { *//* ignore *//* }*/
    }

    public abstract void doSomethingDangerous();
}
