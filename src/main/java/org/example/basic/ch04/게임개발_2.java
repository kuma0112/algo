package org.example.basic.ch04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 게임개발_2 {
    static int n, m, y, x, dir, cnt;
    static boolean[][] visit;
    static int[][] map;

    // 북 -> 동 -> 남 -> 서 (시계방향)
    static int dy[] = {-1, 0, 1, 0};
    static int dx[] = {0, 1, 0, -1};

    // 왼쪽 회전
    static void turn_left() {
//      dir--;
//      if( dir == - 1) dir = 3;
        if (--dir == -1) dir = 3;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visit = new boolean[n][m];
        st = new StringTokenizer(br.readLine());

        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        dir = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 풀이 - 시물레이션
        visit[y][x] = true;
        cnt = 1;
        int turn_time = 0; // 같은 위치에서 왼쪽으로 turn 몇 번 했는지 체크 이동하면 0 초기화

        while (true) {
            // 왼쪽 turn
            turn_left();

            // turn 한 왼쪽으로 방문할 수 있으면 방문
            int ny = y + dy[dir];
            int nx = x + dx[dir];
            if (!visit[ny][nx] && map[ny][nx] == 0) {
                visit[ny][nx] = true;

                y = ny;
                x = nx;

                cnt++;
                turn_time = 0;
                continue;
            } else { // 방문할 수 없으면 다음 turn 체크
                turn_time++;

                if (turn_time == 4) { // 네 방향 모두 방문할 수 없으면

                    ny = y - dy[dir];
                    nx = x - dx[dir];

                    if (map[ny][nx] == 0) { // 뒤로 갈 수 있으면 이동
                        y = ny;
                        x = nx;
                    } else { // 뒤로 갈 수 없으면 이동 종료
                        break;
                    }

                    turn_time = 0;
                }
            }

            System.out.println(cnt);
        }
    }
}
/*
4 4
1 1 0
1 1 1 1
1 0 0 1
1 1 0 1
1 1 1 1
3
*/











