package org.example.basic.ch05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 음료수얼려먹기_prac2 {
    static int n, m, count;
    static int[][] map;
    static int[] dy4 = {-1, 1, 0, 0};
    static int[] dx4 = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    count++;
                    dfs(i, j);
                }
            }
        }
        System.out.println(count);
    }

    static void dfs(int y, int x) {
        map[y][x] = 1;

        for (int d = 0; d < 4; d++) {
            int ny = y + dy4[d];
            int nx = x + dx4[d];

            if (ny < 0 || nx < 0 || ny >= n || nx >= m || map[ny][nx] == 1) continue;

            map[ny][nx] = 1;
            dfs(ny, nx);
        }

    }

}
