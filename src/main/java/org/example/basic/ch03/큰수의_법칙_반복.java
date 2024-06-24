package org.example.basic.ch03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 주어지는 배열의 수 전체를 다 고려하지 않고, 가장 큰 수와 두 번째 큰 수만 고려
// 따라서 큰 수, 두 번재 큰 수를 정렬을 통해서 구한다.
// 이후
// 1. 반복 -> 하나씩 하나씩...
// 2. 반복 횟수를 미리 다 구함.
public class 큰수의_법칙_반복 {
    public static void main(String[] args) throws IOException {

/*
5 8 3
2 4 5 4 6
 */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine(); // "5 8 3"
        StringTokenizer st = new StringTokenizer(str);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] array = new int[N];

        str = br.readLine();
        st = new StringTokenizer(str);
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);
        int first = array[N-1];
        int second = array[N-2];

        // m개가 될 때까지 가장 큰 수를 k번 사용 + 두 번째 수 1번 사용 ....이 m번될 때까지
        int result = 0;
        int totalCnt = 0;
        int kCnt = 0;

        while (totalCnt != M) {
            if (kCnt == K) { // 가장 큰 수를 k번 연속 사용한 상태라면
                result += second;
                kCnt = 0;
            } else {
                result += first;
                kCnt++;
            }
            totalCnt++;
        }
        System.out.println(result);
    }
}
