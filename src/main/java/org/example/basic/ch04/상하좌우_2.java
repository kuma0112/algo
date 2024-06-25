package org.example.basic.ch04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 상하좌우_2 {
    // BufferedReader, static
    // String[] plans -> char[]
    // moveTypes와 delta 제거 : switch 변경
/*
5
R R R U D D
 */
    // plans를 배열로 만들면 어떤지 생각해보기 String[] plans = {"U", "D", "L", "R"};
    static int n;
    static char[] plans;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = st.countTokens(); // 전체 잘라낸 녀석들의 길이를 리턴
        plans = new char[count];

        int y = 1, x = 1;

        for (int i = 0; i < count; i++) {
            plans[i] = st.nextToken().charAt(0);
        }

        for (int i = 0; i < count; i++) {
            int ny = y;
            int nx = x;

            switch (plans[i]) {
                case 'L' : nx = nx - 1; break;
                case 'R' : nx = nx + 1; break;
                case 'U' : ny = ny - 1; break;
                case 'D' : ny = ny + 1; break;
            }

            if (ny < 1 || nx < 1 || ny > n || nx > n) continue;

            y = ny;
            x = nx;
        }
        System.out.println(y + " " + x);
    }
}
