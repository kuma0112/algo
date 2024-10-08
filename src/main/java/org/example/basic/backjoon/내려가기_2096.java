package org.example.basic.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 내려가기_2096 {
    static int[] dx = {-1, 0, 1};
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;
    static int N;
    static int[][] map;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            result += map[0][i];
            dp(0, i);
            result = 0;
        }
        System.out.println(MAX + " " + MIN);
    }

    static void dp(int y, int x) {
        if (y == N-1) {
            if (MAX < result) {
                MAX = result;
            }
            if (MIN > result) {
                MIN = result;
            }
            return;
        }


        for (int i = 0; i < 3; i++) {
            int ny = y + 1;
            int nx = x + dx[i];

            if (ny < 0 || ny >= N || nx < 0 || nx >= N) {
                continue;
            }

            result += map[ny][nx];
            dp(ny, nx);
            result -= map[ny][nx];
        }
    }
}
