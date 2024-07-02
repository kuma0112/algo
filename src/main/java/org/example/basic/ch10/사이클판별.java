package org.example.basic.ch10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 사이클판별 {
    static int v, e;
    static int[] parent; // 각 정점의 대표를 저장하는 배열
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        parent = new int[v + 1]; // 1번 정점부터 사용하기 위해 크기를 v+1로 설정

        makeSet();

        // cycle 발생하는 지 체크
        boolean cycle = false;
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (findSet(x) == findSet(y)) {
                System.out.println(x + ", " + y);
                cycle = true;
                break;
            } else {
                union(x, y);
            }
        }

        if (cycle) {
            System.out.println("사이클 발생");
        } else {
            System.out.println("사이클 발생 x");
        }
    }

    static void makeSet() {
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }
    }

    // 너네 팀 대표가 누구야? 메서드.
    static int findSet(int x) {
        if (parent[x] == x) return x; // 자신이 대표이면 반환
        return parent[x] = findSet(parent[x]); // 대표를 찾을 때까지 재귀 호출
    }

    // 두 정점 x와 y의 대표를 합치는 함수. 각자의 대표를 찾아서 더 작은 값으로 대표를 설정한다.
    static void union(int x, int y) {
        int px = findSet(x);
        int py = findSet(y);
        if (px < py) parent[py] = parent[px];
        else parent[px] = py;
    }
}
/*
3 3
1 2
1 3
2 3

// 2,6
// 사이클 발생
7 9
1 2
1 5
5 6
2 3
2 6
3 4
6 4
6 7
4 7


-- 2 6 맨 뒤로
// 6, 4
// 사이클 발생

7 9
1 2
1 5
5 6
2 3
3 4
6 4
6 7
4 7
2 6


-- 2 6 6 4 제거
// 4, 7
// 사이클 발생
7 7
1 2
1 5
5 6
2 3
3 4
6 7
4 7


-- 4 7 제거
7 6
1 2
1 5
5 6
2 3
3 4
6 7
*/
