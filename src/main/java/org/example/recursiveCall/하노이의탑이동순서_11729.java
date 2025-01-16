package org.example.recursiveCall;

import java.io.*;

public class 하노이의탑이동순서_11729 {
    static int N, count;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        hanoi(N, 1, 2, 3);
        System.out.println(count);
        System.out.print(sb.toString());
    }

    static void hanoi(int num, int start, int mid, int end) throws IOException {
        if (num == 1) {
            count ++;
            sb.append(start).append(" ").append(end).append("\n");
            return;
        }

        hanoi(num - 1, start, end, mid);
        hanoi(1, start, mid, end);
        hanoi(num - 1, mid, start, end);
    }
}
