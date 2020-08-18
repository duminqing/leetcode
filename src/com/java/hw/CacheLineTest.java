package com.java.hw;

public class CacheLineTest {

    long p1, p2, p3, p4, p5, p6, p7;
    volatile long index1;
    long p8, p9, p10, p11, p12, p13, p14;
    volatile long index2;
    long p21, p22, p23, p24, p25, p26, p27;

    public static void main(String[] args) throws InterruptedException {

        CacheLineTest test = new CacheLineTest();
        long begin = System.currentTimeMillis();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000_000_000; i++) {
                test.index1 = i;
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000_000_000; i++) {
                test.index2 = i;
            }
        });
        t1.join();
        t2.join();
        System.out.println(System.currentTimeMillis() - begin);
    }


}
