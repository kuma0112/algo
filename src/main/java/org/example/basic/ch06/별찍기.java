package org.example.basic.ch06;

import java.util.Scanner;

public class 별찍기 {
    static char[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new char[n][n];

        fillStars(0, 0, n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    static void fillStars(int x, int y, int n) {
        if (n == 1) {
            arr[x][y] = '*';
            return;
        }

        int size = n / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    fillBlank(x + i * size, y + j * size, size);
                } else {
                    fillStars(x + i * size, y + j * size, size);
                }
            }
        }
    }

    static void fillBlank(int x, int y, int n) {
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                arr[i][j] = ' ';
            }
        }
    }
}
