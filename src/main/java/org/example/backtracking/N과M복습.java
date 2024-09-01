package org.example.backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M복습 {
    static int N,M;
    static int[] array;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 1부터 N까지의 숫자 중에서 M개의 숫자를 고를 것이기 때문에,
        // M길이의 array를 만들고 숫자를 고를 때마다 배열에 넣는다.
        array = new int[M];
        // visited 배열로는 해당 숫자가 선택되었는지 체크할 것이며,
        // 1~N까지의 숫자이므로 편하게 0~N까지의 배열을 생성한다.
        visited = new boolean[N+1];

        // 백트래킹 문제는 보통 dfs로 해결한다. 파라미터로 무엇을 받을지가 중요.
        // int depth를 파라미터로 보통 받는데,뜻이 분명치 않음으로 본인이 알아들을 수 있는 말로 변경할 것.
        // int index, 가로로(?) 파고들어간다고 생각하면 length 정도도 괜찮을 듯
        dfs(0);
    }

    static void dfs(int length) {
        if (length == M) {
            for (int i = 0; i < M; i ++) {
                // 뒤에 띄어쓰기 주는 걸 잊지 말 것.
                System.out.println(array[i] + " ");
            }
            // 줄바꿈 하는 것도 잊지 말 것.
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i ++) {
            // 숫자 하나하나씩, 방문하지 않은 숫자라면 배열에 집어넣고 다음 차례로 건너간다.
            if (!visited[i]) {
                visited[i] = true;
                array[length] = i;
                dfs(length + 1);
                // 출력 후 해당 숫자에 다시 방문할 수 있도록 방문 체크를 철회한다.
                visited[i] = false;
            }
        }
    }
}
