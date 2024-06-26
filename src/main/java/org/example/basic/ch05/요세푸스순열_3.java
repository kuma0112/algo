package org.example.basic.ch05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// queue : 꺼내서 k번째이면 죽이고 그렇지 않으면 다시 넣기
public class 요세푸스순열_3 {
    static int N, K;
    static Queue<Integer> queue = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 번호를 채우고, 죽으면 0으로 변경할 예정
        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        int aliveCnt = 1; // 살아 있는 번호에서만 증가 => k 번째 판단하기 위해
        sb.append("<");

        while(!queue.isEmpty()) {
            int num = queue.poll();
            if ((aliveCnt % K) == 0) {
                sb.append(num).append(", ");
            } else {
                queue.offer(num);
            }
            aliveCnt++;
        }

        sb.setLength(sb.length()-2); // 뒤에칸 두 개 줄여서 ", " 부분 빼기
        sb.append(">");
        System.out.println(sb.toString());
    }
}

















