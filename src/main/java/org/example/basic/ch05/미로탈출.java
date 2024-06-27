package org.example.basic.ch05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탈출 {
    static int n, m;
    static int[][] map;
    static class Node {
        int y, x;
        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    static Queue<Node> queue = new ArrayDeque<>();
    static int[] dy = { -1, 1, 0, 0 };
    static int[] dx = {  0, 0,-1, 1 };

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

        System.out.println(bfs(0,0));
    }

    static int bfs(int y, int x) {

        queue.offer(new Node(y,x));
        map[y][x] = 1; // 현재 위치를 1로 둠,

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int d = 0; d < 4; d++) {
                // 새롭게 갈 자리를 물색한다.
                int ny = node.y + dy[d];
                int nx = node.x + dx[d];

                // 갈 곳이 범위 안에 있는지 체크
                if( ny < 0 || nx < 0 || ny >= n || nx >= m ) continue;
                // 갈 곳에 괴물이 있는지, 체크
                if( map[ny][nx] == 0 ) continue;
                // 갈 수 있는 경우
                if( map[ny][nx] == 1) {
                    // 현재 위치 1에서 갈 곳의 값을 2로, 다음 갈 곳은 3으로...
                    map[ny][nx] = map[node.y][node.x] +1;
                    // 새롭게 노드를 만들어서 큐에 넣기
                    queue.offer(new Node(ny, nx));
                }
            }
        }
        return map[n-1][m-1]; // 0,0에서 시작했으니...
    }
}
