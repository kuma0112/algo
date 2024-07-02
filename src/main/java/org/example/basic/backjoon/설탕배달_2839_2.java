package org.example.basic.backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class 설탕배달_2839_2 {
    static int N, min;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        // 초기값 설정: 큰 값으로 초기화 (N+1은 충분히 큰 값)
        int[] dp = new int[N + 1];
        Arrays.fill(dp, N + 1);
        dp[0] = 0;

        // DP 계산
        for (int i = 1; i <= N; i++) {
            if (i >= 3) dp[i] = Math.min(dp[i], dp[i - 3] + 1);
            if (i >= 5) dp[i] = Math.min(dp[i], dp[i - 5] + 1);
        }

        // 결과 출력
        if (dp[N] > N) {
            System.out.println(-1);
        } else {
            System.out.println(dp[N]);
        }
    }
}
