package org.example.basic.dyjkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 전보 {

/*
3 2 1
1 2 4
1 3 2
 */
    static int n, m, c;
    static int[] cost;
    static boolean[] visit;
    static int INF = Integer.MAX_VALUE;
    static List<List<Node>> adjList = new ArrayList<>();
    static PriorityQueue<Node> pqueue = new PriorityQueue<>((n1, n2) -> n1.t - n2.t);

    static class Node {
        int v, t;
        Node(int v, int t) {
            this.v = v;
            this.t = t;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 3
        m = Integer.parseInt(st.nextToken()); // 2
        c = Integer.parseInt(st.nextToken()); // 1

        for (int i = 0; i <= n; i++) { // n+1개. 0은 더미.
            adjList.add(new ArrayList<>());
        }

        cost = new int[n+1]; // 왜 n+1개지?
        visit = new boolean[n+1];


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); // 1
            int y = Integer.parseInt(st.nextToken()); // 2
            int z = Integer.parseInt(st.nextToken()); // 4
            adjList.get(x).add(new Node(y, z));
        }

        // 다익스트라 풀이
        dijkstra(c);

        // 도착한 도시 (INF가 아닌 도시 수), 총 걸린 시간 (max 시간)
        int receiveCnt = 0;
        int maxTime = 0;

        for (int i = 1; i <= n; i++) {
            if (cost[i] == INF) continue; // 도착 못함. 스킵
            receiveCnt ++; // 도착했으니 카운트 +1
            maxTime = Math.max(maxTime, cost[i]);
        }

        // 시작 도시는 뺀다. 받은 도시만 계산해야 되기 때문!
        System.out.println((receiveCnt-1) + " " + maxTime);

    }

    static void dijkstra(int s) {
        Arrays.fill(cost, INF);

        cost[s] = 0;
        pqueue.offer(new Node(s, 0));

        while (!pqueue.isEmpty()) {
            Node node = pqueue.poll();
            if (visit[node.v]) continue;
            visit[node.v] = true;

            for (Node n : adjList.get(node.v)) {
                if (visit[n.v]) continue;
                if (cost[n.v] > cost[node.v] + n.t) {
                    cost[n.v] = cost[node.v] + n.t;
                    pqueue.offer(new Node(n.v, cost[n.v]));
                }
            }
        }

    }
}
