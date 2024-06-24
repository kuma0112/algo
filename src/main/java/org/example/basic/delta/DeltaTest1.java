package org.example.basic.delta;

import java.util.Arrays;

// 2차원 배열 (문자) 만들기
public class DeltaTest1 {
    static char[][] map = new char[5][5];
    public static void main(String[] args) {
        char ch = 'A';

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                map[i][j] = ch++;
            }
        }

//         출력
        for (int i = 0; i < 5; i++) {
            System.out.println(Arrays.toString(map[i]));
        }

/*
[A, B, C, D, E]
[F, G, H, I, J]
[K, L, M, N, O]
[P, Q, R, S, T]
[U, V, W, X, Y]
 */

//        System.out.println(Arrays.deepToString(map).replace("],", "]\n"));
// [[A, B, C, D, E], [F, G, H, I, J], [K, L, M, N, O], [P, Q, R, S, T], [U, V, W, X, Y]]
/*
[[A, B, C, D, E]
 [F, G, H, I, J]
 [K, L, M, N, O]
 [P, Q, R, S, T]
 [U, V, W, X, Y]]
 */

//         y = 3, x = 3 자리의 상하좌우를 추력
//        print4_no_delta(3, 2);

        // 문제해결에 꼭 필요한 완전 탐색!
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                // 4방 탐색
//                print4(i, j);

//                // 대각선 탐색
                print4x(i, j);
//
//                // 8방 탐색
//                print8(i, j);
            }
        }

//        System.out.println(map[3][3]);
//        print4(3,3);
    }

    // if-else 구조의 4방 탐색은 개발자의 실수를 유발한다.
    // 따라서 상, 하, 좌, 우 이동에 대한 변화량을 미리 배열로 계산한다.
    // 상 (-1,0), 하 (+1, 0) 좌(0, -1), 우(0, +1)
    static void print4_no_delta(int y, int x) {
        // 상
        if(y -1 >= 0) {
            System.out.println(map[y-1][x]);
        }

        // 하
        if(y + 1 < 5) {
            System.out.println(map[y+1][x]);
        }

        // 좌
        if(x -1 >= 0) {
            System.out.println(map[y][x-1]);
        }

        // 우
        if(x + 1 < 5) {
            System.out.println(map[y][x+1]);
        }
        System.out.println();
    }

    // delta
    // 상하좌우
    // 문제에 따라 순서를 지켜야 하는 경우도 존재. 그때는 배열을 수정해야.
    static int dy4[] = {-1, 1, 0, 0};
    static int dx4[] = {0, 0, -1, 1};

    static void print4(int y, int x) {
        System.out.print(map[y][x] + " : ");
        for (int d = 0; d < 4; d++) {

            int ny = y + dy4[d];
            int nx = x + dx4[d];

            if(ny < 0 || nx < 0 || ny >= 5 || nx >= 5) continue; // 그리드를 벗어나는 점이니까 스킵
            System.out.print(map[ny][nx]);
        }
        System.out.println();
    }

    
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static String find4dChar(int x, int y){
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            try{
                result.append(map[y + dy[i]][x + dx[i]]);
            }catch (ArrayIndexOutOfBoundsException ignored){
            }
        }

        return result.toString();
    }

    // 대각선으로 움직이는 경우!
    // 좌상, 우상, 좌하, 우하
    static int dy4x[] = {-1, -1, 1, 1};
    static int dx4x[] = {-1, 1, -1, 1};

    static void print4x(int y, int x) {
        System.out.print(map[y][x] + " : ");

        for (int d = 0; d < 4; d++) {
            int ny = y + dy8[d];
            int nx = x + dx8[d];

            if(ny < 0 || nx < 0 || ny >= 5 || nx >= 5) continue; // 그리드를 벗어나는 점이니까 스킵
            System.out.print(map[ny][nx]);
        }
        System.out.println();
    }
    // delta를 잘 만드는것이 중요하다.

    // 8방 탐색이라면? 상하좌우 -> 대각선
    // 시계방향으로 움직인다면? 델타 다시 짜보기 or 체스 만들어보기
    static int dy8[] = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int dx8[] = {0, 0, -1, 1, -1, 1, -1, 1};

    static void print8(int y, int x) {
        System.out.print(map[y][x] + " : ");

        for (int d = 0; d < 8; d++) {
            int ny = y + dy8[d];
            int nx = x + dx8[d];

            if(ny < 0 || nx < 0 || ny >= 5 || nx >= 5) continue; // 그리드를 벗어나는 점이니까 스킵
            System.out.print(map[ny][nx]);
        }
        System.out.println();
    }
}
