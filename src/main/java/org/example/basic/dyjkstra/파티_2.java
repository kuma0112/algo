package org.example.basic.dyjkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
// 다익스트라
// 그래프 자료구조 : 인접 리스트
public class 파티_2 {
    static int N,M,X, max;
    static final int INF = Integer.MAX_VALUE;
    static List<List<Node>> goList = new ArrayList<>();
    static List<List<Node>> backList = new ArrayList<>();
    static int[] goCost;
    static int[] backCost;
    static boolean[] visit;
    static PriorityQueue<Node> pqueue = new PriorityQueue<>((n1, n2) -> n1.t - n2.t);

    static class Node {
        int v, t;
        Node (int v, int t) {
            this.v = v;
            this.t = t;
        }

    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); // 4 8 2

        N = Integer.parseInt(st.nextToken()); // 4
        M = Integer.parseInt(st.nextToken()); // 8
        X = Integer.parseInt(st.nextToken()); // 2

        for (int i = 0; i < N+1; i++) { // N+1번
            goList.add(new ArrayList<>());
            backList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) { // M번
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            goList.get(a).add(new Node(b, c));
            // a -> b 길 중에 분명히 x로 가는 최단 경로가 존재함. 뒤집으면 그 길이 x -> 집 일 것.
            backList.get(b).add(new Node(a, c));
        }

        max = Integer.MIN_VALUE;

        goCost = new int[N + 1];
        backCost = new int[N + 1];
        visit = new boolean[N + 1];

        dijkstra(goList, goCost);
        dijkstra(backList, backCost);

        for (int i = 1; i <= N; i++) { // N번
            max = Math.max(max, goCost[i] + backCost[i]);
        }
        System.out.println(max);
    }

    static void dijkstra(List<List<Node>> list, int[] cost) {
        // cost, visit 초기화
        Arrays.fill(cost, INF);
        Arrays.fill(visit, false);

        // 시작점 X
        cost[X] = 0;
        pqueue.offer(new Node(X, 0));

        while (!pqueue.isEmpty()) {
            Node node = pqueue.poll();
            if (visit[node.v]) continue;
            visit[node.v] = true;

            for(Node n : list.get(node.v)) {
                if (visit[n.v]) continue;
                if (cost[n.v] > cost[node.v] + n.t ) {
                    cost[n.v] = cost[node.v] + n.t;
                    pqueue.offer(new Node(n.v, cost[n.v]));
                }
            }
        }
    }

}
