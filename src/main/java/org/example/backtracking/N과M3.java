package org.example.backtracking;

import java.io.*;
import java.util.StringTokenizer;

// BufferedWriter 활용 문제
public class N과M3 {
    static int N, M;
    static int[] array;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        array = new int[M];

        dfs(0);

        bw.flush();
        bw.close();
    }

    static void dfs(int length) throws IOException {
        if (length == M) {
            for (int i = 0; i < M; i++) {
                bw.write(array[i] + " ");
            }
            bw.newLine();
            return;
        }

        // 시간 초과
        for (int i = 1; i <= N; i++) {
            array[length] = i;
            dfs(length + 1);
        }

    }
}
