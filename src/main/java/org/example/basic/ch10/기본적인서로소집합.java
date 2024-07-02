package org.example.basic.ch10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 기본적인서로소집합 {
    static int v, e;
    static int[] parent; // 대표를 넣어 두는 배열
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        parent = new int[v + 1];

        // 우선 모든 점이 독립된 점(서로소 집합)이라고 가정한다. 즉, 각자가 자기 자신을 대표한다.
        // 각자가 자기 자신을 대표로 하는 배열을 만들어 주는 것이 makeSet() 메서드.
        makeSet();

        // 이제 입력을 받으면서 친구인지, 대표가 누구인지 확인한다.
        // 1 4가 입력으로 들어오면(이들은 친구!) parent[1] = 1, parent[4] = 4인 상태에서 더 작은 값을 대표로 설정한다.
        // parent[4] = 1이 되며, 이 과정을 반복하면 parent가 1인 친구들은 서로 같은 집합이 된다.
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            union(x, y);
        }

        // 인덱스
        for (int i = 1; i <= v ; i++) {
            System.out.println(i + " ");
        }
        System.out.println();

        // 부모 배열
        for (int i = 1; i <= v ; i++) {
            System.out.print(parent[i] + " ");
        }
        System.out.println();

        // 부모
        for (int i = 1; i <= v ; i++) {
            System.out.println(findSet(i) + " ");
        }
        System.out.println();
    }


    static void makeSet() {
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }
    }

    static int findSet(int x) { // 정점의 부모를 찾는 기능 수행. x의 부모값을 리턴함.
        if (parent[x] == x) return x; // 자기 자신을 인덱스로 한 배열에서 자기만 가지고 있으면 자기가 대표
        return findSet(parent[x]);
    }

    static void union(int x, int y) { // 두 부모의 수 중 작은 수를 부모로
        // 이걸 하려면 어떤 정점의 부모가 누구인지 알아야 함.
        int px = findSet(x);
        int py = findSet(y);
        if (px < py) parent[py] = parent[px];
        else parent[px] = py; // 이미 같은 집에 대한 처리 포함. 
    }
}

/*
정점 6개, 간선 4개, 밑에는 서로 연결된 선들
6 4
1 4
2 3
2 4
5 6
 */