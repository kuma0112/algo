package org.example.basic.ch05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 음료수얼려먹기_3 {
    static int n, m, result;
    static char[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == '0') {
                    dfs(i, j);
                    result++;
                }
            }
        }

        System.out.println(result);
    }

    static void dfs(int y, int x) {
        if (y < 0 || x < 0 || y >= n || x >= m) {
            return;
        }

        map[y][x] = '1';
        dfs(y - 1, x); // 상
        dfs(y + 1, x); // 하
        dfs(y, x - 1); // 좌
        dfs(y, x + 1); // 우

    }
}
