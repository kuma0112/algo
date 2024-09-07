package org.example.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 소문난칠공주 {
    static char[][] map = new char[5][5];
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int[] combY = new int[25];
    static int[] combX = new int[25];
    static int countOfanswer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map[i] = st.nextToken().toCharArray();
        }

        for (int i = 0; i < 25; i++) {
            combY[i] = i/5;
            combX[i] = i%5;
        }

        comb(new int[7], 0, 0, 7);
        System.out.println(countOfanswer);
    }

    static void comb(int[] answer, int index, int length, int left){
        if (left == 0) {
            bfs(answer);
            return;
        }

        if (length==25) return;

        answer[index] = length;
        comb(answer, index+1, length+1, left-1);
        comb(answer, index, length+1, left);
    }

    public static void bfs(int[] answer) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[7];

        visited[0] = true;
        queue.add(answer[0]);
        int count = 1;
        int Scount = 0;

        if (map[combY[answer[0]]][combX[answer[0]]] == 'S') Scount++;


        while(!queue.isEmpty()){
            int current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = combY[current] + dy[i];
                int nx = combX[current] + dx[i];

                for (int j = 0; j < 7; j++) {
                    if (!visited[j] && ny == combY[answer[j]] && nx == combX[answer[j]]) {
                        visited[j] = true;
                        queue.add(answer[j]);
                        count++;
                        if (map[combY[answer[j]]][combX[answer[j]]] == 'S') Scount++;
                    }
                }
            }
        }
        if (count == 7 && Scount >= 4) countOfanswer++;
    }
}
