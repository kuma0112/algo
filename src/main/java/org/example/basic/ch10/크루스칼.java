package org.example.basic.ch10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// MST를 구하는 크루스칼 알고리즘 예시
// 간선을 정렬해서 가장 비용이 적은 선부터 적용할 예정. 즉, 간선 중심이며 간선 리스트가 필요함.
public class 크루스칼 {
    static int V, E, result; // MST 총 비용을 담을 result
    static int[] parent;
    static Edge[] edges; // 간선 리스트
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        parent = new int[V];
        edges = new Edge[E];

        // 입력 처리
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(v1, v2, c);
        }

        // 쿠르스칼 알고리즘
        // 1. 간선 정렬
        Arrays.sort(edges, (e1, e2) -> e1.c - e2.c);

        // 2. 정점이 V개니까, V-1개의 간선이면 최소로 연결 가능. + 사이클 체크
        // 2-1. 집합 배열 처리
        makeSet();

        int cnt = 0; // V-1개가 될 때까지
        for (Edge edge : edges) {
            if (union(edge.v1, edge.v2)) {
                result += edge.c;
                cnt ++;
                if (cnt == V-1) {
                    break;
                }
            }
        }
        System.out.println(result);
    }

    static void makeSet() {
        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }
    }

    static int findSet(int x) {
        if (parent[x] == x) return x;
        return parent[x] = findSet(parent[x]);
    }

//    static void union(int x, int y) {
//        int px = findSet(x);
//        int py = findSet(y);
//        if (px < py) parent[py] = parent[px];
//        else parent[px] = py;
//    }

    // 크루스칼 사용 버전
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
/*
정점수 간선수
시작정점 끝정점 가중치
5 10
0 1 5
0 2 10
0 3 8
0 4 7
1 2 5
1 3 3
1 4 6
2 3 1
2 4 3
3 4 1
==>10
----------------------------------
7 11
0 1 3
0 2 17
0 3 6
1 3 5
1 6 12
2 4 10
2 5 8
3 4 9
4 5 4
4 6 2
5 6 14
==>31
 */