package org.example.basic.ch05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 음료수얼려먹기 {
    static int n, m, count;
    static int[][] map;
    static boolean[][] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);

        n = Integer.parseInt(st.nextToken()); // 15
        m = Integer.parseInt(st.nextToken()); // 14
        visit = new boolean[n][m];

        // 1. 인접행렬로 풀기
        // 1) 입력을 받는다.
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        // 2) bfs를 돌면서 0인 친구들을 만나면 +1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0 && !visit[i][j]) {
                    bfs(i, j);
//                    dfs(i, j);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    static void bfs(int x, int y) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y});
        visit[x][y] = true;

        while (!queue.isEmpty()) {
            int[] k = queue.poll();
            int currentX = k[0];
            int currentY = k[1];
            for (int i = 0; i < 4; i++) {
                int newX = currentX + dx[i];
                int newY = currentY + dy[i];

                if (newX >= 0 && newX < n && newY >= 0 && newY < m) {
                    if (map[newX][newY] == 0 && !visit[newX][newY]) {
                        queue.offer(new int[]{newX, newY});
                        visit[newX][newY] = true;
                    }
                }
            }
        }
    }

    static void dfs(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m || map[x][y] != 0 || visit[x][y]) {
            return;
        }

        visit[x][y] = true;
        dfs(x - 1, y);
        dfs(x + 1, y);
        dfs(x, y - 1);
        dfs(x, y + 1);
    }
}
