package com.week2;

/**
 * 可重入锁
 * 锁作为并发共享数据保证一致性的工具，大多数内置锁都是可重入的，也就是说，
 * 如果某个线程试图获取一个已经由它自己持有的锁时，那么这个请求会立刻成功，
 * 并且会将这个锁的计数值加1，而当线程退出同步代码块时，计数器将会递减，当计数值等于0时，
 * 锁释放。如果没有可重入锁的支持，在第二次企图获得锁时将会进入死锁状态。可重入锁随处可见：
 * 自定义可重入锁：
 */
public class ReLockTest {
    ReLock lock  = new ReLock();
    public void a() throws InterruptedException {
        lock.lock();
        System.out.println(lock.getHoldCount());
        b();
        lock.unLock();
        System.out.println(lock.getHoldCount());
    }
    //不可重入：带不到下一级方法
    public void b() throws InterruptedException {
        lock.lock();
        System.out.println(lock.getHoldCount());
        System.out.println("--------执行B方法：");
        lock.unLock();
        System.out.println(lock.getHoldCount());
    }

    public static void main(String[] args) throws InterruptedException {
        ReLockTest a = new ReLockTest();
        a.a();
        Thread.sleep(1000);
        System.out.println(a.lock.getHoldCount());
    }
}
class ReLock{
    //是否占用
    private boolean isLocked=false;
    private Thread lockedBy = null;//存储获得锁的线程
    private int holdCount =0;
    //使用
    public synchronized void lock() throws InterruptedException {
        Thread t = Thread.currentThread();
        while(isLocked&&lockedBy!=t) {
            wait();
        }
        isLocked = true;
        lockedBy = t;
        holdCount++;
    }
    //释放
    public synchronized void unLock() {
        if(Thread.currentThread()==lockedBy) {
            holdCount--;
            if(holdCount==0) {
                isLocked=false;
                notify();
                lockedBy=null;
            }
        }
    }
    public int getHoldCount() {
        return holdCount;
    }
}
