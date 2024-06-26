package org.example.basic.ch05;

import java.util.*;

// LinkedList -> ArrayDeque
public class Queue4 {
    public static void main(String[] args) {
//        {
//            // Integer
//            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
//            priorityQueue.offer(3);
//            priorityQueue.offer(2);
//            priorityQueue.offer(7);
//            priorityQueue.offer(5);
//            priorityQueue.offer(9);
//
////            while (!priorityQueue.isEmpty()) {
////                System.out.println(priorityQueue.poll());
////            }
//
//            for (Integer i : priorityQueue) { // 입력순 아님
//                System.out.println(i);
//            }
//        }

//        {
//            // String
//            PriorityQueue<String> priorityQueue = new PriorityQueue<>();
//            priorityQueue.offer("b3");
//            priorityQueue.offer("a2");
//            priorityQueue.offer("x7");
//            priorityQueue.offer("d5");
//            priorityQueue.offer("s9");
//
//            while (!priorityQueue.isEmpty()) {
//                System.out.println(priorityQueue.poll());
//            }
//        }

//        {
//            PriorityQueue<Node> priorityQueue = new PriorityQueue<>((n1, n2) -> n1.y - n2. y);
//            priorityQueue.offer(new Node(3, 5, 2));
//            priorityQueue.offer(new Node(7, 1, 4));
//            priorityQueue.offer(new Node( 5, 2, 9));
//            priorityQueue.offer(new Node(1, 1, 5));
//
//            while (!priorityQueue.isEmpty()) {
//                System.out.println(priorityQueue.poll()); // 노드 정렬기준 몰라서 에러남
//                // 정렬 조건 추가하는 방법 3가지 : class에 Comparable interface implement,
//                                            // anynomous 객체, 람다
//            }
//
//        }


        {
            PriorityQueue<int[]> queue = new PriorityQueue<>((a1, a2) -> a1[0] - a2[0]);
            queue.offer(new int[]{-3, 0, 1});
            queue.offer(new int[]{1, 2, 3});
            queue.offer(new int[]{7, 4, -3});
            queue.offer(new int[]{6, 5, 7});

            while (! queue.isEmpty()) {
                System.out.println(Arrays.toString(queue.poll()));
            }

        }
    }



    static class Node implements Comparable<Node> {
        int y, x, c;
        Node(int y, int x, int c) {
            this.y = y;
            this.x = x;
            this.c = c;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "y=" + y +
                    ", x=" + x +
                    ", c=" + c +
                    '}';
        }

        @Override
        public int compareTo(Node o) {
            return this.y == o.y ? this.x - o.x : this.y - o.y;
        }
    }

}
