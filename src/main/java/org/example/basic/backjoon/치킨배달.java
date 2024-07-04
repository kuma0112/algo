package org.example.basic.backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 치킨배달 {
    static int N, M;
    static int[][] matrix;
    static List<Node> house;
    static List<Node> chicken;
    static List<Node> select;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix = new int[N+1][N+1];
        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N+1; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
                if (matrix[i][j] == 1) {
                    house.add(new Node(i, j));
                }
                if (matrix[i][j] == 2) {
                    chicken.add(new Node(i,j));
                }
            }
        }

        comb(0, 0);
    }

    static void comb(int srcIdx, int tgtIdx) {
        if (tgtIdx == M) {
            // 할일 수행
            System.out.println();
            return;
        }

        if (srcIdx == chicken.size()) {
            return;
        }
        comb(srcIdx+1, tgtIdx+1);
        comb(srcIdx+1, tgtIdx);

    }


    static class Node {
        int r, c;
        Node (int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
