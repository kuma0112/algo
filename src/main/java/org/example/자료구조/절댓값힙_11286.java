package org.example.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class 절댓값힙_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> {
            int absA = Math.abs(a);
            int absB = Math.abs(b);
            if (absA != absB) return absA - absB;
            return a - b;
        });
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine());
            if (a != 0) {
                queue.add(a);
            } else {
                if (!queue.isEmpty()) {
                    sb.append(queue.poll()).append("\n");
                } else sb.append(0).append("\n");
            }
        }
        System.out.println(sb);
    }
}
