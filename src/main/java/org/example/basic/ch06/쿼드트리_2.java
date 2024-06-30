package org.example.basic.ch06;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 쿼드트리_2 {
    static int N;
    static char[][] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 8

        map = new char[N][];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        divide(0, 0, N);
        System.out.println(sb);
    }

    static void divide(int y, int x, int size) {
        // y, x, 좌표를 왼쪽 위 시작점으로 하고, 가로, 세로 n 길이만큼 문자가 모두 같은지 확인
        if (isSameValue(y, x, size)) {
            sb.append(map[y][x]);
        } else {
            sb.append("(");

            int half = size / 2;

            divide (y, x, half);
            divide ( y, x+half, half);
            divide ( y+half, x, half);
            divide ( y+half, x+half, half);

            sb.append(")");
        }
    }

    static boolean isSameValue(int y, int x, int size) {
        char value = map[y][x];
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (map[i][j] != value) {
                    return false;
                }
            }
        }
        return true;
    }
}
