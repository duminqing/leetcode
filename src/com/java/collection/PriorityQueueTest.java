package com.java.collection;

import java.util.PriorityQueue;

public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < 11; i++) {
            priorityQueue.add(i + 1);
        }
        System.out.println(priorityQueue);
        priorityQueue.add(4);
        System.out.println(priorityQueue);

        priorityQueue.poll();
        System.out.println(priorityQueue);
        priorityQueue.poll();
        System.out.println(priorityQueue);
        priorityQueue.poll();
        System.out.println(priorityQueue);
        priorityQueue.poll();
        System.out.println(priorityQueue);
        int head = 0;
        head = (head - 1) & (8 - 1);
        System.out.println(head);
    }
}
