package org.example.basic.backjoon;

import java.util.Arrays;
import java.util.Scanner;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class 외판원순회_해설 {
    static int N, allMask, INF = 9999999;
    static int[][] W; // 도시의 인접행렬
    static int[][] memoi;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        allMask = ( 1 << N ) - 1; // 1 << 5 : 100000 : -1 : 011111
        W = new int[N][N];
        memoi = new int[N][allMask];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(tsp(0, 1)); // 0번도시부터 출발 : 00001
    }
    static int tsp(int idx, int mask) {
        // 기저조건
        // mask 가 모두 1이면 모든 도시를 방문(되돌아가는 것만 남은 상태)
        if( mask == allMask ) {
            if( W[idx][0] == 0 ) return INF;
            else return W[idx][0];
        }

        // 이미 최소비용이 계산되어 있는지
        if( memoi[idx][mask] != 0 ) return memoi[idx][mask];

        // 충분히 큰 값으로 초기 설정
        memoi[idx][mask] = INF;

        // 처음 idx 도시에서 mask 에 남은 도시 상황
        for (int i = 0; i < N; i++) {
            // idx 도시에서 i 도시로 갈 수 없거나, i 도시를 idx 도착 전 이미 방문한 도시
            if( W[idx][i] == 0 || ( mask & 1 << i ) != 0 ) continue;
            // mask 에 0 인 아직 방문하지 않은 도시들
            memoi[idx][mask] = Math.min(memoi[idx][mask], W[idx][i] + tsp(i, mask | 1 << i));
        }

        return memoi[idx][mask];
    }
}
// N이 주어진다. (2 ≤ N ≤ 16) => 단순 순열로 생각하면 N! == 16! == 약 20조
// BitMasking 과 Memoization 이용해야 풀린다.
// 생각 #1
//  외판원순회는 사이클이 있는 그래프 => 방문의 순서가 정해지면 어느 정점에서 방문을 시작해도 비용이 같다.
//     1---2
//    /   /
//   /   4
//  /   /
// 3---5
// 위 형태이면 1 -> 2 -> 4 -> 5 -> 3 의 비용은 3 -> 1 -> 2 -> 4 -> 5 의 비용과 같고 .....
//  => 조심 ! 이것이 특정 조합의 비용이 모두 같다는 의미 X
//  결과적으로 1번부터 시작해서 최소비용이 걸리는 경로를 찾는다. N! -> (N-1)! 로 줄인다.
// 생각 #2
//  현재까지 방문한 도시에서 어떤 도시가 방문이 가능하다.
// BitMasking <- N 이 최대 16이므로 int 로 표현 가능
// 0001 => 1번 도시 방문
// 1010 => 4,2번 도시 방문
// 1101 => 4,3,1번 도시 방문
// 생각 #3
// memoi 를 어떻게 구성할 것인가?
// 도시별-현재 방문도시 목록별 누적 비용
// memoi[i][j] = 현재 i번 도시에 있고, 거쳐온 도시들이 j로 표시될 때, 남은 도시들을 방문하는데 필요한 최소 비용
//            최초 정해지면 변하지 않는 게 아니라, 최소값으로 계속 갱신된다.
// 1,2,3,4,5,6,7 도시가 있을 때
// memoi[3][1100101] => 1,3,6,7 번 도시 방문 후 3번 도시 상태일 때 남은 도시 2,4,5 을 방문하는데 드는 최소 비용
// memoi[3][1100101] = 100 이라면, 3 전에 방문한 1,6,7 의 방문 순서
//     1->6->7 - 1->7->6 <1부터 시작>  두 경우와 상관없이 항상 동일하다.
//     이전에 방문한 비용을 계산하는 것이 아니라, 이후에 방문할 최소 비용을 계산해 놓기 때문
//     맨 처음 (1->6->7) 에 최소 비용을 구해 놓으면  이후 (1->7->6) 에는 재사용 가능
// memoi[3][1100101] 의 최소비용은 남은 2,4,5 를 각각 방문하는 과정에서 최소비용으로 갱신된다.
// memoi[3][1100101] 은 memoi[2][1100111], memoi[4][1101101], memoi[5][1110101] 각각의 최소비용을 재귀호출로 계산하고,
//   각각의 최소비용 + 3->(2|4|5) 각각으로 가는 비용을 더한 값 중 최소 비용으로 결정
// 위 3가지 중 memoi[2][1100111] 만 따져 보면
// memoi[2][1100111] 의 최소비용은 남은 4,5 를 각각 방문하는 과정에서 최소비용으로 갱신된다.
// memoi[2][1100111] 은 memoi[4][1101111], memoi[5][1110111] 각각의 최소비용이 결정되면.
//   각각의 최소비용 + 2->(4|5) 각각으로 가는 비용을 더한 값 중 최소 비용으로 결정
// 위 2가지 중 memoi[4][1101111] 만 따져 보면 마지막 남은 memoi[5][1111111] 의 비용 + 4->5 비용을 더한 값이 되고
// memoi[5][1111111] 은 5->1로 가는 비용이 return 된다. (5->1로 가지 못하면 INF)