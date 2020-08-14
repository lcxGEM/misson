package com.week2;

import java.util.concurrent.Exchanger;

/**
 * 当一个线程到达exchange调用点时，如果它的伙伴线程此前已经调用了此方法，那么它的伙伴会被调度唤醒并与之进行对象交换，
 * 然后各自返回。如果它的伙伴还没到达交换点，那么当前线程将会被挂起，直至伙伴线程到达——完成交换正常返回；
 * 或者当前线程被中断——抛出中断异常；又或者是等候超时——抛出超时异常。
 */
public class ExchangerTest {
    public static void main(String[] args) {
        Exchanger exchanger = new Exchanger();
        new Thread(new AThread("aaa",exchanger)).start();
        new Thread(new AThread("bbb",exchanger)).start();
    }
}

class AThread implements Runnable{

    public String msg;
    public Exchanger exchanger;
    public AThread(String msg,Exchanger exchanger){
        this.msg = msg;
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread()+"线程，准备交换，数据为："+msg);
            Thread.sleep(5000);
            exchanger.exchange(msg);
            System.out.println(Thread.currentThread()+"线程，交换结束，数据为："+msg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
