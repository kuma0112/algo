package org.example.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 연속합 {
    static int N;
    static int[] array;
    static int[] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        array = new int[N+1];
        dp = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = array[1];

        for (int i = 2; i <= N; i++) {
            dp[i] = Math.max(array[i], array[i] + dp[i - 1]);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            if (dp[i] > max) max = dp[i];
        }

        System.out.println(max);
    }
}
