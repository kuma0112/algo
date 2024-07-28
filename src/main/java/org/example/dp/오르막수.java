package org.example.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 오르막수 {
    static int[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1][10];
        // 테이블 초기화
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = j; k < 10; k++) {
                    dp[i][j] += dp[i-1][k];
                    dp[i][j] %= 10007;
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < 10; i++) {
            answer += dp[n][i];
        }

        System.out.println(answer % 10007);
    }
}
