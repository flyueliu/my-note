package com.zxlab.thread;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class RequestThread implements Runnable {

    private Code num;
    private CountDownLatch latch;

    private Random r = new Random();

    public RequestThread(CountDownLatch latch, Code number) {
        this.num = number;
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "start execute request..");
        int number = r.nextInt(10000);
        try {
            Thread.sleep(number);
            if (number % 2 == 0) {
                num.increment();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        latch.countDown();
        System.out.println(Thread.currentThread().getName() + "finish xecute request,speed "+number+" millis..");
    }
}
