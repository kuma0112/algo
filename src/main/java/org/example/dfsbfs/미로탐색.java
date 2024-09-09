package org.example.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색 {
    static char[][] map;
    static boolean[][] visited;
    static int N,M;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        System.out.println(bfs(0,0));
    }

    static int bfs(int y, int x) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(y, x,1));
        visited[y][x] = true;

        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.y == N - 1 && cur.x == M - 1) {
                return cur.distance;
            }
            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                if(map[ny][nx] == '0') continue;
                visited[ny][nx] = true;
                queue.add(new Node(ny, nx, cur.distance+1));
            }
        }
        return -1;
    }

    static class Node {
        int y, x, distance;
        Node(int y, int x, int distance) {
            this.y = y;
            this.x = x;
            this.distance = distance;
        }
    }
}

