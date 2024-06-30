package org.example.basic.ch06;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 쿼드트리 {
    static int N;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 8

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(quadTree(0, 0, N));
    }

    static String quadTree(int y, int x, int size) {
        // 1. 먼저 범위 안에 있는 친구들이 모두 0인지, 1인지, 아니면 섞여 있는지 확인
        if (isSameValue(y, x, size)) {
            // 0이면 리턴 0, 1이면 리턴 1
            return String.valueOf(map[y][x]);
        }
        // 섞여 있으면 범위 쪼개기
        int newSize = size / 2;
        StringBuilder sb = new StringBuilder();

        // 이 행동을 반복
        sb.append("(");
        sb.append(quadTree(y, x, newSize));
        sb.append(quadTree(y, x + newSize, newSize));
        sb.append(quadTree(y + newSize, x, newSize));
        sb.append(quadTree(y + newSize, x + newSize, newSize));
        sb.append(")");

        return sb.toString();
    }

    static boolean isSameValue(int y, int x, int size) {
        int value = map[y][x];
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
