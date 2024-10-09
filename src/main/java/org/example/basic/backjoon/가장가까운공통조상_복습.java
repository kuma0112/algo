package org.example.basic.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장가까운공통조상_복습 {
    static int T;
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine()); // 2

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine()); // 16

            parent = new int[n+1];
            visited = new boolean[n+1];

            for (int j = 1; j < n; j++) { // 1~15 간선의 수
                StringTokenizer st = new StringTokenizer(br.readLine());
                int parentNode = Integer.parseInt(st.nextToken());
                int childNode = Integer.parseInt(st.nextToken());
                parent[childNode] = parentNode;
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(LCA(a,b)).append("\n");
        }
        System.out.println(sb.toString());
    }

    static int LCA(int node1, int node2) {
        while(node1 != 0) {
            visited[node1] = true;
            node1 = parent[node1];
        }

        while(node2 != 0) {
            if (visited[node2]) {
                return node2;
            }
            node2 = parent[node2];
        }
        return -1;
    }
}
