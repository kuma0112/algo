package org.example.lca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 정점들의거리_dfs {
    static int N;
    static List<Node>[] tree;
    static int[] depth;
    static int[] dist;

    static class Node {
        int to, weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N + 1];
        depth = new int[N + 1];
        dist = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            tree[u].add(new Node(v, w));
            tree[v].add(new Node(u, w));
        }

        // DFS로 각 노드의 깊이와 루트까지의 거리 계산
        dfs(1, 0, 0);

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int distance = Math.abs(dist[u] - dist[v]);  // 두 노드 간의 거리
            sb.append(distance).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int node, int parent, int d) {
        depth[node] = depth[parent] + 1;
        dist[node] = d;

        for (Node next : tree[node]) {
            if (next.to != parent) {
                dfs(next.to, node, d + next.weight);
            }
        }
    }
}
