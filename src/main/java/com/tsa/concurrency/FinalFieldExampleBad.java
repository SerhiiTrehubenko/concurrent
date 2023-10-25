package com.tsa.concurrency;

public class FinalFieldExampleBad {
    private int x = 3;
    private int y = 4;
    private FinalFieldExampleBad f = this;

    public void readerDependency() {
        int i = 0;
        int j = 0;
        if (f != null) {
            i = f.x;
            j = f.y;
        }
        System.out.printf("i: [%d], j:[%d]; Thread:[%s]%n", i, j, Thread.currentThread().getName());
    }
}
