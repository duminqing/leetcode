package com.java.question;

import java.util.concurrent.TimeUnit;

/**
 * 用于测试中断信号
 *
 * @author Administrator
 */
public class TestCaseInterrupt {
    public static void main(String[] args) throws InterruptedException {
        My2 my = new My2();
        my.start();
        TimeUnit.SECONDS.sleep(5);
        my.interrupt();
    }

    static class My extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                if (i == 5) {
                    try {
                        System.out.println("My 准备睡眠");
                        TimeUnit.SECONDS.sleep(10);
                        System.out.println("My 睡醒了");
                    } catch (InterruptedException e) {
                        System.out.println("My 被中断啦");
                        System.out.println("当前状态" + Thread.currentThread().isInterrupted());
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class My2 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                while (i == 5) {
                    System.out.println(this.isInterrupted());
                    if (Thread.interrupted()) {
                        i++;
                    }
                }
            }
        }
    }
}
