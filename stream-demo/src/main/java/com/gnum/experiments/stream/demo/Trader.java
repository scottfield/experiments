/*
 * Globalroam 2015 @copyright
 */
package com.gnum.experiments.stream.demo;

/**
 * @author chenglong
 * @description
 */
public class Trader {
    private final String name;
    private final String city;

    public Trader(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Trader:"+this.name + " in " + this.city;
    }
}
