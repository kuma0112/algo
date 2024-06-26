package org.example.basic.ch05;

import java.util.LinkedList;
import java.util.Queue;

public class Queue1 {
    public static void main(String[] args) {
        // offer(), poll(), peek()

        Queue<Integer> q = new LinkedList<>();

        q.offer(5);
        q.offer(2);
        q.offer(3);
        q.offer(7);
        q.poll();
        q.offer(1);
        q.offer(4);
        q.poll();

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.poll();
        }
    }
}
