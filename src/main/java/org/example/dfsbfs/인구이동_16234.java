package org.example.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 인구이동_16234 {
    static int N, L, R, count;
    static int[][] map;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 총 땅 크기 N*N
        L = Integer.parseInt(st.nextToken()); // 인구 차이가 L명 이상
        R = Integer.parseInt(st.nextToken()); // R명 이하라면 국경선이 하루 동안 열린다.

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        count = 0;
        while(true) {
            visited = new boolean[N][N];
            boolean isMoved = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        if (findUnion(new Node(i, j, map[i][j]))) {
                            isMoved = true;
                        }
                    }
                }
            }
            if (!isMoved) { break; }
            count++;
        }

        System.out.println(count);
    }

    static boolean findUnion(Node start) {
        Queue<Node> queue = new LinkedList<>();
        List<Node> union = new ArrayList<>();

        queue.add(start);
        union.add(start);
        visited[start.r][start.c] = true;

        int total = map[start.r][start.c];
        int countries = 1;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            int y = cur.r;
            int x = cur.c;
            int numOfPeople = cur.num;

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny >= 0 && ny < N && nx >= 0 && nx < N && !visited[ny][nx]) {
                    int newNum = map[ny][nx];
                    int diff = Math.abs(numOfPeople - newNum);
                    if (diff >= L &&  diff <= R) {
                        Node newNode = new Node(ny, nx, map[ny][nx]);
                        visited[ny][nx] = true;
                        queue.add(newNode);
                        union.add(newNode);
                        total += map[ny][nx];
                        countries++;
                    }
                }
            }
        }

        if (countries > 1) {
            int newPopulation = total / countries;
            for (Node node : union) {
                map[node.r][node.c] = newPopulation;
            }
            return true;
        }
        return false;
    }

    static class Node {
        int r;
        int c;
        int num;

        Node(int r, int c, int num) {
            this.r = r;
            this.c = c;
            this.num = num;
        }
    }
}
