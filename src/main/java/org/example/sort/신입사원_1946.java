package org.example.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 서류 순으로 정렬한 뒤, 면접 순으로 min 값을 갱신해가면서 확인하는 방식.
 * 아예 입력 받을 때 정렬하면서 받는 방식도 생각해 볼 것.
 */

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

        Arrays.sort(array, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < M; i++) {
            if (min > array[i][1]) {
                min = array[i][1];
                answer++;
            }
        }
        return answer;
    }
}
