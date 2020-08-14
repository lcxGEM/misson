package com.week2;

/**
 * 可见性: volatile对于引用数据类型的可见性
 * 经测试，volatile使用引用数据类型时对引用数据类型具有可见性，而且对引用数据类型的内部数据具有可见性
 * 不使用volatile时，数组引用的修改、数组内部值的修改、对象引用的修改、对象内部值的修改都不会让while循环结束
 * 使用volatile是，数组引用的修改、数组内部值的修改、对象引用的修改、对象内部值的修改都会使while循环结束
 *
 */
public class VolatileTest2 {

    //public static  int [] vt1;

    public volatile static int [] vt1;

    //public volatile static VolatileTest1 vt1;

    public static void main(String[] args) throws InterruptedException {
        vt1 = new int[]{0, 10};
        new Thread(()->{
            System.out.println("子线程开始");
            while (vt1[0]==0){

            }
            System.out.println("子线程结束");
        }).start();
        Thread.sleep(1000);
        vt1 = new int [] {1,11};//直接修改对象引用
        //vt1[0] = 1; //修改应用对象的内部成员
        System.out.println("主线程结束");
//        vt1 = new VolatileTest1();
//        new Thread(()->{
//            System.out.println("子线程开始");
//            while (vt1.number==0){
//
//            }
//            System.out.println("子线程结束");
//        }).start();
//        Thread.sleep(1000);
//        //vt1.number = 1;//修改引用对象的成员值
//        vt1 = new VolatileTest1(1);
//
//        System.out.println("主线程结束");
    }
}
