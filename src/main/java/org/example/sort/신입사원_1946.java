package org.example.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 신입사원_1946 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int[][] array = new int[M][2];
            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                array[j][0] = Integer.parseInt(st.nextToken());
                array[j][1] = Integer.parseInt(st.nextToken());
            }
            int answer = solution(array, M);

            System.out.println(answer);
        }
    }

    static int solution(int[][] array, int M) {
        int answer= 0;
        for (int i = 0; i < M; i++) {
            int a = array[i][0];
            int b = array[i][1];

            boolean flag = true;
            for (int j = 0; j < M; j++) {
                if (j != i) {
                    if (array[j][0] - a < 0 && array[j][1] - b < 0) {
                        flag = false;
                    }
                }
            }

            if (flag) {
                answer++;
            }
        }
        return answer;
    }
}
