package org.example.basic.backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빵집_해설 {
    static int R, C, ans;
    static char[][] map;
    static int[] dy = {-1, 0, 1};
    static int[] dx = {1, 1, 1};
    // visit 쓰지 않는 이유. 대신 x를 친다.
    // 좌표 따라가서 성공 -> 이미 그 자리에 파이프가 있다
    // 좌표 따라가서 실패 -> 그 자리에 갈 필요가 없다

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][];
        for (int i = 0; i <R ; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < R; i++) {
            if (dfs(i, 0)) {
                ans++;
            }
        }

        System.out.println(ans);
    }

    static boolean dfs(int y, int x) {
        int nx = x +1 ;
        if (nx == C-1) { // 경로 완성
            return true;
        }

        for (int d = 0; d < 3; d++) {
            int ny = y + dy[d];

            // x는 따로 체크하지 않는다.
            if (ny < 0 || ny >= R || map[ny][nx] == 'x') continue;

            map[ny][nx] = 'x';
            if (dfs(ny, nx)) {
                return true;
            }
        }
        return false;
    }

}
