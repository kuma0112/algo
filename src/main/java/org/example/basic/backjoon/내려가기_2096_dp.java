package org.example.basic.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 내려가기_2096_dp {
    static int[] dx = {-1, 0, 1};
    static int N;
    static int[][] map;
    static int[][] dpMAX, dpMIN;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        dpMAX = new int[N][N];
        dpMIN = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dpMAX[i][j] = Integer.MIN_VALUE;
                dpMIN[i][j] = Integer.MAX_VALUE;
            }
        }
        /*
        3
        1 2 3
        4 5 6
        4 9 0
         */

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int maxVal = Integer.MIN_VALUE;
                int minVal = Integer.MAX_VALUE;

                dpMIN[i][j] = dpMAX[i][j] = map[i][j]; // 1

                for (int k = 0; k < 3; k++) {
                    int nx = j + dx[k];
                    if (0 <= nx && nx < N) {
                        maxVal = Math.max(maxVal, dpMAX[i-1][nx]);
                        minVal = Math.min(minVal, dpMIN[i-1][nx]);
                    }
                }
                dpMAX[i][j] = maxVal;
                dpMIN[i][j] = minVal;
            }
        }

        int MAX = Integer.MIN_VALUE;
        int MIN = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            MAX = Math.max(MAX, dpMAX[N-1][i]);
            MIN = Math.min(MIN, dpMIN[N-1][i]);
        }

        System.out.println(MAX + " " + MIN);
    }
}
