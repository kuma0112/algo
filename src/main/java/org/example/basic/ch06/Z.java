package org.example.basic.ch06;

import java.util.Scanner;

public class Z {
    static int r, c;
    static int count = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        r = scanner.nextInt();
        c = scanner.nextInt();
        scanner.close();

        int size = (int) Math.pow(2, N);
        solve(size, 0, 0);
    }

    static void solve(int size, int row, int col) {
        if (size == 1) {
            System.out.println(count);
            return;
        }

        int newSize = size / 2;
        int areaSize = newSize * newSize;

        if (r < row + newSize && c < col + newSize) {
            // Top-left quadrant
            solve(newSize, row, col);
        } else if (r < row + newSize && c >= col + newSize) {
            // Top-right quadrant
            count += areaSize;
            solve(newSize, row, col + newSize);
        } else if (r >= row + newSize && c < col + newSize) {
            // Bottom-left quadrant
            count += 2 * areaSize;
            solve(newSize, row + newSize, col);
        } else {
            // Bottom-right quadrant
            count += 3 * areaSize;
            solve(newSize, row + newSize, col + newSize);
        }
    }
}
