package org.example.basic.backjoon;

import org.example.basic.ch10.크루스칼;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 게리맨더링_17471 {
    static int N;
    static int[] people;
    static List<Integer>[] adj;
    static boolean[] visited;
    static int minDifference = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        people = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        adj = new List[N + 1];

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            for (int j = 0; j < a; j++) {
                int b = Integer.parseInt(st.nextToken());
                adj[i].add(b);
                adj[b].add(i);
            }
        }

        // 두 그룹으로 가른다.
        for (int i = 1; i < Math.pow(2, N); i++) {
            // 각 그룹을 두 개로 나누는 부분집합을 만든다.
            List<Integer> groupA = new ArrayList<>();
            List<Integer> groupB = new ArrayList<>();

            for (int j = 0; j < N; j++) { // 0~5
                if ((i & (1 << j)) > 0) { // 선택되면 group A에 넣고
                    groupA.add(j + 1);
                } else { // 아니면 group B에 넣는다.
                    groupB.add(j + 1);
                }
            }

            if (!groupA.isEmpty() && !groupB.isEmpty() && isConnected(groupA) && isConnected(groupB)) { // 그룹이 비어 있지 않고 Group A와 B 안에서 서로 연결이 잘 되어 있으면
                int diff = Math.abs(sum(groupA) - sum(groupB)); // 인구수를 합해서 차이를 확인하고
                minDifference = Math.min(minDifference, diff); // 최소값을 갱신하여
            }
        }

        System.out.println(minDifference == Integer.MAX_VALUE ? -1 : minDifference); // 출력한다
    }

    static boolean isConnected(List<Integer> group) { // 만들어진 부분 집합을 파라미터로 받는다
        visited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(group.get(0)); // 큐에 첫 번째 구역을 넣고 방문처리한다.
        visited[group.get(0)] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : adj[current]) { // 현재 구역의 이웃들을 꺼내서
                if (group.contains(neighbor) && !visited[neighbor]) { // 그룹에 이웃이 있는지(연결된 구역인지) 확인한다.
                    visited[neighbor] = true;
                    queue.add(neighbor);
                    count++;
                }
            }
        }

        return count == group.size(); // 카운트가 그룹 사이즈와 일치하는지 확인한다.
    }

    static int sum(List<Integer> group) { // 부분집합에서 하나씩 꺼내어 인구수를 확인한 다음 합하는 로직
        int total = 0;
        for (int node : group) {
            total += people[node];
        }
        return total;
    }
}


