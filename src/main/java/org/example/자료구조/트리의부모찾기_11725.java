package org.example.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 트리의부모찾기_11725 {
    static int N;
    static List<List<Integer>> list;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for (int i = 0; i < N+1; i++) {
            list.add(new ArrayList<>());
        }
        parent = new int[N+1];

        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        int root = 1;
        findPanret(root);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void findPanret(int root) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int num : list.get(cur)) {
                if (parent[num] == 0) {
                    parent[num] = cur;
                    queue.add(num);
                }
            }
        }
    }
}
