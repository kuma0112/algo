package org.example.basic.ch03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
5
3 1 4 3 2
 */
public class GreedyPractice2 {
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 사람 수 5명
        int[] array = new int[N]; //  사람 수 크기의 배열 만들기

        // 3 + (3 +1 ) ...
        // 1

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) { // [3, 1, 4, 3, 2]
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array); // [1, 2, 3, 3, 4]
        for (int i = 0; i < N; i++) {
            result += array[i] * (N-i);
        }
        System.out.println(result);
    }
}
