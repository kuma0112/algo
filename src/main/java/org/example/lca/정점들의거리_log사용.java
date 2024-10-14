package org.example.lca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 정점들의거리_log사용 {
    static int N, log;
    static List<Node>[] tree;
    static int[][] parent;
    static int[] depth;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        // 트리의 최대 깊이 계산하기 (log2(N)를 올림하기)
        log = (int) Math.ceil(Math.log(N) / Math.log(2));

        tree = new ArrayList[N+1];
        parent = new int[N+1][log+1]; // 9 3
        depth = new int[N+1];
        dist = new int[N+1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            tree[a].add(new Node(b, weight));
            tree[b].add(new Node(a, weight));
        }

        dfs(1,0);

        fillParent();

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            int lca = LCA(node1, node2);

            int distance = dist[node1] + dist[node2] - 2 * dist[lca];
            sb.append(distance).append("\n");
        }

        System.out.println(sb.toString());
    }

    static void dfs(int node, int parentNode) {
        for (Node next: tree[node]) {
            if (next.to != parentNode) {
                depth[next.to] = depth[node] + 1;
                dist[next.to] = dist[node] + next.weight;
                parent[next.to][0] = node;
                dfs(next.to, node);
            }
        }
    }

    static void fillParent() {
        for (int i = 1; i <= log; i++) {
            for (int j = 1; j <= N; j++) {
                parent[j][i] = parent[parent[j][i-1]][i-1];
            }
        }
    }

    // 간선 정보를 저장할 Node 클래스
    static class Node {
        int to, weight;
        public Node (int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static int LCA(int node1, int node2) {
        if (depth[node1] < depth[node2]) {
            int temp = node1;
            node1 = node2;
            node2 = temp;
        }

        for (int i = log; i >= 0; i--) {
            if (depth[node1] - (1<<i) >= depth[node2]) {
                node1 = parent[node1][i];
            }
        }

        if (node1 == node2) {
            return node1;
        }

        for (int i = log; i >= 0; i--) {
            if (parent[node1][i] != parent[node2][i]) {
                node1 = parent[node1][i];
                node2 = parent[node2][i];
            }
        }

        return parent[node1][0];
    }
}
