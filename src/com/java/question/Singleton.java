package com.java.question;

public class Singleton {

    // volatile防止指令重排序

    private volatile static Singleton instance;

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    // 1.申请内存赋给初始值零值
                    // 2.赋值
                    // 3.引用到栈中
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
