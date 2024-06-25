package org.example.basic.ch04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 게임개발 {
    static int n, m, count;
    static int[][] map;
    static boolean[][] visited;
    static int[] dy4 = {-1, 0, 1, 0}; // 북 동 남 서
    static int[] dx4 = {0, 1, 0, -1};
    // 방향 회전 함수
    public static int turnLeft(int direction) {
        direction -= 1;
        if (direction < 0) {
            direction = 3;
        }
        return direction;
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();

        // 1. 맵의 크기(N, M) 입력받기
        StringTokenizer st = new StringTokenizer(str1);
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 2. 방문 위치 맵(visited) 생성 및 초기화
        visited = new boolean[n][m];
        map = new int[n][m];

        // 3. 현재 좌표(y, x)와 방향(direction) 입력받기
        st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int direction = Integer.parseInt(st.nextToken());

        // 4. 현재 좌표 방문 처리 & 횟수 +1
        visited[y][x] = true;
        count = 1;

        // 5. 전체 맵(바다와 육지 정보) 입력받기
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 6. 시뮬레이션 시장
        int turnTime = 0;

        while(true) {
            // 7. 왼쪽방향으로 회전 후 갈곳 물색
            direction = turnLeft(direction);
            int ny = y + dy4[direction];
            int nx = x + dx4[direction];

            // 8. 갈곳이 방문한 적이 없고 육지라면
            // 방문 체크 + 이동 + 횟수+1 + 이동을 했으니 회전 수는 초기화
            if (!visited[ny][nx] && map[ny][nx] == 0) {
                visited[ny][nx] = true;
                y = ny;
                x = nx;
                count++;
                turnTime = 0;
                continue;

            // 만약 갈 수 없다면 회전 수++
            } else {
                turnTime++;
            }

            // 회전 수가 4에 도달하면
            if (turnTime==4) {
                // 뒤로 갈곳 물색
                ny = y - dy4[direction];
                nx = x - dx4[direction];

                // 갈 곳이 있다면 이동하고 밑에서 회전 수를 초기화하고 다시 while루프를 돈다.
                if (map[ny][nx] == 0) {
                    y = ny;
                    x = nx;

                // 갈 곳이 없다면 움직임을 멈추고 while루프 다음에 있는 코드를 실행한다.
                } else {
                    break;
                }

                turnTime = 0;
            }
        }
        System.out.println(count);
    }
}
