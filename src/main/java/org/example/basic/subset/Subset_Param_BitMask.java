package org.example.basic.subset;

// select 배열 대신 bitmasking
// <<, &, |
public class Subset_Param_BitMask {
    static int[] src = {1, 2, 3, 4, 5};

    public static void main(String[] args) {
        subset(0, 0);
    }

    static void subset(int srcIdx, int mask) { // mask 는 boolean 배열 select를 대체한다.
        // 기저 조건
        if (srcIdx == src.length) {
            printSubset(mask);
            return;
        }

        // mask의 bit 표현 중, srcIdx 자리를 1로 변경.
        subset(srcIdx + 1, mask | 1 << srcIdx);
        subset(srcIdx + 1, mask);
    }

    static void printSubset(int mask) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < src.length; i++) {
            if ((mask & 1 << i)!= 0) {
                sb.append(src[i]).append(" ");
            }
        }

        System.out.println(sb);
    }
}
