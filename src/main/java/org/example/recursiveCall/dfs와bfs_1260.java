package org.example.recursiveCall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class dfs와bfs_1260 {
    static int N, M, Root;
    static boolean[][] matrix;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Root = Integer.parseInt(st.nextToken());

        matrix = new boolean[N+1][N+1];
        visited = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            matrix[a][b] = true;
            matrix[b][a] = true;
        }

        dfs(Root);
        System.out.println();
        Arrays.fill(visited, false);

        bfs(Root);
    }

    static void dfs(int root) {
        visited[root] = true;

        System.out.print(root + " ");

        for (int i = 1; i <= N; i++) {
            if (matrix[root][i] && !visited[i]) {
                dfs(i);
            }
        }
    }

    static void bfs(int root) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);
        visited[root] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            System.out.print(curr + " ");
            for (int i = 1; i <= N; i++) {
                if (matrix[curr][i] && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
