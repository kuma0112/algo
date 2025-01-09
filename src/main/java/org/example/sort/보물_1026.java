package org.example.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 보물_1026 {
    static int N;
    static int[] arrayA;
    static int[] arrayB;
    /*
    S의 최솟값 출력.

    B의 가장 큰 수에 A의 가장 작은 수를 매칭.
    결국 A와 B를 다 재배열하되
    A는 역순으로, B는 작은 수 -> 큰수로 재배열하면 되지 않을까?
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arrayA = new int[N];
        arrayB = new int[N];

        for (int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            if (i == 0) {
                for (int j = 0; j < N; j++) {
                    arrayA[j] = Integer.parseInt(st.nextToken());
                }
            }
            if (i == 1) {
                for (int j = 0; j < N; j++) {
                    arrayB[j] = Integer.parseInt(st.nextToken());
                }
            }
        }

        sort();
        int answer = calculate();
        System.out.println(answer);
    }

    private static void sort() {
        Arrays.sort(arrayA);
        int[] temp = new int[N];
        // 여기 거꾸로 넣어야 하는데
        for (int i = 0; i < N; i++) {
            temp[N-i-1] = arrayA[i];
        }
        for (int i = 0; i < N; i++) {
            arrayA[i] = temp[i];
        }
        Arrays.sort(arrayB);
    }
    
    private static int calculate() {
        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer += arrayA[i] * arrayB[i];
        }
        return answer;
    }
}
