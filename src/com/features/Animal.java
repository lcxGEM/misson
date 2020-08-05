package com.features;

/**
 * 继承和多态
 */
public class Animal {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void run(){
        System.out.println(name+"正在跑");
    }

    public void eat(){
        System.out.println(name+"正在吃");
    }
}
