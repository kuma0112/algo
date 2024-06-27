package org.example.basic.ch05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 단지번호붙이기_prac {
    static int n;
    static int number = 1;
    static char[][] map;
    static List<Integer> list;

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }
        list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == '1') {
//                    dfs(i, j);
                    bfs(i, j);
                    list.add(number);
                    number = 1;
                }
            }
        }

        System.out.println(list.size());
        Collections.sort(list);
        for(int i : list) {
            System.out.println(i);
        }
    }

    static void dfs(int y, int x) {
        map[y][x] = '0';

        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];

            if( ny < 0 || nx < 0 || ny >= n || nx >= n || map[ny][nx] != '1' ) continue;

            number += 1;
            dfs(ny, nx);
        }
    }

    static void bfs(int y, int x) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(y, x));
        map[y][x] = '0';

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int d = 0; d < 4; d++) {
                int ny = node.y + dy[d];
                int nx = node.x + dx[d];
                if (ny < 0 || nx < 0 || ny >= n || nx >= n|| map[ny][nx] != '1' ) continue;
                map[ny][nx] = '0';
                number += 1;
                queue.offer(new Node(ny, nx));
            }

        }
    }

    static class Node {
        int y, x;
        Node (int y, int x ) {
            this.y = y;
            this.x = x;
        }
    }
}
