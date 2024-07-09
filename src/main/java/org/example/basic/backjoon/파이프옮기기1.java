package org.example.basic.backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 파이프옮기기1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N + 1][N + 1];
        int[][][] dp = new int[N + 1][N + 1][3];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 초기 상태: 파이프가 (1, 1)과 (1, 2)에 가로로 놓여 있음
        dp[1][2][0] = 1;

        for (int i = 1; i <= N; i++) {
            for (int j = 2; j <= N; j++) {
                if (map[i][j] == 1) continue;

                // 가로
                if (j > 1) {
                    dp[i][j][0] += dp[i][j-1][0] + dp[i][j-1][2];
                }

                // 세로
                if (i > 1) {
                    dp[i][j][1] += dp[i-1][j][1] + dp[i-1][j][2];
                }

                // 대각선
                if (i > 1 && j > 1 && map[i-1][j] != 1 && map[i][j-1] != 1 && map[i-1][j-1] != 1) {
                    dp[i][j][2] += dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
                }
            }
        }

        // 마지막 위치에서 모든 방향의 경우의 수를 더함
        int result = dp[N][N][0] + dp[N][N][1] + dp[N][N][2];
        System.out.println(result);
    }
}
