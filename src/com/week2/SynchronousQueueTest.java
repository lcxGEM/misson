package com.week2;

import java.util.concurrent.SynchronousQueue;

/**
 * 阻塞队列
 * 阻塞队列是一种队列，一种可以在多线程环境下使用，并且支持阻塞等待的队列。也就是说，阻塞队列和一般的队列的区别就在于：
 * 1、多线程环境支持，多个线程可以安全的访问队列
 * 2、支持生产和消费等待，多个线程之间互相配合，当队列为空的时候，消费线程会阻塞等待队列不为空；
 * 当队列满了的时候，生产线程就会阻塞直到队列不满。
 *
 */
public class SynchronousQueueTest {
    public static void main(String[] args) throws InterruptedException {
        //创建阻塞队列
        SynchronousQueue<Integer> queue = new SynchronousQueue<Integer>();
        //线程A putThread
        Thread putThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("put线程建立");
                try {
                    Thread.sleep(3000);
                    System.out.println("put线程put数据");
                    queue.put(1);
                } catch (InterruptedException e) {
                }
                System.out.println("put线程结束");
            }
        });
        //线程B takeThread
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("tak线程启动");
                try {
                    System.out.println("take线程等待put对象");
                    System.out.println("put线程中的数据为：" + queue.take());
                } catch (InterruptedException e) {
                }
                System.out.println("tak线程结束");
            }
        }).start();
        putThread.start();

    }
}
