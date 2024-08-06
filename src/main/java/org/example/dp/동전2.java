package org.example.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 동전2 {
    static int N, K;
    static Set<Integer> coin = new HashSet<>();
    static List<Integer> coinList = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            coin.add(Integer.parseInt(st.nextToken()));
        }

        coinList.addAll(coin);

        int[] dp = new int[K + 1];
        Arrays.fill(dp, K + 1);  // K보다 큰 값으로 초기화
        dp[0] = 0;  // 0원을 만들기 위해 필요한 동전 수는 0

        // DP를 이용하여 최소 동전 수 계산
        for (int i = 1; i <= K; i++) {
            for (int c : coinList) {
                if (i >= c) {
                    dp[i] = Math.min(dp[i], dp[i - c] + 1);
                }
            }
        }

        // 결과 출력
        if (dp[K] > K) {
            System.out.println(-1);
        } else {
            System.out.println(dp[K]);
        }
    }
}
