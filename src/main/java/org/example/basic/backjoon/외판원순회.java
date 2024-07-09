package org.example.basic.backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class 외판원순회 {
    // 무한대를 나타내는 값 (임의의 큰 수)
    private static final int INF = 100000000;
    private static int N;  // 도시의 수
    private static int[][] dist;  // 도시 간의 거리 배열
    private static int[][] dp;  // 동적 계획법을 위한 배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();  // 도시의 수 입력
        dist = new int[N][N];  // 거리 배열 초기화
        dp = new int[N][(1 << N)];  // dp 배열 초기화 (비트마스크 사용)

        // 거리 배열 입력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dist[i][j] = sc.nextInt();
            }
        }

        // dp 배열을 -1로 초기화 (아직 계산되지 않은 상태)
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }

        // TSP 문제 해결
        int result = tsp(0, 1);  // 시작 도시를 0으로 설정하고, 0번 도시를 방문했다고 표시
        System.out.println(result);  // 결과 출력
    }

    // TSP를 해결하는 함수
    private static int tsp(int current, int visited) {
        // 모든 도시를 방문한 경우 (비트마스크로 모든 도시를 방문했는지 확인)
        if (visited == (1 << N) - 1) {
            return dist[current][0] == 0 ? INF : dist[current][0];  // 시작 도시로 돌아가는 비용 반환
        }

        // 이미 계산된 경우 저장된 값 반환
        if (dp[current][visited] != -1) {
            return dp[current][visited];
        }

        // 초기값을 무한대로 설정
        dp[current][visited] = INF;

        // 모든 도시를 탐색
        for (int next = 0; next < N; next++) {
            // 아직 방문하지 않았고, 현재 도시에서 다음 도시로 갈 수 있는 경우
            if ((visited & (1 << next)) == 0 && dist[current][next] != 0) {
                // 최소 비용을 계산하여 dp 배열에 저장
                dp[current][visited] = Math.min(dp[current][visited],
                        dist[current][next] + tsp(next, visited | (1 << next)));
            }
        }

        return dp[current][visited];  // 현재 상태에서의 최소 비용 반환
    }
}