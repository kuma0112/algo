package org.example.basic.ch06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Z_3 {
    static int N, r, c, ans;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        N = (int) Math.pow(2, N); // N을 2의 n제곱으로 변경

        // 원점부터 (r,c)까지의 거리
        int y = 0;
        int x = 0;

        Z(0,0);
        System.out.println(ans);

    }

    static void Z (int y, int x) {
        if (N==1) return;
        N /= 2;

        if(r < y + N && c < x + N) {
            Z(y,x);
        } else if (r < y + N && c >= x + N) {
            ans += N * N;
            Z(y,x+N);

        }else if (r >= y + N && c < x + N) {
            ans += N * N * 2;
            Z(y+N,x);

        }else if (r  >=  y + N && c >= x + N) {
            ans += N * N * 3;
            Z(y+N,x+N);

        }
    }
}
