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
public class 큰수의_법칙 {
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

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);
        int first = array[N-1];
        int second = array[N-2];

//        int a = ((M / K) * K) * first;
//        int b = (M % K) * second;

        int cnt = (M / (K + 1)) * K + (M % (K + 1));
        int result = cnt * first + (M - cnt) * second;

//        int cnt = (m / (k + 1)) * k;
//        cnt += m % (k + 1);

        // 가장 큰 수가 더해지는 횟수 계산
        // 큰 수 F 두 번째 수 S
        // m이 8이고, k가 3이라면
        // FFFS-FFFS
        // (M / (K+1)) * K -> F가 사용된 횟수

        // 만약 m이 10이라면
        // FFFS-FFFS-FF
        // (M / (K+1)) * K + (M % (K+1)) -> F가 사용된 횟수 -> cnt
        // M - cnt -> S가 사용된 횟수

        System.out.println(result);
    }
}
