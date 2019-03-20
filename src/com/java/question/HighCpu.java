package com.java.question;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 如何定位生产环境的高CPU问题
 */
public class HighCpu {
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    // 1 使用 ps aux --sort=-%cpu查看最高的进程 10086
    // 2 使用 top -Hp 10086查看cpu较高的线程 10087
    // 2.5 转换数字10087为16进制数 printf "%x\n" 10087 得到2767
    // 3 使用jstack 10086 |grep 2767 查找到线程名为10086即第22行设置的线程，找到线程里执行的东西
    // 发现有个死循环i++的计算导致cpu一直居高不下
    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            int i = 0;
            while (true) {
                i++;
            }
        });
        thread.setDaemon(true);
        thread.setName("10086");
        thread.start();

        while (true) {
            System.out.println(Thread.currentThread().getName() + "-" + atomicInteger.getAndIncrement());

        }
    }
}
