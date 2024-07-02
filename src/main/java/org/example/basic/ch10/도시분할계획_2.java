package org.example.basic.ch10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 도시분할계획_2 {
    static int N, M, result;
    static int[][] matrix;
    static boolean[] visit;
    static PriorityQueue<Vertex> pqueue = new PriorityQueue<>((v1, v2) -> v1.c - v2.c);
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix = new int[N+1][N+1];
        visit = new boolean[N+1];
        for (int i = 0; i < M; i++) { // M번
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            matrix[v1][v2] = c;
            matrix[v2][v1] = c;
        }

        pqueue.offer(new Vertex(1,0)); // 어떤 점에서 시작해도 똑같으니 0번에서 시작
        int cnt = 0;
        int max = 0;

        while (!pqueue.isEmpty()) {
            Vertex vertex = pqueue.poll();
            if (visit[vertex.v]) continue;
            visit[vertex.v] = true;
            result += vertex.c;
            max = Math.max(max, vertex.c);
            cnt++;
            if (cnt == N) break;

            for (int i = 1; i <= N; i++) {
                if (matrix[vertex.v][i] == 0 || visit[i]) continue;
                pqueue.offer(new Vertex(i, matrix[vertex.v][i]));
            }
        }
        result -= max;
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
