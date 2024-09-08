package org.example.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 계란으로계란치기 {

    static int[][] matrix;
    static int n;
    static int max = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        matrix = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            matrix[i][0] = Integer.parseInt(st.nextToken());
            matrix[i][1] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
        System.out.println(max);
    }

    private static void dfs(int start) {
        if (start == n) {
            int count = 0;

            for (int i = 0; i < n; i++) {
                if (matrix[i][0] <= 0) {
                    count++;
                }
            }
            max = Math.max(max, count);
            return;
        }

        if(matrix[start][0] <= 0){
            dfs(start + 1);
            return;
        }

        for (int i = 0; i < n; i++) {
            int s1 = matrix[start][0];
            int s2 = matrix[i][0];

            if(i == start || s2 <= 0){
                if (i == n-1) {
                    dfs(start + 1);
                }
                continue;
            }

            matrix[start][0] -= matrix[i][1];
            matrix[i][0] -= matrix[start][1];

            dfs(start + 1);
            matrix[start][0] = s1;
            matrix[i][0] = s2;
        }
    }
}









