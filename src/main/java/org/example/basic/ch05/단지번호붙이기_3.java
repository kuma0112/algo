package org.example.basic.ch05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// dfs + visit
public class 단지번호붙이기_3 {
    static int N, cnt; // 단지별 수
    static char[][] map;
    static boolean[][] visit;

    static int[] dy = { -1, 1, 0, 0 };
    static int[] dx = {  0, 0,-1, 1 };

    static List<Integer> list = new ArrayList<>(); // 각 단지별 수 추가, 나중에 정렬
    static Queue<Node> queue = new ArrayDeque<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new char[N][];
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        // 풀이
        // 2차원 배열을 순회하면서 새로운 영역이 나오면 dfs 수행
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if( map[i][j] != '1' || visit[i][j] ) continue;
                bfs(i, j); // 한번만 호출될테니 초기화하는 부분 필요없음
                list.add(cnt);
            }
        }

        Collections.sort(list); // 정렬
        System.out.println(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            System.out.println(list.get(i));
        }
    }

    static void bfs(int y, int x) {
        cnt = 1; // 처음 호출되면 새로운 단지를 발견한 것
        visit[y][x] = true;

        queue.offer(new Node(y, x));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int d = 0; d < 4; d++) {
                int ny = node.y + dy[d];
                int nx = node.x + dx[d];

                if( ny < 0 || nx < 0 || ny >= N || nx >= N ) continue;
                if( map[ny][nx] != '1' || visit[ny][nx] ) continue;

                cnt ++;
                visit[ny][nx] = true;
                queue.offer(new Node(ny, nx));
            }
        }
    }

    static class Node {
        int y, x;
        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}