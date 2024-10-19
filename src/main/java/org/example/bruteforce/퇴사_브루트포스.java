package org.example.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퇴사_브루트포스 {
    static int N;
    static int[] time;
    static int[] pay;
    static int MAX = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        time = new int[N+1];
        pay = new int[N+1];

        for (int i = 1; i <=N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            pay[i] = Integer.parseInt(st.nextToken());
        }
        dfs(1,0);
        System.out.println(MAX);
    }

    static void dfs(int day, int totalPay) {
        // 정확하게 퇴사날까지의 최대값을 확인하고 갱신
        if (day == N + 1) {
            MAX = Math.max(MAX,totalPay);
            return;
        }

        // 상담일이 넘어가는 경우에는 pay를 더하지 않고 그 순간의 최대값을 확인하고 갱신
        if (day > N) {
            MAX = Math.max(MAX,totalPay);
            return;
        }

        if (day + time[day] <= N+1) {
            dfs(day + time[day], totalPay + pay[day]);
        }

        dfs(day + 1, totalPay);

    }
}
