package com.java.question;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConsumerProducer {
    public static void main(String[] args) throws InterruptedException {
        ConsumerProducer cp = new ConsumerProducer();
        for (int i = 0; i < 5; i++) {
            //   int finalI = i;
            new Thread(() -> {
                for (int j = 0; j < 10; j++) {
                    cp.put(j);
                }
            }).start();
        }
        TimeUnit.SECONDS.sleep(2);
        for (int i = 0; i < 2; i++) {
            int finalI = i;
            new Thread(() -> {
                while (true) {
                    System.out.println("消费者" + finalI + "  " + cp.take());
                }
            }).start();

        }
    }

    private LinkedList<Integer> list = new LinkedList<>();
    private int MAX = 10;
    private int count = 0;
    private Lock lock = new ReentrantLock();
    private Condition producer = lock.newCondition();
    private Condition consumer = lock.newCondition();

    public void put(Integer integer) {
        try {
            lock.lock();
            while (MAX == list.size()) {
                producer.await();
            }
            System.out.println("生产者 " + integer);
            list.add(integer);
            consumer.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public Integer take() {
        Integer integer = null;
        try {
            lock.lock();
            while (list.size() == 0) {
                consumer.await();
            }
            integer = list.removeFirst();
            producer.signalAll();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return integer;
    }
}
