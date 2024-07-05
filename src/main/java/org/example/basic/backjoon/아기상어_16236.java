package org.example.basic.backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 아기상어_16236 {
    static int size = 2;
    static int foodSum, N, time, numberOfFish;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visited;
    static int currentY, currentX;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        currentY = 0;
        currentX = 0;

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    currentY = i;
                    currentX = j;
                    map[i][j] = 0;
                } else if (map[i][j] != 0) numberOfFish++;
            }
        }
        while (numberOfFish > 0) {
            visited = new boolean[N][N];
            if (!move(currentY, currentX, 0)) break;
        }

        System.out.println(time);
    }

    static boolean move(int y, int x, int dist) {
        visited[y][x] = true;
        int minDist = Integer.MAX_VALUE;
        int nextY = -1, nextX = -1;

        for (int d = 0; d < 4; d++) {
            // 일단 이동할 곳 물색
            int ny = y + dy[d];
            int nx = x + dx[d];

            // 갈곳이 범위를 넘지 않는지 우선 확인
            if (ny < 0 || nx < 0 || ny >= N || nx >= N) continue;

            // 갈 곳에 물고기 있는지 확인. 크기 확인
            if (map[ny][nx] != 0 && map[ny][nx] < size) {
                if (dist + 1 < minDist) {
                    minDist = dist + 1;
                    nextY = ny;
                    nextX = nx;
                } else if (dist + 1 == minDist) {
                    if (ny < nextY || (ny == nextY && nx < nextX)) {
                        nextY = ny;
                        nextX = nx;
                    }
                }
            } else {
                if (move(ny, nx, dist + 1)) return true;
            }
        }
        if (nextY != -1 && nextX != -1) {
            eat(nextY, nextX, minDist);
            return true;
        }
        return false;
    }


    static void eat(int ny, int nx, int dist) {
        map[ny][nx] = 0;
        foodSum++;
        time += dist;
        numberOfFish--;
        if (foodSum == size) {
            size++;
            foodSum = 0;
        }
        currentY = ny;
        currentX = nx;
    }
}
