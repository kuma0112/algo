package org.example.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M2 {
    static int N, M;
    static int[] array;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 3
        M = Integer.parseInt(st.nextToken());  // 2

        array = new int[M];

        dfs(1, 0);
    }

    static void dfs(int start, int count) {
        if (count == M) {
            for (int j = 0; j < M ; j++) {
                System.out.print(array[j] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= N ; i++) {
            array[count] = i;
            dfs(i+1, count+1);
        }
    }
}
