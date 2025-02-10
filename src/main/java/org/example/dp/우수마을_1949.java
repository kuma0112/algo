package org.example.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 우수마을_1949 {
    static int N;
    static int[] array;
    static List<List<Integer>> tree = new ArrayList<>();
    static boolean[] visited;
    static int[] dpInclude;
    static int[] dpExclude;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        array = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree.get(a).add(b);
            tree.get(b).add(a);
        }
        visited = new boolean[N+1];
        dpExclude = new int[N+1];
        dpInclude = new int[N + 1];

        dfs(1, -1);
        System.out.println(Math.max(dpInclude[1], dpExclude[1]));
    }

    static void dfs(int current, int parent) {
        visited[current] = true;
        dpInclude[current] = array[current]; // 현재 노드를 포함하는 경우 ---> dpInclude[i] = i번 마을의 주민 수,

        // 2이면 neighbor은 1, 3, 6
        for (int neighbor : tree.get(current)) {
            // 1, 3, 6 이 부모가 아니고 방문도 안 했다면,
            if (neighbor != parent && !visited[neighbor]) {
                dfs(neighbor, current);

                dpInclude[current] += dpExclude[neighbor]; // 4번 선택 + 5번 제외
                dpExclude[current] += Math.max(dpInclude[neighbor], dpExclude[neighbor]); // 4번 제외했을 때의 최대값 --> 5번을 선택하는 값, 5번을 제외하는 값
            }
        }
    }
}
