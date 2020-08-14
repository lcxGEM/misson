package com.week2;

/**
 * 有序性：
 * ava程序中天然的有序性可以总结为一句话：如果在本线程内观察，所有的操作都是有序的；
 * 如果在一个线程中观察另一个线程，所有的操作都是无序的。
 * 前半句是指“线程内似表现为串行的语义”（Within-Thread As-If-Serial Semantics），
 * 后半句是指“指令重排序”现象和“工作内存与主内存同步延迟”现象。
 * 有序性测试，尽管一般来说有序性很难进行测试，但是任然有办法去测试
 * 输出的结果会有 0 0；1 0；0 1；11
 * 经分析，如果CPU进行了指令重排那么会出现 0 0 的结果，给四个变量加volatile关键字以后不会出现 0 0的现象
 * 如果出现 1 1 的结果可能因为两个线程执行完第一句赋值语句后发生了线程切换（这不是指令重排，可能由cup调度算法造成）
 * 如果将两个赋值语句添加synchronized锁或者lock锁，那么不会出现1 1的结果，此时两句赋值语句有了原子性
 */
public class VolatileTest3 {
    private static  int x = 0, y = 0;
    private static  int a = 0, b =0;
    static Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        while(true){
            i++;
            x = -1; y = -1;
            a = 0; b = 0;
            Thread t1 = new Thread(() -> {
                synchronized (object){
                a = 1;
                x = b;
                }
            });
            Thread t2 = new Thread(() -> {
                synchronized (object){
                b = 1;
                y = a;
               }
            });
            t1.start();t2.start();
            t1.join();t2.join();
            /**
             *  cpu 或者 jit 对代码进行了指令重排
             * 1,1  ||  0,1 || 1,0 ||  0,0
             */
            String result = "第" + i + "次 (" + x + "," + y + "）";
            if(x==0&&y==0) {//因为指令重排导致出现 0 0 或  1 1 的结果
                System.err.println(result);
                break;
            } else {
                System.out.println(result);
            }
        }
    }
}