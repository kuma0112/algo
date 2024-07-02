package org.example.basic.ch10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 도시분할계획 {
    static int N, M, result;
    static int[][] matrix;
    static Edge[] edges;
    static int[] parent;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new Edge[M];
        parent = new int[N+1];
        for (int i = 0; i < M; i++) { // M번
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(v1, v2, c);
        }

        Arrays.sort(edges, (e1, e2) -> e1.c - e2. c);
        System.out.println(Arrays.toString(edges));

        makeSet();

        int count = 0;
        int max = 0;
        for (Edge edge : edges) {
            if (union(edge.v1, edge.v2)) {
                result += edge.c;
                count++;
                max = edge.c;
                if (count == N-1) break;
            }
        }

        result -= max;
        System.out.println(result);
    }

    static void makeSet() {
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
    }

    static int findSet(int x) {
        if (parent[x] == x) return x;
        return parent[x] = findSet(parent[x]);
    }

    static boolean union(int x, int y) {
        int px = findSet(x);
        int py = findSet(y);

        if (px == py) return false;

        if (px < py) parent[py] = parent[px];
        else parent[px] = py;

        return true;
    }

    static class Edge{
        int v1, v2, c;
        Edge(int v1, int v2, int c) {
            this.v1 = v1;
            this.v2 = v2;
            this.c = c;
        }
    }
}
