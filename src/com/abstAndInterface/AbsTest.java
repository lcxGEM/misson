package com.abstAndInterface;

/**
 * 抽象类
 */
public abstract class AbsTest {
    //属性有全部的访问控制符
    public int age;
    protected String name;
    private int s;
    //可以定义普通方法和抽象方法
    public void setAge(int age){
        this.age = age;
    }

    public abstract int  getAge();
}
