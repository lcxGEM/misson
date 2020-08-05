package com.abstAndInterface;

/**
 * 抽象类的继承类
 */
public class AbsInher extends AbsTest{
    @Override
    public int getAge() {
        return 0;
    }

    public static void main(String[] args) {
        int age = new AbsTest() {//匿名内部类的使用
            @Override
            public int getAge() {
                return 0;
            }
        }.getAge();
        //抽象类不能直接创建对象。只能由实现了所有抽象方法的继承类才能创建对象
        AbsTest ab = new AbsInher();
    }
}
