package org.example.basic.backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 두 개 그룹으로 나누는 문제
// 선택된 그룹 A, 선택되지 않은 그룹 B
// 부분집한이 완성되면 모두 연결되어 있는지 확인 (인접행렬로 구성하여 확인할 것)
// 모두 연결되어 있다는 건 모두 방문했다는 뜻 = visit[] 배열이 모두 true이다.
// 이후 두 그룹의 인구수 차이를 min으로 계산한다.
public class 게리맨더링_해설 {
    static int N, min;
    static int[][] matrix; // 여기서는 j가 정점이 아니라 인덱스다!!!!
    static int[] people;
    static List<Integer>[] adj;
    static Queue<Integer> queue = new ArrayDeque<>();
    static boolean[] visited, select; // select는 부분집합용, visit는 bfs 연결구조 파악용
    static int minDifference = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        matrix = new int[N+1][N+1];
        select = new boolean[N+1];
        visited = new boolean[N+1];

        // 인구 수
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            matrix[i][0] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N ; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            for (int j = 1; j <= n ; j++) {
                int v= Integer.parseInt(br.readLine());
                matrix[i][j] = v;
            }
        }

        min = Integer.MAX_VALUE;

        subset(1);

        if (min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);
    }

    static void subset(int srcIdx) {
        if (srcIdx == N+1)  {
            check();
            return;
        }

        select[srcIdx] = true;
        subset(srcIdx+1);

        select[srcIdx] = false;
        subset(srcIdx+1);
    }

    static void check() {
        // A, B 따로 각각 모두 연결을 확인. bfs를 이용하여 visit 배열 완성
        Arrays.fill(visited, false);
        queue.clear();

        // select 배열이 true -> group A / false -> group B
        for (int i = 1; i <= N ; i++) {
            if (select[i]) {
                visited[i] = true;
                queue.offer(i);
                break;
            }
        }

        if (queue.size() == 0) return;

        while (!queue.isEmpty()) {
            int v= queue.poll();
            for (int i = 1; i <=N ; i++) {
                int adj = matrix[v][i];
                if (adj != 0 && !visited[adj] && select[adj]) {
                    visited[adj] = true;
                    queue.offer(adj);
                }
            }
        }

        // A, B 각각 visit[]를 갱신했지만 전체가 true 여야 모두 연결
        for (int i = 1; i <= N ; i++) {
            if (!visited[i]) return;
        }

        // 유효 검증 통과
        int sumA = 0;
        int sumB = 0;

        for (int i = 1; i <= N ; i++) {
            if (select[i]) sumA += matrix[i][0];
            else sumB += matrix[i][0];
        }
    }
}


