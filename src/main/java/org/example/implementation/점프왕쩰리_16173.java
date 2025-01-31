package org.example.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 점프왕쩰리_16173 {
    static int N;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 3
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][N];
        String answer = forJelli(0, 0, map[0][0]);
        System.out.println(answer);
    }

    static String forJelli(int y, int x, int v) {
        Queue<Node> queue = new LinkedList<>();
        Node node = new Node(y, x, v);
        queue.add(node);
        visited[y][x] = true;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.y == N - 1 && cur.x == N - 1) {
                return "HaruHaru";
            }
            int[] dy = {cur.value, 0};
            int[] dx = {0, cur.value};
            for (int i = 0; i < 2; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];
                if (ny >= 0 && nx >= 0 && ny < N && nx < N && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    queue.add(new Node(ny, nx, map[ny][nx]));
                }
            }
        }
        return "Hing";
    }

    static class Node {
        int y;
        int x;
        int value;

        Node(int y, int x, int value) {
            this.y = y;
            this.x = x;
            this.value = value;
        }
    }
}
