package org.example.basic.ch10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 쿠르스칼 + 간선 리스트
public class 도시분할계획_크루스칼_간선리스트 {
    static int N, M, result;
    static int[] parent;
    static List<Edge> edges = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];

        // 간선 리스트 구성
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edges.add(new Edge(v1, v2, c));
        }

        makeSet();
        Collections.sort(edges, (e1, e2) -> e1.c - e2. c); // comparator 인터페이스

        int count = 0;
        int maxCost = 0;
        for (Edge edge : edges) {
            int v1 = edge.v1;
            int v2 = edge.v2;
            int c = edge.c;

            if (union(v1, v2)) {
                result += c;
                maxCost = c;
                count ++;
                if (count == N-1) break;
            }
        }
        System.out.println(result-maxCost);
    }

    static void makeSet() {
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
    }

    static int findSet(int x) {
        if (parent[x] == x) return x;
        else return parent[x] = findSet(parent[x]); // path compression 버전
    }

    static boolean union(int x, int y) {
        int px = findSet(x);
        int py = findSet(y);
        if (px == py) return false;
        if (px < py) {
            parent[py] = px;
        } else {
            parent[px] = py;
        }
        return true;
    }

    static class Edge {
        int v1, v2, c;
        Edge (int v1, int v2, int c) {
            this.v1 = v1;
            this.v2 = v2;
            this.c = c;
        }
    }
}
