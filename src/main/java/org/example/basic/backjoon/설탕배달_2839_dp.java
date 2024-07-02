package org.example.basic.backjoon;

import java.util.Arrays;
import java.util.Scanner;

// dp로 풀이
public class 설탕배달_2839_dp {
    static int N;
    static int[] dp;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        // 초기값 처리
        if (N <= 5) {
            if (N == 3 || N ==5) System.out.println(1);
            else System.out.println(-1);
            return;
        }
        dp = new int[N+1]; // 1kg로부터 시작

        Arrays.fill(dp, 5000); // 충분히 큰값으로 채우고 시작

        // 3, 5kg 설정
        dp[3] = 1;
        dp[5] = 1;

        for (int i = 6; i <= N; i++) {
            dp[i] = Math.min(dp[i-3]+1, dp[i-5]+1);
        }

        if (dp[N] == 5000) System.out.println(-1);
        else System.out.println(dp[N]);
    }
}
