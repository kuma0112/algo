package org.example.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 이친수 {
    static int N;
    static long[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(1);
            return;
        }

        dp = new long [N+1][2];
        dp[1][1] = 1;
        dp[2][0] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-1][1];
            dp[i][1] = dp[i-1][0];
        }

        long answer = dp[N][0] + dp[N][1];
        System.out.println(answer);
    }
}
