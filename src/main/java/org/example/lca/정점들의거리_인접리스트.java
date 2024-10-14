package org.example.lca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 정점들의거리_인접리스트 {
    static int N, M;
    static List<List<Edge>> adjList;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        adjList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }


        for (int i = 1; i < N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            adjList.get(a).add(new Edge(b, dist));
            adjList.get(b).add(new Edge(a, dist));
        }

        M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            sb.append(bfs(node1, node2)).append("\n");
        }
        System.out.println(sb.toString());
    }

    static int bfs(int node1, int node2) {
        Queue<Edge> queue = new ArrayDeque<>();
        visited = new boolean[N+1];
        queue.add(new Edge(node1, 0));

        visited[node1] = true;

        while (!queue.isEmpty()) {
            Edge current = queue.poll();
            int currentNode = current.to;
            int currentDist = current.distance;

            if (currentNode == node2) {
                return currentDist;
            }

            for (Edge edge : adjList.get(currentNode)) {
                if (!visited[edge.to]) {
                    visited[edge.to] = true;
                    queue.add(new Edge(edge.to, currentDist + edge.distance));
                }
            }
        }
        return -1;
    }

    static class Edge {
        int to, distance;

        Edge(int to, int distance) {
            this.to = to;
            this.distance = distance;
        }
    }
}
