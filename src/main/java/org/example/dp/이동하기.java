package org.example.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 이동하기 {
    static int N, M;
    static int[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N ; i++) {
            for (int j = 1; j <= M ; j++) {
                if (i == 1 && j == 1) continue;
                int max = 0;
                max = Math.max(max ,map[i-1][j-1]);
                max = Math.max(max ,map[i-1][j]);
                max = Math.max(max ,map[i][j-1]);
                map[i][j] += max;
            }
        }

        System.out.println(map[N][M]);
    }
}
