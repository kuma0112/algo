package org.example.basic.combination;

import java.util.Arrays;

public class Combination_Basic {
    static int[] src = {1, 2, 3, 4, 5};
    static int[] tgt = new int[3];

    // 조합의 경우엔 얘가 필요가 없음!
//    static boolean[] select = new boolean[src.length];

    public static void main(String[] args) {
        comb(0,0);
    }

    static void comb(int srcIdx, int tgtIdx) {
        // 기저조건
        if (tgtIdx == tgt.length) {
            // tgt 배열이 다 채워졌을 때, 즉 3개의 숫자가 모두 선택되었을 때 함수 종료
            System.out.println(Arrays.toString(tgt));
            return;
        }

        // 더 이상 선택할 숫자가 없을 때 함수 종료
        if (srcIdx == src.length) {
            return;
        }
        tgt[tgtIdx] = src[srcIdx]; // tgtIdx 자리에 srcIdx의 수를 채운다. 선택1
        comb(srcIdx + 1, tgtIdx + 1); // 선택1을 받아들이고 다음 자리를 채우러간다.
        comb(srcIdx + 1, tgtIdx); // 선택1을 무시하고 srcIdx는 증가시켜서 다음 수를 고려하되, tgtIdx는 그대로 현재 자리를 유지한다.
    }
}

// src의 맨 앞에서부터 tgt의 각 자리를 순차적으로 고려하며 채운다.