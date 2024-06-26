package org.example.basic.ch05;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

// LinkedList -> ArrayDeque
public class Queue2 {
    public static void main(String[] args) {
        // 구현체만 교체!
        Queue<Integer> q = new ArrayDeque<>();

        // arraydeque는 스택, 큐 모두 구현이 가능하다.
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
