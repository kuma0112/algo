package org.example.basic.backjoon;

import java.util.Scanner;

// 완탐으로 풀어보기
public class 설탕배달_2839 {
    static int N, min;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 11

        for (int i = 0; i <=  N/5; i++) {
            int num = N - (5 * i);
            if (num % 3 == 0) {
                min = i + (num / 3);
                break;
            }
        }
        System.out.println(min);
    }
}
