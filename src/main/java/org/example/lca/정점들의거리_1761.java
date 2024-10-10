package org.example.lca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 정점들의거리_1761 {
    static int N, M;
    static int[][] distance, node;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        node = new int[N+1][N+1];
        distance = new int[N+1][N+1];

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            node[a][b] = 1;
            node[b][a] = 1;
            distance[a][b] = dist;
            distance[b][a] = dist;
        }

        M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
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

        visited[node1] = true;
        queue.add(node1);
        int[] answer = new int[N+1];

        while(!queue.isEmpty()) {
            int current = queue.poll();
            for (int i = 1; i <= N; i++) {
                // 만약 두 노드가 이어져 있고 아직 방문하지 않았다면
                if (node[current][i] == 1 && !visited[i]) {
                    // 현재까지의 거리 + i까지의 거리를 더해서 거리를 갱신한다.
                    answer[i] = answer[current] + distance[current][i];

                    // 만약 node1에서 node2까지 도달하면
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

