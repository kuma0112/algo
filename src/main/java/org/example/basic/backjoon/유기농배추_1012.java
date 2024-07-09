package org.example.basic.backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 유기농배추_1012 {
    static int T, H, W, K, count;
    static int[][] map;
    static boolean[][] visited;
    static StringBuilder sb = new StringBuilder();
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine()); // 2
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[H][W];
            visited = new boolean[H][W];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                map[b][a] = 1;
            }

            count = 0;

            for (int y = 0; y < H; y++) {
                for (int x = 0; x < W; x++) {
                    if (map[y][x] ==1 && !visited[y][x]) {
                        dfs(y,x);
                        count++;
                    }
                }
            }

            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }


    static void dfs(int y, int x) {

        visited[y][x] = true;

        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];

            if (ny < 0 || nx < 0 || ny >= H || nx >= W ) continue;
            if (map[ny][nx] == 1 && !visited[ny][nx]) {
                dfs(ny, nx);
            }
        }
        return;
    }
}
