package org.example.backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M2복습 {
    static int N, M;
    static int[] array;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        array = new int[M];

        // 파라미터가 두 개로 늘어났다.
        // 첫 번째는 int start. 맨 앞에 ㅇ는 숫자를 1로 두고 시작한다.
        // 두 번째는 length. M길이에 도달하면 출력한다.
        dfs(1, 0);
    }

    static void dfs(int start, int length) {
        if (length == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
            return;
        }

        // 한 번이라도 나온 숫자는 다시 나와선 안 되기 때문에
        // start부터 n까지의 숫자만 탐색하여
        // start에 들어갔던 수는 다시 배열에 들어가는 것을 막는다.
        for (int i = start; i <= N ; i++) {
            array[length] = i;
            dfs(i + 1, length + 1);
        }
    }
}
