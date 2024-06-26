package org.example.basic.ch05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bfsdfs_practice {
    static int n,m,v;
    static boolean[][] matrix;
    static boolean[] visit; // 중복 방문 방지

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        matrix = new boolean[n + 1][n + 1];
        visit = new boolean[n + 1];


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int j = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            matrix[j][k] = true;
            matrix[k][j] = true;
        }

        dfs(v);
        for (int i = 0; i <= n; i++) {
            visit[i] = false;
        }
        System.out.println();
        bfs(v);
    }

    static void dfs (int k) {
        visit[k] = true;

        System.out.print(k + " ");

        for (int i = 1; i <= n; i++) {
            if (! matrix[k][i] || visit[i] ) continue;
            dfs(i);
        }
    }

    static void bfs(int k) { // 시작 정점
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(k);
        visit[k] = true;

        while(!queue.isEmpty()) {
            int v = queue.poll();

            System.out.print(v + " ");

            for (int i = 1; i <= n; i++) {
                if (! matrix[v][i] || visit[i] ) continue;
                queue.offer(i);
                visit[i] = true;
            }
        }
    }
}
