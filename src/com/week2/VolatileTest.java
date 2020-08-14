package com.week2;

import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 原子性：原子性指一个或多个操作要么全部执行，要么全部不执行
 * java中可以保证原子性操作的情况： 简单赋值：a = 0; a = true; 读取操作
 * 例如：a = b; a = b+1; a++ 这些操作涉及到读一个数据后再赋值或计算，并非原子操作
 * java保证原子性的方法：synchronized锁、Lock锁、原子操作类CAS机制
 */
public class VolatileTest {

    public static  int a = 0;

    //原子操作类
    public static AtomicInteger b = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Vector<Thread> threads = new Vector<>();
        Lock lock = new ReentrantLock();
//        for (int i = 0; i < 10000; i++) {
//            new Thread(()->{
//                a++;
//            }).start();
//        }
        //syn测试
//        VolatileTest vt = new VolatileTest();
//        for (int i = 0; i < 10000; i++) {
//            new Thread(new synTest(vt)).start();
//        }
        //lock锁测试
//        VolatileTest vt = new VolatileTest();
//        for (int i = 0; i < 10000; i++) {
//            Thread a = new Thread(new LockTest(vt,lock));
//            threads.add(a);
//            a.start();
//        }
        //原子类测试
        for (int i = 0; i < 10000; i++) {
            Thread thread = new Thread(()->{
                b.addAndGet(1);
            });
            threads.add(thread);
            thread.start();
        }
        for (Thread a: threads) {
            a.join();
        }
        System.out.println(b);
    }
}
//synchronized锁
class synTest implements Runnable{

    public VolatileTest vt;

    public synTest(VolatileTest vt){
        this.vt = vt;
    }
    @Override
    public void run() {
        synchronized (vt){
            vt.a++;
        }
    }
}
//Lock锁
class LockTest implements Runnable{

    VolatileTest vt;
    Lock lock;

    public LockTest(VolatileTest vt,Lock lock){
        this.vt = vt;
        this.lock =lock;
    }

    @Override
    public void run() {

        lock.lock();
        try{
            vt.a++;
        }finally {
            lock.unlock();
        }
    }
}
