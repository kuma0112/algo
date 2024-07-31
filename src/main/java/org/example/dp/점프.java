package org.example.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 점프 {
    static int N;
    static int[][] map;
    static int[][] visited;
    static int count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        visited = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(1, 1);
        System.out.println(count);
    }

    static void solution(int y, int x) {
        if (y == N && x == N) {
            count++;
            return;
        }

        int distance = map[y][x]; // 뛸 수 있는 거리

        if (distance == 0) return;

        int ny = y + distance;
        int nx = x + distance;

        if (ny <= N && visited[ny][x] == 0) {
            visited[ny][x] = 1;
            solution(ny, x);
            visited[ny][x] = 0;
        }

        if (nx <= N && visited[y][nx] == 0) {
            visited[y][nx] = 1;
            solution(y, nx);
            visited[y][nx] = 0;
        }
    }
}
