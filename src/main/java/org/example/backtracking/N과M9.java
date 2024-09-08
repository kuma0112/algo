package org.example.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M9 {
    static int N, M;
    static int[] array, answer;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 숫자 개수
        M = Integer.parseInt(st.nextToken()); // 답의 개수

        array = new int[N];
        answer = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);
        dfs(0, 0);
    }

    static void dfs(int startIdx, int length) {

        if (length == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(answer[i] + " ");
            }
            System.out.println();
            return;
        }

        int previous = -1;
        for (int i = 0; i < N; i++) {
            if (!visited[i] && array[i] != previous) {
                visited[i] = true;
                answer[length] = array[i];
                dfs(i+1, length+1);
                visited[i] = false;
                previous = array[i];
            }
        }

    }
}
