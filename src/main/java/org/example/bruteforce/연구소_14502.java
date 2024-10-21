package org.example.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연구소_14502 {
    static int N,M;
    static int[][] map;
    static int[][] tempMap;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int MAX = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        tempMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        buildWalls(0);
        System.out.println(MAX);
    }

    static void buildWalls(int count) {
        if (count == 3) {
            virus();
            MAX = Math.max(MAX, countSafeArea());
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 0) {
                    map[i][j] = 1;
                    buildWalls(count + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    static void virus() {
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tempMap[i][j] =map[i][j];
                if (tempMap[i][j] == 2) {
                    queue.add(new int[] {i, j});
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] virus = queue.poll();
            int x = virus[0];
            int y = virus[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && tempMap[nx][ny] == 0) {
                    tempMap[nx][ny] = 2;
                    queue.add(new int[] {nx, ny});
                }
            }
        }
    }

    static int countSafeArea() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(tempMap[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
