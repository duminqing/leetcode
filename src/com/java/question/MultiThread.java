package com.java.question;

import java.util.concurrent.TimeUnit;

public class MultiThread {

    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();
        new Thread(new T("A",o)).start();
        TimeUnit.SECONDS.sleep(1L);
        new Thread(new T("B",o)).start();
        //new Thread(new T("C",o)).start();
    }

    static class T implements Runnable {
        private String name;

        private final Object lock;

        public T(String name, Object lock) {
            this.name = name;
            this.lock = lock;
        }


        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < 5; i++) {
                    System.out.println(name + i);
                    lock.notify();
                    try {
                        TimeUnit.SECONDS.sleep(1L);
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
    }

}
