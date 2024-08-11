package org.example.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 동전2_다시치기 {
    static int N, K;
    static Set<Integer> coin = new HashSet<>();
    static List<Integer> coinList = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            coin.add(Integer.parseInt(st.nextToken()));
        }

        coinList.addAll(coin);

        int[] dp = new int[K+1];
        Arrays.fill(dp, K+1);
        dp[0] = 0;

        for (int i = 1; i <= K ; i++) {
            for(int c: coinList) {
                if (i>= c) dp[i] = Math.min(dp[i], dp[i-c]+1);
            }
        }

        if (dp[K] > K) System.out.println(-1);
        else System.out.println(dp[K]);
    }
}
