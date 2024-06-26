package org.example.basic.ch05;

import java.util.ArrayDeque;
import java.util.Queue;

public class bfsdfs_matrix {
    // 정점 1, 2, 3, 4
    // 연결 정보
    // 1 -> 2, 4
    // 2 -> 3, 4
    // 3 -> 2
    // 4 -> 3

    static boolean[][] matrix;
    static boolean[] visit; // 중복 반문 방지
    public static void main(String[] args) {
        // 자료구조
        matrix = new boolean[5][5]; // 0은 더미.
        matrix[1][2] = true;
        matrix[1][4] = true;
        matrix[2][3] = true;
        matrix[2][4] = true;
        matrix[3][2] = true;
        matrix[4][3] = true;

        visit = new boolean[5];

//        bfs(1);
        System.out.println();
        dfs(1);
    }

    static void bfs(int k) { // 시작 정점
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(k);
        visit[k] = true;

        while(!queue.isEmpty()) {
            // 정점을 꺼낸다.
            int v = queue.poll();

            // 필요한 처리를 수행한다.
            System.out.print(v + " -> ");

            // 계속 방문을 이어간다.
            for (int i = 1; i <= 4; i++) {
                if (! matrix[v][i] || visit[i] ) continue;
                queue.offer(i);
                visit[i] = true;
            }
        }
    }

    // stack 대신 동일한 효과를 내고 더 편한 재귀호출을 이용
    static void dfs(int n) { // 시작 정점
        visit[n] = true;

        System.out.print(n + " -> ");

        for (int i = 1; i <= 4; i++) {
            if (! matrix[n][i] || visit[i] ) continue;
            dfs(i);
            visit[i] = true;
        }
    }
}
