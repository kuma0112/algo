package org.example.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 설탕배달_2839 {
    static int N, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int max5 = N/5;
        for (int i = max5; i >= 0 ; i--) {
            if (i == 0) {
                if (N % 3 == 0) {
                    answer = N / 3;
                    break;
                }
            }
            int temp = N - (i * 5);
            if (temp % 3 == 0) {
                answer = i + (temp/3);
                break;
            }
        }
        if (answer == 0) {
            System.out.println(-1);
        } else System.out.println(answer);

    }
}
