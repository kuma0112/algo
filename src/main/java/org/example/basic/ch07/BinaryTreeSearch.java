package org.example.basic.ch07;

import java.util.ArrayDeque;
import java.util.Queue;

// 1차원 배열로 2진 트리 표현
/*
              1
        2          3
    4     5      6     7
 8   9 10  11 12  13 14  15
 */
// 1차원 배열로 이루어진 이진 트리를 bfs, dfs()로 탐색해 본다.
// 이진트리 구조에서 부모 -> 자식을 찾아갈 때, 왼쪽 자식은 부모*2, 오른쪽 자식은 부모*2 +1이 된다. 인덱스가.
// 자식이 부모를 찾으려면, /2한 몫을 챙기면 된다.
public class BinaryTreeSearch {
    static int[] tree = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        bfs(1);
        System.out.println(sb);

        sb.setLength(0); // 스트링빌더를 비우는 방법
        dfs(1);
        System.out.println(sb);
    }

    static void bfs(int idx) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(idx);

        while (!queue.isEmpty()) {
            int curIdx = queue.poll();
            sb.append(tree[curIdx]).append(" ");
            int leftIdx = curIdx * 2;
            int rightIdx = curIdx * 2 + 1;
            if (leftIdx < tree.length) queue.offer(leftIdx);
            if (rightIdx < tree.length) queue.offer(rightIdx);
        }
    }

    static void dfs(int idx) {
        sb.append(tree[idx]).append(" ");
        int leftIdx = 2 * idx;
        int rightIdx = 2 * idx + 1;
        if (leftIdx < tree.length) dfs(leftIdx);
        if (rightIdx < tree.length) dfs(rightIdx);
    }
}
