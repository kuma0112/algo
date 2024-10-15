package org.example.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 동전뒤집기_복습 {
    static int N;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        solution();
    }

    static void solution() {
        int answer = Integer.MAX_VALUE;
        for(int bitCase = 0; bitCase < (1<<N); bitCase++) {
            int sum = 0;
            for(int j = 0; j < N; j++) {
                int count = 0;
                for (int i = 0; i < N; i++) {
                    char temp = map[i][j];
                    if((bitCase & (1<<i))!=0) {
                        temp = reverse(temp);
                    }
                    if (temp == 'T') count++;
                }
                sum += Math.min(count, N-count);
            }
            answer = Math.min(answer, sum);
        }

        System.out.println(answer);
    }

    static char reverse(char temp) {
        if (temp == 'T') return 'H';
        else return 'T';
    }
}
