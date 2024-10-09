package org.example.basic.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장가까운공통조상_3584 {
    static int[] parent;
    static boolean[] visited;
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());

            parent = new int[n + 1];
            visited = new boolean[n + 1];

            for (int i = 1; i < n; i ++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int parentNode = Integer.parseInt(st.nextToken());
                int childNode = Integer.parseInt(st.nextToken());
                parent[childNode] = parentNode;
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            sb.append(findLCA(node1, node2)).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static int findLCA(int node1, int node2) {
        while (node1 != 0) {
            visited[node1] = true;
            node1 = parent[node1];
        }

        while (node2 != 0) {
            if (visited[node2]) {
                return node2;
            }
            node2 = parent[node2];
        }
        return -1;
    }
}
