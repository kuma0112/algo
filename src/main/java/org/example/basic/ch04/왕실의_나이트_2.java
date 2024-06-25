package org.example.basic.ch04;

import java.util.Scanner;

// 이걸 델타 없이 어떻게 처리할 수 있을까?
public class 왕실의_나이트_2 {
    static int y, x, result;
    static int[] dy = {-1, -1, 1, 1, -2, -2, 2, 2};
    static int[] dx = {-2, 2, -2, 2, -1, 1, -1, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String inputData = sc.nextLine();
        int y = inputData.charAt(1) - '0';
        int x = inputData.charAt(0) - 'a' + 1;

        if (y > 2 && y < 7 && x > 2 && x < 7) {
            System.out.println(8);
            return;
        }

        for (int d = 0; d < 8; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];
            if (ny < 1 || nx < 1 || ny > 8 || nx > 8) continue;
            result += 1;
        }

        System.out.println(result);
    }
}
