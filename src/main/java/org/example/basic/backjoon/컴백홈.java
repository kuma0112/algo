package org.example.basic.backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 컴백홈 {
    static int R, C, K, distance, count;
    static char[][] map;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            map[i] = str.toCharArray();
        }

        int startY = R-1;
        int startX = 0;

        distance = 1;
        visited[startY][startX] = true;
        dfs(startY, startX);

        System.out.println(count);

    }

    static void dfs(int y, int x) {

        if (y == 0 && x == C - 1) {
            if (distance == K) {
                count++;
            }
            return;
        }


        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];

            if (ny < 0 || nx < 0 || ny >= R || nx >= C || map[ny][nx] == 'T' || visited[ny][nx]) continue;

            visited[ny][nx] = true;
            distance++;
            dfs(ny, nx);

            distance--;
            visited[ny][nx] = false;
        }
    }
}
