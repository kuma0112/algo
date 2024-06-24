package org.example.basic.permitation;

import java.util.Arrays;

// 5개 수 중 3개의 수로 만들 수 있는 순열의 종류
public class Permutation_Basic {
    static int[] src = {1, 2, 3, 4, 5};
    static int[] tgt = new int[3];
    static boolean[] select = new boolean[src.length];

    public static void main(String[] args) {
        perm(0);
    }
    static int index = 1;
    static void perm(int tgtIdx) {

        for (int i = 0; i < src.length; i++) {
            // 기저조건
            if (tgtIdx == tgt.length) {
                System.out.println(Arrays.toString(tgt) + index);
                index ++;
                return;
            }
            if(select[i]) continue;
            tgt[tgtIdx]  = src[i];
            select[i] = true;
            perm(tgtIdx+1); // 다음 숫자 따져보기 -> 모든 숫자 트루됨 -> 원상복구
            select[i] = false;
        }
    }
}

// 현재 자리에 어떤 수를 채울 것인가는, src 전체 중 이전 자리를 채우지 않은 수를 선택.
// 따라서 이전 자리에 사용된 애들을 넣어 두는 select라는 배열이 존재해야.
// tgtIdx는 tgt의 몇 번째 인덱스인지를 가리킴