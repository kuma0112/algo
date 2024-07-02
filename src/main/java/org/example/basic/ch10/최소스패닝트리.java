package org.example.basic.ch10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소스패닝트리 {
    static int V, E, result;
    static int[][] matrix;
    static boolean[] visit;
    static PriorityQueue<Vertex> pqueue = new PriorityQueue<>((v1, v2) -> v1.c - v2.c);
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        matrix = new int[V+1][V+1];
        visit = new boolean[V+1];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            matrix[v1][v2] = c;
            matrix[v2][v1] = c;
        }

        pqueue.offer(new Vertex(1,0));
        int cnt = 0;

        while (!pqueue.isEmpty()) {
            Vertex vertex = pqueue.poll();
            if (visit[vertex.v]) continue;
            visit[vertex.v] = true;
            result += vertex.c;
            cnt++;
            if (cnt == V) break;

            for (int i = 1; i <= V; i++) {
                if (matrix[vertex.v][i] == 0 || visit[i]) continue;
                pqueue.offer(new Vertex(i, matrix[vertex.v][i])); // 정점번호 i, 비용 vertex.v의 i
            }
        }
        System.out.println(result);
    }

    static class Vertex {
        int v, c;
        Vertex(int v, int c) {
            this.v = v;
            this.c = c;
        }
    }
}
