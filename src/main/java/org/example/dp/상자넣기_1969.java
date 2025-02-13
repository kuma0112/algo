package org.example.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 상자넣기_1969 {
    static int N, max;
    static int[] dp, array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N];
        array = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, solution(i, 1));
        }
        System.out.println(max);
    }

    static int solution(int index, int count) {
        if (dp[index] != 0) {
            return dp[index];
        }
        int maxCount = count;
        int curr = array[index];
        for (int i = index + 1; i < N; i++) { // i = 1;
            if (array[i] > curr) {
                maxCount = Math.max(maxCount, solution(i, count+1));
            }
        }
        dp[index] = maxCount;
        return dp[index];
    }
}
