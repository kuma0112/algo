package org.example.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 행렬곱셈순서_11049 {
    static int N;
    static int[][] array;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        array = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            array[i][0] = Integer.parseInt(st.nextToken());
            array[i][1] = Integer.parseInt(st.nextToken());
        }
        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][i] = 0;
        }

        for (int k = 1; k < N; k++) {
            for (int start = 0; start < N - k; start++) {
                int end = start + k;

                if (end >= N) break;

                for (int temp = start; temp < end; temp++) {
                    dp[start][end] = Math.min(dp[start][end],
                            dp[start][temp] + dp[temp+1][end] +
                                    (array[start][0] * array[temp+1][0] * array[end][1]));
                }
            }
        }
        System.out.println(dp[0][N-1]);

    }
}
