package org.example.basic.ch03;

import java.io.*;
import java.util.StringTokenizer;

public class 숫자_카드_게임 {
    static int[][] array;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄에서 N과 M을 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int maxOfMins = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int min = Integer.MIN_VALUE;


            for (int j = 0; j < M; j++) {
                int number = Integer.parseInt(st.nextToken());
                if (number < min) {
                    min = number;
                }
            }

            if (min > maxOfMins) {
                maxOfMins = min;
            }
        }

        System.out.println(maxOfMins);
    }
}
