package org.example.recursiveCall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치수_2747 {
    static int N, answer;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        dp[0] = 0;
        dp[1] = 1;

        answer = pivo(N);
        System.out.println(answer);
    }

    static int pivo(int n) {
        if (n>=2) {
            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i-1] + dp[i-2];
            }
        }
        return dp[n];
    }
}
