package org.example.lca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class LCA_복습 {
    static int N, M;
    static int[] parent;
    static ArrayList<Integer>[] list;
    static int[] depth;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        list = new ArrayList[N + 1];
        for (int i = 0; i <= N ; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        dfs(1,0);

        M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            sb.append(LCA(node1, node2)).append("\n");
        }
        System.out.println(sb.toString());
    }

    static void dfs(int currentNode, int depthOfNode) {
        visited[currentNode] = true;
        depth[currentNode] = depthOfNode;
        for (int next : list[currentNode]) {
            if (!visited[next]) {
                dfs(next, depthOfNode + 1);
            }
        }
    }

    static int LCA(int node1, int node2) {
        if (depth[node1] > depth[node2]) {
            node1 = parent[node1];
        }
        if (depth[node2] > depth[node1]) {
            node2 = parent[node2];
        }
        while (node1 != node2) {
            node1 = parent[node1];
            node2 = parent[node2];
        }
        return node1;
    }
}
