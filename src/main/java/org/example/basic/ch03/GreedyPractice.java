package org.example.basic.ch03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GreedyPractice {
    /*
2
5
11122
####*
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTestCase = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        char[][] map = new char[2][M];

        for (int i = 0; i < M; i++) {
            String numberLine = br.readLine();
            StringTokenizer st = new StringTokenizer(numberLine); // 11122
            map[0][i] = st.nextToken().charAt(0);
        }

        for (int i = 0; i < M; i++) {
            String bombLine = br.readLine();
            StringTokenizer st = new StringTokenizer(bombLine); // ####*
            map[1][i] = st.nextToken().charAt(0);
        }



    }
}
