package com.abstAndInterface;

public class InterfaceTestImpl implements InterfaceTest {
    @Override
    public void aaa(int aaa) {
        System.out.println("接口实现方法");
    }

    @Override
    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        InterfaceTest.bb();
        System.out.println(InterfaceTest.name);
        //抽象类和接口的区别
        /*
        继承方面：抽象类只能单继承 接口可以继承多个接口
        实现方面：抽象类实现使用extends关键字继承后实现 接口使用implement实现
        属性方面：抽象类可以定义变量 接口内部只有常量（public static final）
        方法方面：抽象类中可以有任意方法 接口只有抽象方法、静态方法和默认方法
        构造器：抽象方法有构造器 接口没有构造器
         */
    }
}
