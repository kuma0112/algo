package org.example.basic.ch03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 숫자_카드_게임_2 {
    static int N, M, result;
    static int[][] map;
    /*
3 3
3 1 2
4 1 4
2 2 2
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            int minInRow = 10001;
            for (int j = 0; j < M; j++) {
                minInRow = Math.min(minInRow, map[i][j]);
            }
            result = Math.max(result, minInRow);
        }

        // 위가 일반적이지만 입력을 따로 자료구조에 담지 않아도 바로 받으면서 처리하는 방법이 있음!
        // 문제를 잘 읽고 아래의 방법을 채택할 것.
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int min_value = 10001;
            for (int j = 0; j < M; j++) {
                min_value = Math.min(min_value, Integer.parseInt(st.nextToken()));
            }
            // '가장 작은 수'들 중에서 가장 큰 수 찾기
            result = Math.max(result, min_value);
        }

        System.out.println(result);
    }
}
