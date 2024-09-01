package org.example.backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M4 {
    static int N,M;
    static int[] array;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        array = new int[M];

        dfs(1, 0);
    }
    static void dfs(int start, int length){
        if(length == M){
            for (int i = 0; i < M; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= N; i++) {
            array[length] = i; // 일단 i를 넣고
            dfs(i, length+1); // 다음 차례로 간다. i는 증가하지 않고, 재귀 호출이 모두 끝나면 증가한다 -> 비내림차순
        }
    }
}
