package org.example.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연산자끼워넣기_14888 {
    static int N;
    static int[] array;
    static int[] Maths;
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        array = new int[N];
        Maths = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken()); // 1 2 3 4 5 6
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            Maths[i] = Integer.parseInt(st.nextToken()); // 2 1 1 1
        }

        dfs(array[0], 1);
        System.out.println(MAX);
        System.out.println(MIN);
    }
    static void dfs(int currentValue, int index) {
        if (index == N  ) {
            MAX = Math.max(MAX, currentValue);
            MIN = Math.min(MIN, currentValue);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (Maths[i] > 0) {
                Maths[i]--;

                if (i == 0) {
                    dfs(currentValue + array[index], index+1);
                } else if (i == 1) {
                    dfs(currentValue - array[index], index+1);
                } else if (i == 2) {
                    dfs(currentValue * array[index], index+1);
                } else if (i == 3) {
                    if (array[index] != 0) {
                        dfs(currentValue / array[index], index + 1);
                    }
                }


                Maths[i]++;
            }
        }
    }
}
