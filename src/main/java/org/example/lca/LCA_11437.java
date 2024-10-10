package org.example.lca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class LCA_11437 {
    static int N;
    static ArrayList<Integer>[] tree;
    static int[] parent, depth;
    static int[][] map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N + 1]; // 1부터 N까지 입력 받으려고
        parent = new int[N + 1];
        depth = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N ; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        // dfs를 통해서 각 노드의 깊이와 부모를 찾는다.
        // 1이 루트 노트이며 깊이가 0이기 때문에 여기서부터 시작한다.
        dfs(1,0);

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            sb.append(LCA(node1, node2)).append("\n");
        }

        System.out.println(sb.toString());
    }

    static void dfs(int currentNode, int depthOfNode) {
        visited[currentNode] = true;
        depth[currentNode] = depthOfNode;

        // 현재 node에 연결된 node들을 돌면서, 부모를 지정한다.
        for(int next: tree[currentNode]){
            if (!visited[next]){
                parent[next] = currentNode;
                dfs(next, depthOfNode+1);
            }
        }
    }

    static int LCA(int node1, int node2) {
        // 만약 node1의 depth가 더 깊다면, node1의 depth를 끌어올려서 node2에 맞춘다.
        while(depth[node1] > depth[node2]) {
            node1 = parent[node1];
        }
        while(depth[node2] > depth[node1]) {
            node2 = parent[node2];
        }

        // node1과 node2가 같아졌다는 건, 부모를 찾았다는 뜻!
        while(node1 != node2) {
            node1 = parent[node1];
            node2 = parent[node2];
        }

        return node1;
    }
}
