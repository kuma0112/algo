package org.example.basic.ch05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 단지번호붙이기 {
    static int n, numberOfDistrict;
    static char[][] map;

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static class Node {
        int y, x;

        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static Queue<Node> queue = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        map = new char[n][];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        List<Integer> countArray = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == '1') {
//                    countArray.add(bfs(i, j));
                    numberOfDistrict++;
                    countArray.add(dfs(i, j));
                }
            }
        }
        System.out.println(numberOfDistrict);
        Collections.sort(countArray);
        for (int count : countArray) {
            System.out.println(count);
        }

    }

    static int bfs(int y, int x) {
        map[y][x] = '0';
        int count = 1;
        queue.offer(new Node(y, x));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int d = 0; d < 4; d++) {
                int ny = node.y + dy[d];
                int nx = node.x + dx[d];

                if (ny < 0 || nx < 0 || ny >= n || nx >= n || map[ny][nx] != '1')  continue;
                map[ny][nx] = '0';
                count++;
                queue.offer(new Node(ny, nx));
            }

        }
        return count;
    }

    static int dfs(int y, int x) {
        // 주어진 범위를 벗어나는 경우에는 즉시 종료
        if (y < 0 || x < 0 || y >= n || x >= n|| map[y][x] != '1') {
            return 0;
        }
        map[y][x] = '0';
        int count = 1;

        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];
            count += dfs(ny, nx);
        }
        return count;
    }
}