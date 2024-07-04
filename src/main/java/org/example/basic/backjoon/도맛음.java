package org.example.basic.backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 도맛음 {
    static int N, result = Integer.MAX_VALUE;
    static int subsetCnt; // 16
    static String[] ingredient;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 4
        ingredient = new String[N];

        for (int i = 0; i < N; i++) {
            ingredient[i] = br.readLine(); // 1 7, 2 6, 3 4, 4, 9
        }

        subsetCnt = 1 << N;

        for (int i = 1; i < subsetCnt; i++) { //  0~15
            int S = 1;
            int B = 0;
            for (int j = 0; j < N; j++) {
                if ((i & 1 << j) != 0) {
                    StringTokenizer st = new StringTokenizer(ingredient[j]);
                    int sour = Integer.parseInt(st.nextToken());
                    int bitter = Integer.parseInt(st.nextToken());
                    S *= sour;
                    B += bitter;
                }
            }
            result = Math.min(result, Math.abs(S-B));
        }
        System.out.println(result);
    }
}
