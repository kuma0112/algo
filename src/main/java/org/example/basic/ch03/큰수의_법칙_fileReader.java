package org.example.basic.ch03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 큰수의_법칙_fileReader {
    static int N, M, K, result;
    static int[] array;
    public static void main(String[] args) throws IOException {
        // 파일 읽는 방법!
        System.setIn(new FileInputStream("input2.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine(); // "5 8 3"
        StringTokenizer st = new StringTokenizer(str);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        array = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);
        int first = array[N-1];
        int second = array[N-2];

//        int a = ((M / K) * K) * first;
//        int b = (M % K) * second;

        int cnt = (M / (K + 1)) * K + (M % (K + 1));
        result = cnt * first + (M - cnt) * second;

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
