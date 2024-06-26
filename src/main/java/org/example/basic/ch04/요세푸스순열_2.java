package org.example.basic.ch04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 자료구조1 배열 : 배열 전체를 순회 흐름 + 그 안에 살아 있는 사람만 순회 흐름
// 자료구조2 arraylist, queue

public class 요세푸스순열_2 {
    static int N, K;
    static int[] input;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        input = new int[N+1]; // 출려번호가 1부터 시작됨. 0은 더미;

        // 번호를 채우고, 죽으면 0으로 변경할 예정
        for (int i = 0; i <= N; i++) {
            input[i] = i;
        }

        int deathCnt = 0; // 죽은 숫자의 수. 모두 죽으면 종료 (deathCnt == n)
        int idx = 1; // 죽은 사람을 포함하는 배열의 인덱스
        int aliveCnt = 1; // 살아 있는 번호에서만 증가 => k 번째 판단하기 위해
        sb.append("<");

        while(true) {
            if (deathCnt == N) break;

            if (input[idx] != 0) {
                if ((aliveCnt % K) == 0) {
                    sb.append(input[idx]).append(", ");
                    input[idx] = 0;
                    deathCnt++;
                }
                aliveCnt++;
            }

            idx ++;
            if (idx > N) idx = 1;
        }
        sb.setLength(sb.length()-2); // 뒤에칸 두 개 줄여서 ", " 부분 빼기
        sb.append(">");
    }
}

















