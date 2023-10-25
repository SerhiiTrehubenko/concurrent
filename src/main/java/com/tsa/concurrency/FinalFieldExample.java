package com.tsa.concurrency;

public class FinalFieldExample {
    private final int x;
    private int y;
    private static FinalFieldExample f;

    public FinalFieldExample() {
        x = 3;
        y = 4;
    }

    public void writer() {
        f = new FinalFieldExample();
        System.out.println(Thread.currentThread().getName());
    }

    public void readerDependency() {
        int i = 0;
        int j = 0;
        if (f != null) {
            i = f.x;
            j = f.y;
        }
        System.out.printf("i: [%d], j:[%d]; Thread:[%s]%n", i, j, Thread.currentThread().getName());
    }

    public void readerThis() {
        System.out.printf("x: [%d], y:[%d]; Thread:[%s]%n", x, y, Thread.currentThread().getName());
    }
}
