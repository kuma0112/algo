package org.example.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 내리막길 {
    static int M, N;
    static int[][] map;
    static int[][] dp;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception{
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        dp = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        solution(0, 0);

        System.out.println(dp[0][0]);
    }

    static void solution(int y, int x) {
        if (y == M-1 && x == N-1) {
            dp[y][x] = 1;
            return;
        }

        if (dp[y][x] == -1) {
            dp[y][x] =0;
            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];

                if (ny < 0 || nx < 0 || ny >= M || nx >= N) {
                    continue;
                }

                if((map[ny][nx] < map[y][x])) {
                    solution(ny, nx);
                    dp[y][x]+=dp[ny][nx];
                }
            }
        }

    }
}
