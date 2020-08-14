package com.week2;

/**
 * 在多线程情况下每个线程都有自己的数据。一个线程使用自己的局部变量比使用全局变量好，因为局部变量只有自己能看到，不会影响其他线程；
 * ThreadLocal能够在每个线程内部放置一个独立变量，就是在多线程环境下保证变量的独立性，只由本线程操作；
 */
public class ThreadLocalTest {
    // static ThreadLocal<Integer> threadLocal = new ThreadLocal<>(); //创建ThreadLocal存储空间
//     private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>() {   //初始化threadLocal存储的值
//            protected Integer initialValue() {//匿名内部类，重写initialValue方法
//                   return 5;
//            }
//     };
//     private static ThreadLocal<Integer> threadLocal =  ThreadLocal.withInitial(()->5);

    /* ThreadLocal的子类，使用该类，子线程在初始化之前会复制父线程的ThreadLocal值
     * 如下面代码所示，main线程创建了五个AThread线程，所以main线程是父线程，AThread线程是子线程
     * 此时子线程初始值与父线程当前值一致
     */
    private static ThreadLocal<Integer> threadLocal = new  InheritableThreadLocal<>();
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+"=======>"+threadLocal.get());//获取主线程在ThreadLocal中存储的值
        for (int i = 0; i < 5; i++) {
            new Thread(new AThread()).start();
            /*
             * 证明子线程创建时拷贝的是当前父线程的值:
             * 运行结果：
             * main=======>null
             * Thread-0修改前====>null
             * Thread-1修改前====>null
             * Thread-2修改前====>null
             * Thread-0修改后====>11
             * Thread-1修改后====>73
             * Thread-2修改后====>19
             * Thread-3修改前====>20 i==3的时候父线程的值变为20
             * Thread-4修改前====>20
             * Thread-4修改后====>97
             * Thread-3修改后====>45
             */
            if(i==2) {
                threadLocal.set(20);
            }
        }
    }
    public static class AThread implements Runnable{
        public AThread() {//调用构造器创建thread对象时，线程仍未主线程，因此，构造器里面的线程为调用new 所在的线程
//                   threadLocal.set(4444);//此时主线程调用new 所以修改的是主线程的threadLocal值
//                   System.out.println(Thread.currentThread().getName()+"构造器中====>"+threadLocal.get());
        }
        @Override
        public void run() {//线程自身
            System.out.println(Thread.currentThread().getName()+"修改前====>"+threadLocal.get());//获取子类线程在ThreadLocal中存储的值
            threadLocal.set((int)(Math.random()*99));
            System.out.println(Thread.currentThread().getName()+"修改后====>"+threadLocal.get());//获取子类线程在ThreadLocal中存储的值
        }
    }
}
