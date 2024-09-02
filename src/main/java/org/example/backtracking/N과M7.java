package org.example.backtracking;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M7 {
    static int N, M;
    static int[] array, number;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        array = new int[M];
        number = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(number);
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

        for (int i = 0; i < N; i++) {
            array[length] = number[i];
            dfs(length + 1);
        }
    }
}
