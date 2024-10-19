package org.example.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 퇴사_14501 {
    static int N;
    static int[] pays;
    static int[] endDate;
    static List<List<Integer>> available;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pays = new int[N+1];
        endDate = new int[N+1];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int pay = Integer.parseInt(st.nextToken());
            // 1. 기간상 못하는 일은 일단 걸러낸다
            if ((i + time) > N) {
                pays[i+1] = 0;
            } else {
                pays[i+1] = pay;
                endDate[i+1] = i+time;
            }
        }
        
        // 2. 기간이 겹치지 않는 조합을 찾아낸다
        available = new ArrayList<>();
        // 3(1), 6(2), 3(3), 4(4), 6(5), 0(6), 0(7)
        for (int i = 1; i <= N ; i++) {
            int end = endDate[i];
            if (end==0) continue;

            List<Integer> list = new ArrayList<>();
            list.add(i);

            while(true) {
                int next = end+1;
                if (next > N) break;
                end = endDate[next];
                if (end==0) break;
                list.add(next);
            }
            available.add(list);
        }
        
        // 3. 일들의 비용을 합한다.
        int MAX = Integer.MIN_VALUE;
        for (List<Integer> list : available) {
            int sum = 0;
            for (int day: list) {
                sum += pays[day];
            }
            MAX = Math.max(MAX,sum);
        }
        System.out.println(MAX);
    }
}
