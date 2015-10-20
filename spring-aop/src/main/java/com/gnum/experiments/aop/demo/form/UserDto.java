package com.gnum.experiments.aop.demo.form;

/**
 * @author jackie
 * @date 2015/10/18
 */
public class UserDto {
    private String name;
    private String password;

    @Override
    public String toString() {
        return "UserDto{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
