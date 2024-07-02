package org.example.basic.dyjkstra;

import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Practice {
    static final int INF = (int) 1e9; // 변수명이 왜이러지? 이걸 왜 int로 캐스팅하지?
    static int n,m,start;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>(); // 노드 배열을 받는 배열
    static int[] distance;

    static class Node implements Comparable<Node> { // comparable, comparator 헷갈림
        int index, cost; // 인덱스와 비용을 가지는 노드 클래스.
        Node (int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost); // compare() 은 뭐지?
        }
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>(); // 프라이러리티 큐가 뭔지 잘 기억이 안나네.
        pq.offer(new Node(start, 0)); // start는 static으로 이미 0 초기화. 비용도 0.
        distance[start] = 0; // 거리 배열이 따로 있다! 초기화는 언제 하지?

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int dist = node.cost;
            int now = node.index;

            if (distance[now] < dist) continue;

            for (Node neighbor : graph.get(now)) {
                int cost = dist + neighbor.cost;
                if (cost < distance[neighbor.index]) {
                    distance[neighbor.index] = cost;
                    pq.offer(new Node(neighbor.index, cost));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        distance = new int[n + 1];
        Arrays.fill(distance, INF);

        start = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
        }

        dijkstra(start);

        for (int i = 1; i <= n; i++) {
            if (distance[i] == INF) {
                System.out.println("INFINITY");
            } else {
                System.out.println(distance[i]);
            }
        }
    }

}
