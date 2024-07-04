package org.example.basic.backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 도맛음_binaryCount {
    static int N, min;
    static int[][] src;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        src = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            src[i][0] = Integer.parseInt(st.nextToken());
            src[i][1] = Integer.parseInt(st.nextToken());
        }

        min = Integer.MAX_VALUE;

        int subsetCnt = 1 << N;

        for (int i = 1; i < subsetCnt; i++) {
            int sin = 1;
            int ssn = 0;
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) != 0) {
                    sin *= src[j][0];
                    ssn += src[j][1];
                }
            }
            min = Math.min(min, Math.abs(sin-ssn));
        }

        System.out.println(min);
    }
}
