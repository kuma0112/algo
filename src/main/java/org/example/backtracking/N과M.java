package org.example.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M {
    static int N, M;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // M 길이의 숫자를 만들 것이기 때문에, 숫자를 고르면 arr에 넣어서 보관한다.
        arr = new int[M];
        visited = new boolean[N + 1];

        dfs(0);
    }

    static void dfs(int depth) {
        if (depth == M) {
            for (int i = 0; i <M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i; // 해당 자리에 숫자를 집어넣는다.
                dfs(depth+1); // 다음 자리로 이동한다.
                visited[i] = false; // 백트래킹을 위해 방문기록을 되돌린다.
            }
        }
    }
}
