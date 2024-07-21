package org.example.basic.backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 빵집 {
    static int R, C, count;
    static char[][] map;
    static int[] dy = {-1, 0, 1};
    static int[] dx = {1, 1, 1};
    static boolean[][] visit;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][];
        visit = new boolean[R][C];
        for (int i = 0; i <R ; i++) {
            String str = br.readLine();
            map[i] = str.toCharArray();
        }

        for (int i = 0; i < R; i++) {
            if (dfs(i, 0)) {
                count++;
            }
        }

        System.out.println(count);
    }

    static boolean dfs(int y, int x) {
        if (x == C-1) { // 경로 완성
            return true;
        }

        for (int d = 0; d < 3; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];

            if (ny < 0 || nx < 0 || ny >= R || nx >= C) continue;
            if (map[ny][nx] == 'x' || visit[ny][nx]) continue;

            visit[ny][nx] = true;
            if (dfs(ny, nx)) {
                return true;
            }
        }
        return false;
    }

}
