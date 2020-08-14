package com.week1.keywords;

public class KeyWordsTest {
    // 访问控制符
    public int a=10;         // 所有地方可以访问
    protected int b=50;      //跨包后继承类可以访问
    int c=40;                //相同包可以使用
    private String str="as"; //只能再本类中使用
    //static关键字，静态属性、静态方法、静态代码块
    public static  int aa = 5;//静态属性
    public static void add(){ //静态方法
        aa++;
    }
    static{                   //静态代码块，类初始化时加载一次
        System.out.println("初始化加载");
    }
    //final关键字
    public final int kk = 10;//final修饰的属性是常量
    public final void ba(){
        System.out.println("aaaa");//final修饰的方法不能被重写
    }
    //final 修饰的类不能被继承；

    public static void main(String[] args) {
        KeyWordsTest kwt = new KeyWordsTest();
        KeyWordsTest kw = new KeyWordsTest();
        System.out.println(kwt.a);
        System.out.println(kwt.b);
        System.out.println(kwt.c);
        System.out.println(kwt.str);
        kwt.aa=10;
        System.out.println("------>"+kw.aa);//静态属性在对象之间共享
    }
}
