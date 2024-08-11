package org.example.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 평범한배낭 {
    static int N, K;
    static int[] weight, value, dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        weight = new int[N+1];
        value = new int[N+1];
        dp = new int[K+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken()); //  13 8 6 12
        }

        for(int i = 1; i <= N; i++) {
            for(int w = K; w >= weight[i]; w--) {
                dp[w] = Math.max(dp[w], dp[w-weight[i]]+ value[i]);
            }
        }

        System.out.println(dp[K]);
    }

}
