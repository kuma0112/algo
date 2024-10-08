package org.example.basic.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 내려가기_2096_dp2 {
    static int N;
    static int[][] map;
    static int[] dpMAX, dpMIN;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][3];
        dpMAX = new int[3];
        dpMIN = new int[3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 3; i++) {
            dpMAX[i] = map[0][i];
            dpMIN[i] = map[0][i];
        }

        for (int i = 1; i < N; i ++) {
            int max0 = dpMAX[0], max1 = dpMAX[1], max2 = dpMAX[2];
            int min0 = dpMIN[0], min1 = dpMIN[1], min2 = dpMIN[2];

            dpMAX[0] = Math.max(max0, max1) + map[i][0];
            dpMAX[1] = Math.max(max0, Math.max(max1, max2)) + map[i][1];
            dpMAX[2] = Math.max(max1, max2) + map[i][2];

            dpMIN[0] = Math.min(min0, min1) + map[i][0];
            dpMIN[1] = Math.min(min0, Math.min(min1, min2)) + map[i][1];
            dpMIN[2] = Math.min(min1, min2) + map[i][2];
        }

        int max = Math.max(dpMAX[0], Math.max(dpMAX[1], dpMAX[2]));
        int min = Math.min(dpMIN[0], Math.min(dpMIN[1], dpMIN[2]));

        System.out.println(max + " " + min);
    }
}



















