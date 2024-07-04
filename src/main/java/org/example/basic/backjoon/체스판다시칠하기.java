package org.example.basic.backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 체스판다시칠하기 {
    static int N, M;
    static String[] strArray;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        strArray = new String[N];
        for (int i = 0; i < N; i++) {
            strArray[i] = br.readLine();
        }

        int result = 0;
        for (int i = 0; i <= N-8; i++) {
            for (int j = 0; j <= M-8; j++) {
                result = Math.max(result, paint(i, j));
            }
        }
        bw.write(result);
    }

    static int paint(int startRow, int startColumn) {
        String[] chess = {"WBWBWBWB", "BWBWBWBW"};
        int count = 0;

        for (int i = 0; i < 8; i++) {
            int row = startRow + i;
            for (int j = 0; j < 8; j++) {
                int column = startColumn + j;
                if (strArray[row].charAt(column) != chess[row%2].charAt(j))
                    count ++;
            }
        }
        return Math.min(count, 64 - count);
    }
}
