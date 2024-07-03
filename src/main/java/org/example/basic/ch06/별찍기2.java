package org.example.basic.ch06;

import java.util.Arrays;
import java.util.Scanner;

public class 별찍기2 {
    static char[][] map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());

        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(map[i], '*');
        }

        compose(0, 0, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void compose(int x, int y, int side){
        if(side == 1){
            return;
        }
        side /= 3;

        drawHole(x, y, side);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                compose(x + (side * i), y + (side * j), side);
            }
        }
    }

    static void drawHole(int startX, int startY, int size){
        for (int i = startX + size; i < startX + size + size; i++) {
            for (int j = startY + size; j < startY + size + size; j++) {
                map[i][j] = ' ';
            }
        }
    }
}