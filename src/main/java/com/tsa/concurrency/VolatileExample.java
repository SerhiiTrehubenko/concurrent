package com.tsa.concurrency;

public class VolatileExample {
    private int x = 0;
//    volatile
    private boolean v = false;
    public void writer() {
        x = 42;
        v = true;
    }

    public void reader() {
        if (v) {
            System.out.printf("x: [%d]", x);
        } else {
            System.out.println("error");
        }
    }
}
