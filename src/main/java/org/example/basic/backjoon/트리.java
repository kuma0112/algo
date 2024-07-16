package org.example.basic.backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 트리 {
    static int N, K;
    static List<List<Integer>> adjList;
    static boolean[] visited;

    static int root;
    static int leafCount;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        adjList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adjList.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] parents = new int[N];

        for (int i = 0; i < N; i++) {
            parents[i] = Integer.parseInt(st.nextToken());
            if (parents[i] == -1) {
                root = i;
            } else {
                adjList.get(parents[i]).add(i);
            }
        }

        K = Integer.parseInt(br.readLine());

        if (K == root) {
            System.out.println(0);
        } else {
            visited = new boolean[N];
            leafCount = 0;
            dfs(root);
            System.out.println(leafCount);
        }
    }

    static void dfs(int node) {
        visited[node] = true;
        // 틀린 부분 1 : 이 부분의 식을 너무 복잡하게 작성하다 길을 잃음.
        // adjList.hasNext() 같은 메서드를 찾으려 했지만... adjList.get(node).size()로 쉽게 해결이 가능했다.
        if (adjList.get(node).isEmpty() || (adjList.get(node).size() == 1 && adjList.get(node).get(0) == K)) {
            leafCount++;
            return;
        }

        for (int next : adjList.get(node)) {
            if (!visited[next] && next != K) {
                dfs(next);
            }
        }
    }
}
