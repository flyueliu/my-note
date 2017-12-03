package com.zxlab.thread;

import java.util.concurrent.CountDownLatch;

public class Watcher implements Runnable {

    private CountDownLatch latch;
    private Code code;

    public Watcher(CountDownLatch latch, Code code) {
        this.latch = latch;
        this.code=code;
    }

    @Override
    public void run() {
        System.out.println("start watch request callback......");
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println( "all request callback....");
        System.out.println(code.getNum()+" Thrad execute success....");
        //System.out.println("");

    }
}
