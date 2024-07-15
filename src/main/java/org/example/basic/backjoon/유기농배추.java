package org.example.basic.backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 유기농배추 {
    static int T, W, H, K, count;
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[H][W];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                map[b][a] = 1;
            }

            visited = new boolean[H][W];
            count = 0;

            for (int k = 0; k < H; k++) {
                for (int l = 0; l < W; l++) {
                    if (map[k][l] == 1 && !visited[k][l]) {
                        count ++;
                        dfs(k, l);
                    }
                }
            }
            System.out.println(count);
        }
    }

    static void dfs(int y, int x) {
        visited[y][x] = true;

        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];

            if (ny < 0 || nx < 0 || ny >= H || nx >= W) continue;
            if (!visited[ny][nx] && map[ny][nx] == 1) {
                dfs(ny, nx);
            }
        }

    }

}
