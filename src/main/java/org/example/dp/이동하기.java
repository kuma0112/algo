package org.example.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 이동하기 {
    static int N, M;
    static int[][] map;
    static int[][] dp;
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
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1]);
            }
        }

        System.out.println(dp[N][M]);
    }
}
