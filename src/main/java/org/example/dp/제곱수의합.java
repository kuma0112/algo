package org.example.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 제곱수의합 {
    static int N;
    static int[] square, dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        square = new int[N+1];
        for (int i = 1; i <= N; i++) {
            square[i] = i * i;
        }

        dp = new int[N+1];

        int min = Integer.MAX_VALUE;
        Arrays.fill(dp, min);
        dp[0] = 0;
        if (N!=1) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= Math.sqrt(N); j++) {
                    if (i - square[j] >= 0) {
                        dp[i] = Math.min(dp[i], dp[i-square[j]]+ 1);
                    }
                }
            }
            System.out.println(dp[N]);
        } else {
            System.out.println(1);
        }

    }
}
