package org.example.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 쉬운계단수 {
    static int[][] dp;
    static final int NUM = 1_000_000_000;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1][10];

        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                if (j > 0) {
                    dp[i][j] += dp[i-1][j-1];
                }
                if (j < 9) {
                    dp[i][j] += dp[i-1][j+1];
                }
                dp[i][j] %= NUM;
            }
        }

        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum = (sum + dp[n][i]) % NUM;
        }

        System.out.println(sum);
    }
}
