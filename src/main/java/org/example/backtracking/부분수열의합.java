package org.example.backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분수열의합 {
    static int N, S, count;
    static int[] array;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        array = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        if (S == 0) count--;

        System.out.println(count);
    }

    static void dfs(int idx, int sum){
        if (idx == N){
            if (sum == S) {count++;}
            return;
        }

        dfs(idx+1, sum+array[idx]);
        dfs(idx+1, sum);
    }
}
