package com.java.question;

import java.util.concurrent.*;

public class TestCaseSynchronousBlockingQueue {
    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue<Integer> queue = new SynchronousQueue<>(true);
        ExecutorService executorService = new ThreadPoolExecutor(10, 10, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        for (int i = 0; i < 5; i++) {
            // Thread.sleep(1000);

            int finalI = i;
            executorService.submit(() -> {
                try {
                    queue.put(finalI);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        for (int i = 0; i < 5; i++) {


            executorService.submit(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    int a = queue.take();
                    System.out.println(a);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
