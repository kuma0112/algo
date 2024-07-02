package org.example.basic.dyjkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 파티 {
    static int N,M,X;
    static List<List<Node>> adjList = new ArrayList<>();
    static List<List<Node>> reverseAdjList = new ArrayList<>();
    static int[] distanceToParty;
    static int[] distanceFromParty;
    static PriorityQueue<Node> pqueue = new PriorityQueue<>((n1, n2) -> n1.c - n2.c);

    static class Node {
        int v, c;
        Node (int v, int c) {
            this.v = v;
            this.c = c;
        }

    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); // 4 8 2

        N = Integer.parseInt(st.nextToken()); // 4
        M = Integer.parseInt(st.nextToken()); // 8
        X = Integer.parseInt(st.nextToken()); // 2

        for (int i = 0; i < N+1; i++) { // N+1번
            adjList.add(new ArrayList<>());
            reverseAdjList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) { // M번
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adjList.get(a).add(new Node(b, c));
            reverseAdjList.get(b).add(new Node(a, c));
        }

        distanceToParty = new int[N + 1];
        distanceFromParty = new int[N + 1];

        HomeToParty(X);
        PartyToHome(X);

        int maxDistance = 0;
        for (int i = 1; i <= N; i++) { // N번
            maxDistance = Math.max(maxDistance, distanceToParty[i] + distanceFromParty[i]);
        }
        System.out.println(maxDistance);
    }

    static void HomeToParty(int X) {
        int[] cost = new int[N + 1];
        boolean[] visit = new boolean[N + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);

        pqueue.offer(new Node(X, 0));
        cost[X] = 0;
        while (!pqueue.isEmpty()) {
            Node node = pqueue.poll();

            if (visit[node.v]) continue;
            visit[node.v] = true;

            for (Node n: reverseAdjList.get(node.v)) {
                if (visit[n.v]) continue;
                if (cost[n.v] > cost[node.v] + n.c) {
                    cost[n.v] = cost[node.v] + n.c;
                    distanceToParty[n.v] = cost[n.v];
                    pqueue.offer(new Node(n.v, cost[n.v]));
                }
            }
        }
    }

    static void PartyToHome(int x) {
        int[] cost = new int[N + 1];
        boolean[] visit = new boolean[N + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);

        pqueue.offer(new Node(X, 0));
        cost[X] = 0;
        while (!pqueue.isEmpty()) {
            Node node = pqueue.poll();

            if (visit[node.v]) continue;
            visit[node.v] = true;

            for (Node n: adjList.get(node.v)) {
                if (visit[n.v]) continue;
                if (cost[n.v] > cost[node.v] + n.c) {
                    cost[n.v] = cost[node.v] + n.c;
                    distanceFromParty[n.v] = cost[n.v];
                    pqueue.offer(new Node(n.v, cost[n.v]));
                }
            }
        }
    }
}
