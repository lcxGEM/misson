package com.features;

/**
 * 继承和多态
 */
public class Cat extends Animal {

    String name = "小猫";

    @Override
    public void run() {
        System.out.println("cat is running");
    }

    @Override
    public void eat() {
        super.eat();
    }

    public void catchMouse(){
        System.out.println("cat is catching a mouse");
    }

    public static void main(String[] args) {
        Animal cat = new Cat();//对象上转型 上转型之后只能调用的父类原有方法和属性，执行的是子类重写以后的方法 子类新增方法和属性不能调用
        cat.setName("猫");//多态
        cat.run();//多态

        Cat a = (Cat) cat; //对象下转型
        System.out.println(a.name);//上转型的对象下转型之后可以继续调用新增方法和属性
        a.catchMouse();
        a.run();
        a.eat();
        System.out.println("----------");
        Cat t = (Cat) new Animal();//执行报错：不能把父类对象强制下转型成子类对象
        t.catchMouse();
        t.eat();
        t.run();
    }
}
