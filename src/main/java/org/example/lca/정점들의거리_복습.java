package org.example.lca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 정점들의거리_복습 {
    static int N, M;
    static int[][] node;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        node = new int[N+1][N+1];

        for (int i = 1; i < N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            node[a][b] = dist;
            node[b][a] = dist;
        }

        M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            sb.append(bfs(node1, node2)).append("\n");
        }
        System.out.println(sb.toString());
    }

    static int bfs(int node1, int node2) {
        Queue<Integer> queue = new ArrayDeque<>();
        visited = new boolean[N+1];
        queue.add(node1);

        visited[node1] = true;
        int[] answer = new int[N+1];

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int i = 1; i <= N ; i++) {
                if (node[current][i] != 0 && !visited[i]) {
                    answer[i] = answer[current] + node[current][i];

                    if (i == node2) {
                        return answer[node2];
                    }

                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        return -1;
    }
}
