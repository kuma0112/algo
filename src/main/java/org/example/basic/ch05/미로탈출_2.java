package org.example.basic.ch05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// Node에 cnt 추가하기
public class 미로탈출_2 {
    static int n, m, answer;
    static int[][] map;

    static class Node {
        int y, x, cnt;
        Node(int y, int x, int cnt) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }
    }

    static Queue<Node> queue = new ArrayDeque<>();

    static int[] dy = { -1, 1, 0, 0 };
    static int[] dx = {  0, 0,-1, 1 };
    static boolean[][] visit;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        visit = new boolean[n][m];
        bfs();
        System.out.println(answer);
    }

    static void bfs() {
        visit[0][0] = true;
        queue.offer(new Node(0,0,1));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int y = node.y;
            int x = node.x;
            int cnt = node.cnt;
            for (int d = 0; d < 4; d++) {
                // 새롭게 갈 자리를 물색한다.
                int ny = y + dy[d];
                int nx = x + dx[d];

                // 갈 수 있는지 체크
                if( ny < 0 || nx < 0 || ny >= n || nx >= m || map[ny][nx] == 0 ) continue;

                // 도착지점 확인
                if (ny == n-1 || nx == m-1) {
                    answer = cnt +1;
                    return;
                }

                visit[ny][nx] = true;
                queue.offer(new Node(ny, nx, cnt+1));
            }
        }
    }
}
