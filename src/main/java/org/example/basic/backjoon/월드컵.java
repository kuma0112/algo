package org.example.basic.backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 월드컵 {
    static int[][] match = new int[6][3];
    static int[][] games = new int[15][2];
    static boolean isPossible;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 15개의 경기 (6개 팀, 각 경기의 팀 번호를 미리 배열로 설정)
        int index = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 6; j++) {
                games[index][0] = i;
                games[index][1] = j;
                index++;
            }
        }

        for (int k = 0; k < 4; k++) {
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 3; j++) {
                    match[i][j] = sc.nextInt();
                }
            }
            isPossible = false;
            simulate(0);
            System.out.println(isPossible ? 1 : 0);
        }
        sc.close();
    }

    public static void simulate(int gameIndex) {
        if (gameIndex == 15) {
            for (int i = 0; i < 6; i++) {
                if (match[i][0] != 0 || match[i][1] != 0 || match[i][2] != 0) {
                    return;
                }
            }
            isPossible = true;
            return;
        }

        int team1 = games[gameIndex][0];
        int team2 = games[gameIndex][1];

        // team1이 이기고 team2가 지는 경우
        if (match[team1][0] > 0 && match[team2][2] > 0) {
            match[team1][0]--;
            match[team2][2]--;
            simulate(gameIndex + 1);
            match[team1][0]++;
            match[team2][2]++;
        }

        // team1과 team2가 비기는 경우
        if (match[team1][1] > 0 && match[team2][1] > 0) {
            match[team1][1]--;
            match[team2][1]--;
            simulate(gameIndex + 1);
            match[team1][1]++;
            match[team2][1]++;
        }

        // team1이 지고 team2가 이기는 경우
        if (match[team1][2] > 0 && match[team2][0] > 0) {
            match[team1][2]--;
            match[team2][0]--;
            simulate(gameIndex + 1);
            match[team1][2]++;
            match[team2][0]++;
        }
    }
}
