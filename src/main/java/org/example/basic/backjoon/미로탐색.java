package org.example.basic.backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색 {
    static int N, M, count;
    static char[][] map;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 틀린 부분 1 : map을 N+1, M+1 로 만들려고 했는데
        // 0,0부터 N-1, M-1 탐색이 훨씬 간단하다!
        map = new char[N][];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        visited = new boolean[N][M];
        int result = bfs(0, 0);
        System.out.println(result);
    }

    static int bfs(int y, int x) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(y, x));
        visited[y][x] = true;
        // 틀린 부분 2 : 현재 노드까지의 거리를 계속 저장하는 배열을 만들면, 위치와 거리 확인이 동시에 된다.
        int[][] distance = new int[N][M];
        distance[y][x] = 1; // 시작 지점의 거리

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            for (int d = 0; d < 4; d++) {
                int ny = node.y + dy[d];
                int nx = node.x + dx[d];

                if (ny < 0 || nx < 0 || ny >= N || nx >= M || visited[ny][nx] || map[ny][nx] == '0') continue;
                visited[ny][nx] = true;
                distance[ny][nx] = distance[node.y][node.x] + 1; // 거리 업데이트
                queue.offer(new Node(ny, nx));
            }
        }
        return distance[N-1][M-1]; // 목적지까지의 거리 반환
    }

    static class Node {
        private int y;
        private int x;

        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

}
