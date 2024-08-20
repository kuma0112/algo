package org.example.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NQueen {
    static int N, count;
    static int[] queen;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        queen = new int[N];

        dfs(0);
        System.out.println(count);
    }
    private static void dfs(int row) {
        if (row == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (isSafe(row, i)) {
                queen[row] = i;
                dfs(row + 1);
            }
        }
    }
    private static boolean isSafe(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queen[i] == col || Math.abs(queen[i] - col) == Math.abs(i-row)) return false;
        }
        return true;
    }
}
