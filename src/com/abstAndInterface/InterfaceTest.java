package com.abstAndInterface;

public interface InterfaceTest {
    //接口内的属性的修饰符默认是 public static final
    public static final String name = "lcx";//接口内的属性只能是常量

    //接口中的方法只能是抽象方法、java8之后有静态方法和默认方法 访问控制符为public
    public abstract void aaa(int aaa);

    static void bb(){
        System.out.println("静态方法执行");
    }
    default String getName(){
        return name;
    }
}
