package org.example.basic.delta;

// 한 칸 이동이 아닌 갈 수 있을 때까지 계속 이동
public class DeltaTest2 {
    static char[][] map = new char[5][5];
    public static void main(String[] args) {
        char ch = 'A';

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                map[i][j] = ch++;
            }
        }

        // 탐색
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
//                print4_ultimate(i, j);
//                print4x_ultimate(i, j);
                print8_ultimate(i, j);
            }
        }
    }

    // 갈 때까지 가보는 4방 탐색
    static int dy4[] = {-1, 1, 0, 0};
    static int dx4[] = {0, 0, -1, 1};

    static void print4_ultimate ( int y, int x){
        System.out.print(map[y][x] + " : ");

        for (int d = 0; d < 4; d++) {
            // 반복문으로 구성, ny = y... -> ny = ny...
            // while 문 안에서 자기 자신에게 계속 더하거나 빼서 이동하도록
            int ny = y;
            int nx = x;

            while (true) {
                ny = ny + dy4[d];
                nx = nx + dx4[d];

                if (ny < 0 || nx < 0 || ny >= 5 || nx >= 5) break; // 가다가 그리드 넘으면 멈추기 -> while 문 벗어날 수 있음
                System.out.print(map[ny][nx]);
            }


        }
        System.out.println();
    }

    // 갈 때까지 가보는 대각선 탐색
    static int dy4x[] = {-1, -1, 1, 1};
    static int dx4x[] = {-1, 1, -1, 1};

    static void print4x_ultimate ( int y, int x){
        System.out.print(map[y][x] + " : ");

        for (int d = 0; d < 4; d++) {
            // 반복문으로 구성, ny = y... -> ny = ny...
            // while 문 안에서 자기 자신에게 계속 더하거나 빼서 이동하도록
            int ny = y;
            int nx = x;

            while (true) {
                ny = ny + dy4x[d];
                nx = nx + dx4x[d];

                if (ny < 0 || nx < 0 || ny >= 5 || nx >= 5) break; // 가다가 그리드 넘으면 멈추기 -> while 문 벗어날 수 있음
                System.out.print(map[ny][nx]);
            }
        }
        System.out.println();
    }

    // 갈 때까지 가보는 8방 탐색
    static int dy8[] = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int dx8[] = {0, 0, -1, 1, -1, 1, -1, 1};

    static void print8_ultimate ( int y, int x){
        System.out.print(map[y][x] + " : ");

        for (int d = 0; d < 8; d++) {
            // 반복문으로 구성, ny = y... -> ny = ny...
            // while 문 안에서 자기 자신에게 계속 더하거나 빼서 이동하도록
            int ny = y;
            int nx = x;

            while (true) {
                ny = ny + dy8[d];
                nx = nx + dx8[d];

                if (ny < 0 || nx < 0 || ny >= 5 || nx >= 5) break; // 가다가 그리드 넘으면 멈추기 -> while 문 벗어날 수 있음
                System.out.print(map[ny][nx]);
            }
        }
        System.out.println();
    }
}
