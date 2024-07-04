package org.example.basic.backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 도맛음_dfs {
    static int N, min;
    static int[][] src;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        src = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            src[i][0] = Integer.parseInt(st.nextToken());
            src[i][1] = Integer.parseInt(st.nextToken());
        }

        min = Integer.MAX_VALUE;

        dfs(0, 1, 0); // 첫 번째 재료부터 시작

        System.out.println(min);
    }

    static void dfs(int srcIdx, int sinSum, int ssnSum) { // 재귀호출 할 거기 때문에 직전까지의 합을 계속 달고 다닌다.
        if(srcIdx == N) return;

        // 매 단계마다 신맛, 쓴맛 계산
        int currentSin = src[srcIdx][0] * sinSum;
        int currentSsn = src[srcIdx][1] + ssnSum;

        min = Math.min(min, Math.abs(currentSin - currentSsn));

        // 현재 재료를 선택하고 계속 가는 경우
        dfs(srcIdx+1, currentSin, currentSsn);
        dfs(srcIdx+1, sinSum, ssnSum);
    }
}
