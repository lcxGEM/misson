package com.week2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可见性：当同时有多个线程，一个线程修改共享变量其他线程可以立即发现，称为该变量是可见的
 * 可见性实现的方式：1、volatile关键字 2、加锁（synchronized或者Lock） 3、原子类CAS机制
 * 缓存一致性协议：
 * 每个处理器通过嗅探在总线上传播的数据来检查自己缓存的值是不是过期了，当处理器发现自己缓存行对应的内存地址被修改，
 * 就会将当前处理器的缓存行设置成无效状态，当处理器要对这个数据进行修改操作的时候，会强制重新从系统内存里把数据读到处理器缓存里。
 * volatile 实现可见性的原理：
 * 如果对声明了volatile的变量进行写操作，JVM就会向处理器发送一条Lock前缀的指令。、将这个变量所在缓存行的数据写回到系统内存。
 * 根据缓存一致性协议，这个写回内存的操作改变主内存的值后会使在其他CPU里缓存了该内存地址的数据无效。
 * 处理器会通过嗅探技术，强制重新从系统内存里把数据读到处理器缓存里；
 */
public class VolatileTest1 {
    //volatile int number = 0;//实现1：volatile保证可见性，主线程在Thread线程修改变量以后直接结束

    //实现2 ，使用synchronized锁
    int number = 0;

    //原子类
    AtomicInteger nu = new AtomicInteger(0);

    public VolatileTest1(){

    }

    public VolatileTest1(int number){
        this.number = number;
    }
//    public synchronized int getNumber(){//synchronized锁保证获取值的时候获取一致数据，从而保证变量可见性（如果不用get方法，直接访问变量仍然是不可见的）
//        return this.number;
//    }

//    public void addTo60() {
//        this.number = 60;
//    }

    //实现3：使用lock锁
    public int getNumber(){//在获取值时用lock锁同步
//        ReentrantLock lock = new ReentrantLock();
//        lock.lock();
//        try {
//            return  this.number;
//        } finally {
//            lock.unlock();
//        }
        return this.number;
    }

    public void addTo60() {
        this.number = 60;
    }

    public static void main(String[] args) {
        VolatileTest1 vt = new VolatileTest1();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "线程启动");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //vt.addTo60();
            vt.nu.addAndGet(10);
            System.out.println(Thread.currentThread().getName() + "线程结束，number值：" + vt.getNumber());

        }, "A").start();
        //主线程
//        while (vt.getNumber() == 0) {
//            //main线程就一直等待循环，直到number的值不等于0
//        }
        //原子类测试、
        while (vt.nu.get()==0){

        }
        System.out.println(Thread.currentThread().getName() + "主线程结束，num值：" + vt.getNumber());
    }
}