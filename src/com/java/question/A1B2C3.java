package com.java.question;

import java.util.concurrent.locks.LockSupport;

public class A1B2C3 {
    Thread t1;
    Thread t2;

    public static void main(String[] args) {
        A1B2C3 a1B2C3 = new A1B2C3();
        char ca = 'A';
        char c1 = '1';
        a1B2C3.t1 = new Thread(() -> {
            for (int i = 0; i < 26; i++) {
                System.out.print((char) (ca + i));
                LockSupport.unpark(a1B2C3.t2);

                LockSupport.park();
            }
        });

        a1B2C3.t2 = new Thread(() -> {
           // LockSupport.park();
            for (int i = 1; i <= 26; i++) {
                System.out.print(i);
                LockSupport.park();
                LockSupport.unpark(a1B2C3.t1);
            }
        });

        a1B2C3.t1.start();
        a1B2C3.t2.start();
    }
}
