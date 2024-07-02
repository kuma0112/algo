package org.example.basic.backjoon;

import java.util.Scanner;

// 그리디 풀이
// 5로 나누어 떨어지면 나누고 그렇지 않으면 3을 뺀다.
public class 설탕배달_2839_그리디 {
    static int N, count;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        while (true) {
            if (N < 0) { // 줄여나가는 과정에서 N을 맞추지 못하고 음수가 나오면 -1 프린트한 후 리턴.
                System.out.println(-1);
                break;
            }

            // 0이거나 5로 나누어 떨어지는 경우,
            if (N % 5 == 0) { // -3으로 처리하고 난 뒤 0인 경우도 포함.
                System.out.println(N / 5 + count);
                break;
            }

            N -= 3;
            count++;
        }
    }
}
