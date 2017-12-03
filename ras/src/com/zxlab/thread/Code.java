package com.zxlab.thread;

public class Code {

    private int num;

    public Code(int num) {
        this.num = num;
    }

    public synchronized void increment() {
        this.num++;
    }

    public int getNum() {
        return this.num;
    }
}
