package org.example.basic.ch06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Z_2 {
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


        // 반복문으로 분할 정복
        // (r,c) 위치까지 찾아질 동안 계속 분할 처리
        while(true) {
            if (N == 1) break; // 더 이상 쪼갤 수 없을 때

            N /= 2;

            if(r < y + N && c < x + N) {

            } else if (r < y + N && c >= x + N) {
                ans += N * N;
                x += N;

            } else if (r >= y + N && c < x + N) {
                ans += N * N * 2;
                y += N;

            } else if (r  >=  y + N && c >= x + N) {
                ans += N * N * 3;
                x += N;
                y += N;

            }
        }
        System.out.println(ans);

    }
}
