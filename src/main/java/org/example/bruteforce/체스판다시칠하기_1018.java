package org.example.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 체스판다시칠하기_1018 {
    static int N,M;
    static char[][] map;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 세로
        N = Integer.parseInt(st.nextToken()); // 가로

        map = new char[M][N];
        for (int i = 0; i < M; i++) {
            map[i] = br.readLine().toCharArray();
        }

        solution();
        System.out.println(min);
    }

    static void solution() {
        for (int i = 0; i <= M-8; i++) {
            for (int j = 0; j <= N-8; j++) {
                checkChessBoard(i, j);
            }
        }
    }

    static void checkChessBoard(int x, int y) {
        int whiteStart = 0; // 흰색로 시작하는 체스판으로 변환할 때 칠해야 하는 칸 수
        int blackStart = 0; // 검은색로 시작하는 체스판으로 변환할 때 칠해야 하는 칸 수

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i+j) % 2 == 0) {
                    if (map[x+i][y+j] != 'W') whiteStart++;
                    if (map[x+i][y+j] != 'B') blackStart++;
                } else {
                    if (map[x+i][y+j] != 'B') whiteStart++;
                    if (map[x+i][y+j] != 'W') blackStart++;
                }
            }
        }
        min = Math.min(min,Math.min(whiteStart, blackStart)) ;
    }
}
