package org.example.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 회의실배정_1931 {
    static int N, count = 0;
    static int[][] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        array = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            array[i][0] = Integer.parseInt(st.nextToken());
            array[i][1] = Integer.parseInt(st.nextToken());
        }

        /**
         * 끝나는 시간이 가장 빠른 걸 하나 선택.
         * 이후 남은 것 + 끝나는 시간 이후에 시작하는 것 중에 끝나는 시간이 가장 빠른 걸 선택하는 걸 반복
         * 반복할 때마다 count++;
         */

        Arrays.sort(array, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }

            return o1[1] - o2[1];
        });

        int endTime = array[0][1];
        count += 1;

        for (int i = 1; i < N; i++) {
            if (endTime <= array[i][0]) {
                endTime = array[i][1];
                count++;
            }
        }

        System.out.println(count);

    }
}
