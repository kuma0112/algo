package org.example.basic.backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 도맛음_bitmasking {
    static int N, min;
    static int[][] src;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        src = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            src[i][0] = Integer.parseInt(st.nextToken());
            src[i][1] = Integer.parseInt(st.nextToken());
        }

        min = Integer.MAX_VALUE;

        subset(0, 0); // 첫 번째 재료부터 시작, 00000

        System.out.println(min);
    }

    static void subset(int srcIdx, int mask) {
        if (srcIdx == N) {
            // 부분집합의 한 경우가 만들어진 상태
            int sin = 1;
            int ssn = 0;
            int cnt = 0;

            for (int i = 0; i < N; i++) {
                if ((mask & (1 << i)) != 0) { // mask의 bit 표현 중 i 번째가 1인지 0인지 확인
                    sin *= src[i][0];
                    ssn += src[i][1];
                    cnt++;
                }
            }

            if (cnt >0) {
                min = Math.min(min, Math.abs(sin-ssn));
            }
            return;
        }

        subset(srcIdx+1, mask | 1 << srcIdx); // 현재 재료 선택

        subset(srcIdx+1, mask); // 현재 재료를 (srcIdx) 선택 X
    }
}
