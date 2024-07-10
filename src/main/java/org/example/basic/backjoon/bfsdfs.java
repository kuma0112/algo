package org.example.basic.backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class bfsdfs {
    static int N, M, V;
    static List<List<Integer>> adjList;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        adjList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        visited = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }

        for (int i = 1; i <= N ; i++) {
            Collections.sort(adjList.get(i));
        }

        dfs(V);
        System.out.println();

        Arrays.fill(visited, false);

        bfs(V);
    }

    static void dfs(int start){
        visited[start] = true;
        System.out.println(start + " ");

        for (int next : adjList.get(start)) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    static void bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.println(current + " ");

            for (int next : adjList.get(current)) {
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
    }
}
