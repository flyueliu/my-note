package com.zxlab.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {


    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        Code code = new Code(0);
        CountDownLatch latch = new CountDownLatch(4);
        executor.execute(new Watcher(latch,code));

        for (int i = 0; i < 4; i++) {
            executor.execute(new RequestThread(latch,code));
        }

        System.out.println("Main Thread go on..");

    }
}
