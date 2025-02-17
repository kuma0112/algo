package org.example.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 오르막_11057 {
    static int N;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        /**
         * 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 -> 10개
         *
         * 00, 01, 02, 03, 04, 05, 06, 07, 08, 09 -> 10개
         * 10, 11, 12, 13, 14, 15, 16, 17, 18, 19 -> 9개
         * 20, 21, 22, 23, 24, 25, 26, 27, 28, 29 -> 8개
         * 30~39 -> 7개
         * 40~49 -> 6개
         * 50~59 -> 5개
         * 60~69 -> 4개
         * 70~79 -> 3개
         * 80~89 -> 2개
         * 90~99 -> 1개
         *
         * 자리수가 1개고 시작이 0일 경우 : 1개
         * 자리수가 2개고 시작이 0일 경우 : 10개
         * 자리수가 1개고 시작이 1일 경우 : 1개
         * 자리수가 2개고 시작이 1일 경우 : 9개
         * 자리수가 1개고 시작이 9일 경우 : 1개
         * 자리수가 2개고 시작이 9일 경우 : 1개
         *
         * 자리수가 3개고 시작이 0일 경우 : 000~099 : 55개?
         * 자리수가 3개고 시작이 9일 경우 : 900~999 : 1개
         * dp[3][0] = dp[2][0] + dp [2][1] ... + dp[2][9]
         * dp[3][9] = dp[2][9]
         *
         * 자리수가 1개고 끝자리가 0일 경우 : 1개
         * 자리수가 2개고 끝자리가 0일 경우 : 0개
         * 자리수가 1개고 끝자리가 1일 경우 : 1개
         * 자리수가 2개고 끝자리가 1일 경우 : 2개
         * 자리수가 1개고 끝자리가 9일 경우 : 1개
         * 자리수가 2개고 끝자리가 9일 경우 : 10개
         *
         * 둘다 답이 나올 수 있을 것 같긴 한데... 헷갈리니까 시작 숫자로 해보자
         */

        dp = new int[N+1][10]; // N이 2일 경우, 0, 1, 2로 새야 하니까, 끝에는 시작자리가 0~9일 경우 세기

        // 초기화 자리수가 1개고 시작이 0~9일 경우
        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }

        // 자리수가 2개부터 N개인 상황까지 세어야 함
        // 끝자리가 0~9까지로 세어야 함
        // 끝자리가 0일 경우 10 - 0, 끝자리가 9일 경우 10 - 9가 되게끔
        for (int i = 2; i <= N ; i++) {
            for (int j = 0; j <= 9 ; j++) {
                for (int k = j; k < 10; k++) {
                    dp[i][j] += dp[i-1][k];
                    dp[i][j] %= 10007;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < 9; i++) {
            result += dp[N][i];
        }
        System.out.println(result % 10007 + 1);
    }
}
