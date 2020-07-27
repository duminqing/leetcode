package com.java.question;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

public class List2Add {
    static List<Object> list = new LinkedList<>();

    void add(Object o) {
        list.add(o);
    }

    int size() {
        return list.size();
    }

    static Thread t1 = null;
    static Thread t2 = null;

    public static void main(String[] args) {
        List2Add listAdd = new List2Add();
        t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                listAdd.add(new Object());
                if (listAdd.size() == 5) {
                    System.out.println("LockSupport.unpark(t2);");
                    LockSupport.unpark(t2);

                    LockSupport.park();
                }
            }
        });
        t2 = new Thread(() -> {
            System.out.println("t2");
            LockSupport.park();
            System.out.println("t2");

            System.out.println("到5了");
            LockSupport.unpark(t1);
        });
        t2.start();
        t1.start();
    }
}
