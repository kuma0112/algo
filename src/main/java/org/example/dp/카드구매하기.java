package org.example.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 카드구매하기 {
    static int N;
    static int[] price, dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        price = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N ; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N+1];

        int max = Integer.MIN_VALUE;
        Arrays.fill(dp, max);
        dp[0] = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i - j >= 0) {
                    dp[i] = Math.max(dp[i], dp[i-j]+price[j]);
                }
            }
        }

        System.out.println(dp[N]);

    }
}
