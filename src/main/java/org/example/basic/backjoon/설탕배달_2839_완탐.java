package org.example.basic.backjoon;

import java.util.Scanner;

// 완탐으로 풀어보기
// 이렇게 풀면 시간 초과 나와요...
public class 설탕배달_2839_완탐 {
    static int N, min;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        min = 5000;

        dfs(0,0);

        min = min == 5000? -1 : min;
        System.out.println(min);
    }

    static void dfs(int five, int three) {
        // 기저조건
        int sum = five*5 + three*3;
        if (sum == N) {
            min = Math.min(min, five + three); // 성공한 경우, 최솟값을 갱신
            return;
        } else if (sum > N) { // 실패한 경우 그냥 리턴해서 끝나버림.
            return;
        }

        // 기저조건에 해당하지 않는다면 N에 도달하기 위해 계속 재귀호출.
        dfs (five +1, three);
        dfs (five, three+1);
    }
}
