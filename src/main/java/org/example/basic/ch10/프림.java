package org.example.basic.ch10;

// MST
// 정점 중심 - 인접 리스트, 인접 행렬 사용
// 시작점을 PQ에 넣고 시작. 이후 PQ에 담긴 정점 중 가장 비용이 적은 정점을 골라
// 갈 수 있는 새로운 정점을 다시 PQ에 넣는다. 이후 다시 빼고 넣고... 이 과정을 반복
// 비용이 가장 작은 정점 선택이 V개 선택

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 그래프 : 인접 행렬
// PriorityQueue'
// visit 배 (정점이 선택되었는지 확인하는 친구로 싸이클을 안 만들도록 도와준다)

// 프림은 크루스칼과 비교하고 다익스트라와 헷갈리지 않도록 한다,
public class 프림 {
    static int V, result;
    static int[][] matrix;
    static boolean[] visit;
    static PriorityQueue<Vertex> pqueue = new PriorityQueue<>((v1, v2) -> v1.c - v2.c);
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        matrix = new int[V][V];
        visit = new boolean[V];

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < V; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 프림
        // #1 : 관련 친구들이 큐에 다 들어가는 방법
//        pqueue.offer(new Vertex(0,0)); // 어떤 점에서 시작해도 똑같으니 0번에서 시작
//        int cnt = 0;

        // #2 ? 뭘 줄였다는 건지 알 수가 없네
        visit[0] = true; // 마치 큐에서 꺼낸 것처럼 true 처리
        for (int i = 0; i < V; i++) {
            if (matrix[0][i] == 0 || visit[i]) continue;
            pqueue.offer(new Vertex(i, matrix[0][i])); // 정점번호 i, 비용 vertex.v의 i
        }
        int cnt = 1;

        while (!pqueue.isEmpty()) {
            Vertex vertex = pqueue.poll();
            if (visit[vertex.v]) continue;
            // MST를 구성하는 정점이 선택됨
            visit[vertex.v] = true;
            result += vertex.c;
            cnt++;
            if (cnt == V) break;

            // 꺼낸 정점으로부터, 갈 수 있고 아직 방문하지 않은 정점이 있으면 pqueue에 추가
            for (int i = 0; i < V; i++) {
                if (matrix[vertex.v][i] == 0 || visit[i]) continue;
                pqueue.offer(new Vertex(i, matrix[vertex.v][i])); // 정점번호 i, 비용 vertex.v의 i
            }
        }
        System.out.println(result);
    }

    static class Vertex {
        int v, c;
        Vertex(int v, int c) {
            this.v = v;
            this.c = c;
        }
    }
}
/*
5
0 5 10 8 7
5 0 5 3 6
10 5 0 1 3
8 3 1 0 1
7 6 3 1 0
output==>10
 */
