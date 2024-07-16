package org.example.basic.backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 효율적인해킹 {
    static int N, M;
    static List<List<Integer>> adjList;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adjList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 틀련던 부분 1 : adjList.get(a).add(b);
            // 5 3 이라는 입력은 5컴퓨터가 3을 신뢰한다는 의미.
            // 3을 선택했을 때 5까지 영향이 간다는 뜻이므로 그래프를 역방향으로 만들어야 했다.
            adjList.get(b).add(a);

        }


        int[] result = new int[N+1];
        int max = 0;
        for (int i = 1; i <= N; i++) {
            // 틀렸던 부분 2 : visited 배열을 bfs를 호출할 때마다 초기화해야 한다.
            // 완탐이 아니라 각 노드마다의 경로를 찾는 문제이므로!
            visited = new boolean[N+1];
            result[i] = bfs(i);
            max = Math.max(max, result[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <=N ; i++) {
            if (result[i] == max) sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    static int bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            int x = queue.poll();
            for(int next : adjList.get(x)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    count++;
                }
            }
        }
        return count;
    }
}
