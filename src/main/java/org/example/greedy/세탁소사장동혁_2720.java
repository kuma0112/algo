package org.example.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 세탁소사장동혁_2720 {
    static int N;

    public static void main(String[] args) throws IOException {
        /**
         * c의 단위는 센트, 500센트까지니까 5달러까지
         * 1 쿼터는 25센트.
         * 1 다임은 10센트
         * 1 니켈은 5센트
         * 1 페니는 1센트
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 3
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine()); // 124
            solution(a);
        }
    }

    static void solution(int a) {
        StringBuilder sb = new StringBuilder();
        int left;

        int quarter = a / 25;
        left = a % 25;

        int nickel = left / 10;
        left = left % 10;

        int dime = left / 5;
        left = left % 5;

        int penny = left;

        sb.append(quarter).append(" ").append(nickel).append(" ").append(dime).append(" ").append(penny);
        System.out.println(sb.toString());
    }
}
