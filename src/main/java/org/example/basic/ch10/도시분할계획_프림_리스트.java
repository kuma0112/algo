 package org.example.basic.ch10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 프림 + 인접 리스트
public class 도시분할계획_프림_리스트 {
    static int N, M, result;
    static List<List<Vertex>> adjList = new ArrayList<>();
    static boolean[] visit;
    static PriorityQueue<Vertex> pqueue = new PriorityQueue<>((v1, v2) -> v1. c - v2. c);
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }
        visit = new boolean[N+1];

        // 간선 리스트 구성
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adjList.get(v1).add(new Vertex(v2, c));
            adjList.get(v2).add(new Vertex(v1, c));
        }

        visit[1] = true;
        pqueue.addAll(adjList.get(1)); // 컬렉션에 있는 친구들을 한꺼번에 큐에 추가한다.
        // offerAll()은 없다

        int count = 1;
        int maxCost = 0;

        while (!pqueue.isEmpty()) {
            Vertex vertex = pqueue.poll();

            if (visit[vertex.v]) continue;
            visit[vertex.v] = true;

            result += vertex.c;
            maxCost = Math.max(maxCost, vertex.c);
            count++;
            if (count == N) break;
            for (Vertex v : adjList.get(vertex.v)) {
                if (visit[v.v]) continue;
                pqueue.offer(new Vertex(v.v, v.c));
            }
        }

        System.out.println(result-maxCost);
    }

    static class Vertex {
        int v, c;

        Vertex (int v, int c) {
            this.v = v;
            this.c = c;
        }
    }
}
