package org.example.basic.ch03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 큰수의_법칙_findBigNum {
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

        // O(NlogN)
//        Arrays.sort(array);


//        // first와 second는 동일할 수 있다.
//        int first = 0;
//        int second = 0;
//
//        for (int i = 0; i < N; i++) {
//            if (array[i] > first) {
//                second = first;
//                first = array[i];
//            } else if (array[i] > second) {
//                second = array[i];
//            }
//        }

        int first = first();
        int second = second();

        int cnt = (M / (K + 1)) * K + (M % (K + 1));
        result = cnt * first + (M - cnt) * second;



        System.out.println(result);
    }

    static int first() {
        int first = 0;
        int firstIndex = 0;
        for (int i = 0; i < N; i++) { // 가장 큰 수가 중복되어도 맨 앞의 수가 가장 큰 수로 처리되도록
            if (array[i] > first) {
                first = array[i];
                firstIndex = i;
            }
        }
        array[firstIndex] = 0; // 가장 큰 수를 0으로 만들어 버림
        return first;
    }

    static int second() {
        int second = 0;
        for (int i = 0; i < N; i++) {
            if (array[i] > second) {
                second = array[i];
            }
        }
        return second;
    }
}
