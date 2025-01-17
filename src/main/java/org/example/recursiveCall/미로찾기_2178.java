package org.example.recursiveCall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 미로찾기_2178 {
    static int N, M;
    static char[][] matrix;
    static boolean[][] visited;
    static int[][] distance;

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        distance = new int[N][M];

        matrix = new char[N][];
        for (int i = 0; i < N; i++) {
            matrix[i] = br.readLine().toCharArray();
        }

        bfs(0, 0);
        System.out.println(distance[N - 1][M - 1]);
    }

    static void bfs(int y, int x) {
        Queue<Node> queue = new LinkedList<>();
        Node node = new Node(y, x);
        queue.add(node);
        visited[y][x] = true;
        distance[y][x] = 1;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newY = cur.y + dy[i];
                int newX = cur.x + dx[i];
                if (newY >= 0 && newX >= 0 && newY < N && newX < M && !visited[newY][newX] && matrix[newY][newX] == '1') {
                    Node newNode = new Node(newY, newX);
                    queue.add(newNode);
                    visited[newY][newX] = true;
                    distance[newY][newX] = distance[cur.y][cur.x] + 1;
                }
            }
        }
    }

    static class Node {
        int y;
        int x;
        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
