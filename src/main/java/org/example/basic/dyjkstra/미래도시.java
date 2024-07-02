package org.example.basic.dyjkstra;

// 1번 -> x번 회사
// 중간에 k 회사를 방문할 예정. 1 -> k -> x
// x회사 까지 가는 최단 경로 문제
// 회사별 이동 시간(비용)은 모두 1. -> bfs로도 풀이 가능!
// 그러나 모든 정점에서 다른 모든 정점에서 가는 최단 경로 알고리즘인 플로이드 워셜 알고리즘을 적용해보자
// 플로이드 워셜은 3중 for문으로, O(N^3)이다. N이 500 미만일 때만 적용 가능

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 자료구조는 인접행렬 matrix
// matrix는 최초 입력 테케로 초기화가 된 후, 3중 for문에 의해 최소 비용으로 갱신됨.
public class 미래도시 {
//    static final int INF = Integer.MAX_VALUE; // 이렇게 하면 overflow 발생
    static final int INF = 100*100;
    static int n, m, x, k;
    static int[][] matrix;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 도시(정점)의 수
        m = Integer.parseInt(st.nextToken()); // 도로(간선)의 수

        matrix = new int[n+1][n+1];

        // matrix를 모두 INF로 초기화
        for (int i = 1; i <= n; i++) {
            Arrays.fill(matrix[i], INF); // matrix는 2차원 배열, 그 한줄한줄을 INF로 채움
        }

        for (int i = 1; i < n ; i++) {
            for (int j = 1; j <= n ; j++) {
                if (i == j) {
                    matrix[i][j] = 0;
                } // 위에 초기화 for문은 여기서 else로 처리 가능!
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            matrix[a][b] = 1;
            matrix[b][a] = 1;
        }

        // x, k
        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int k = 1; k <= n; k++) { // 경유지
            for (int i = 1; i <= n ; i++) { // 행
                for (int j = 1; j <= n ; j++) { // 열
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k]+ matrix[k][j]);
                }
            }
        }

        int distance = matrix[1][k] + matrix[k][x];

        if( distance >= INF ) System.out.println(-1);
        else System.out.println(distance);

        System.out.println(Arrays.deepToString(matrix).replace("], ", "],\n"));
    }
}

/*
5 7
1 2
1 3
1 4
2 4
3 4
3 5
4 5
4 5

3
 */