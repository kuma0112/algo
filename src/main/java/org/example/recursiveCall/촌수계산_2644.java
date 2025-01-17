package org.example.recursiveCall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 촌수계산_2644 {
    static int N, M;
    static int targetA, targetB;
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        targetA = Integer.parseInt(st.nextToken());
        targetB = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            list.get(parent).add(child);
            list.get(child).add(parent);
        }

        dfs(targetA, 0);
        System.out.println(result);
    }

    static void dfs(int num, int distance) {
        if (num == targetB) {
            result = distance;
            return;
        }

        visited[num] = true;

        for (int neighbor : list.get(num)) {
            if (!visited[neighbor]) {
                dfs(neighbor, distance + 1);
            }
        }
    }
}
