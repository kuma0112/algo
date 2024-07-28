package org.example.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 일로만들기 {
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        if (n >= 2) dp[2] = 1;
        if (n >= 3) dp[3] = 1;
        System.out.println(solution(n));
    }

    static int solution(int n) {
        if (n <= 3) return dp[n];

        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
        }
        return dp[n];
    }
}
