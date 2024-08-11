package org.example.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 일이삼더하기_다시치기 {
    static int N;
    static int[] array, dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        array = new int[N];

        dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= 10 ; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n]);
        }
    }
}
