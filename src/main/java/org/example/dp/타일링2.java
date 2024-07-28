package org.example.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 타일링2{
    static int[] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];

        if (n >= 1) dp[1] = 1;
        if (n >= 2) dp[2] = 3;

        System.out.println(solution(n));
    }
    static int solution(int n) {
        if (n <= 2) return dp[n];
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + (dp[i - 2] * 2)) % 10007;
        }
        return dp[n];
    }
}
