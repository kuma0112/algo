package org.example.basic.backjoon;

import java.util.Scanner;

public class 분해합 {
    static int result, sum;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            sum = i;
            int temp = i;

            while (temp!=0) {
                sum += temp % 10; // 1의 자리
                temp /= 10; // 10, 100, 1000... 의 자리 더하기
            }

            if (sum == N) {
                result = i;
                break;
            }
        }
        System.out.println(result);;
    }
}
