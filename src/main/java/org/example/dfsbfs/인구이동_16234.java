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
        // 더 이상 인구이동이 없을 때까지 인구이동 계속
        while(true) {
            // 초기화
            visited = new boolean[N][N];
            // 인구이동 있는지 없는지를 체크
            boolean isMoved = false;
            // 모든 칸을 다 돌면서, bfs로 연결된, 즉 '연합'이 있는지 없는지 완탐
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 방문한 칸은 다시 가지 않음
                    if (!visited[i][j]) {
                        // 연합 있나요? -> 네네 -> isMoved가 true
                        if (findUnion(new Node(i, j, map[i][j]))) {
                            isMoved = true;
                        }
                    }
                }
            }
            // 더 이상 인구이동 없으면 while문 멈춤
            if (!isMoved) { break; }
            // 인구이동 날짜 1일 증가
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

        // 일단 이 칸은 인구이동이 있을 것이라고 가정하고 시작
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

        // 연합이 자기 자신밖에 없다? -> 연합을 찾지 못했다라는 뜻
        // countries가 2이상인 경우만 인구이동을 진행
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
