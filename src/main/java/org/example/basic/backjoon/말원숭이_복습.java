package org.example.basic.backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 말원숭이_복습 {
    static int[] dy8h = {-2, -2, -1, -1, 2, 2, 1, 1};
    static int[] dx8h = {-1, 1, -2, 2, -1, 1, -2, 2};
    static int[] dy4 = {-1, 1, 0, 0};
    static int[] dx4 = {0, 0, -1, 1};

    static int K;
    static int H, W;
    static int[][] map;
    static boolean[][][] visit;
    static Queue<Node> queue = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        visit = new boolean[H][W][K + 1];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();
    }

    static void bfs() {

        // 시작좌표 처리
        visit[0][0][K] = true;
        queue.offer(new Node(0, 0, K, 0));

        while( !queue.isEmpty() ) {
            Node node = queue.poll();

            // 목표 도달
            if( node.y == H - 1 && node.x == W - 1 ) {
                System.out.println(node.d);
                return;
            }

            // 탐색 #1 - 상하좌우
            for (int i = 0; i < 4; i++) {
                int ny = node.y + dy4[i];
                int nx = node.x + dx4[i];
                if( ny < 0 || nx < 0 || ny >= H || nx >= W || map[ny][nx] == 1
                        || visit[ny][nx][node.k] ) continue;
                visit[ny][nx][node.k] = true;
                queue.offer(new Node(ny, nx, node.k, node.d + 1 )); // k 그대로, d 는 증가
            }

            // 탐색 #2 - 말
            if( node.k == 0 ) continue;

            for (int i = 0; i < 8; i++) {
                int ny = node.y + dy8h[i];
                int nx = node.x + dx8h[i];
                if( ny < 0 || nx < 0 || ny >= H || nx >= W
                        || map[ny][nx] == 1
                        || visit[ny][nx][node.k - 1]
                ) continue;

                visit[ny][nx][node.k - 1] = true;
                queue.offer(new Node(ny, nx, node.k - 1, node.d + 1 )); // k 감소, d 는 증가
            }
        }

        System.out.println(-1);
    }

    static class Node{
        int y, x, k, d;
        Node( int y, int x, int k, int d ) {
            this.y = y; this.x = x; this.k = k; this.d = d;
        }
    }
}