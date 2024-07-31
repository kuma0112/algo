package org.example.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 점프 {
    static int N;
    static int[][] arr;
    static long[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        dp = new long[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = 1;
        solution();
        System.out.println(dp[N-1][N-1]);
    }

    static void solution() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (dp[i][j] > 0 && arr[i][j] > 0) {
                    int jump = arr[i][j];
                    if (j + jump < N) {
                        dp[i][j + jump] += dp[i][j];
                    }
                    if (i + jump < N) {
                        dp[i + jump][j] += dp[i][j];
                    }
                }
            }
        }
    }
}
