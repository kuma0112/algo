package org.example.basic;

import java.util.Arrays;

public class Mini {
    static int[] src = {6, 7, 8, 9, 10, 11, 12};
    static int[] tgt = new int[4];
    static boolean[] select = new boolean[src.length];
    public static void main(String[] args) {
//        perm(0);
//        comb(0,0);
        subset(0);
    }

    static void subset(int srcIdx) {
        if (srcIdx == src.length) {
            printSubset();
            return;
        }

        select[srcIdx] = true;
        subset(srcIdx+1);

        select[srcIdx] = false;
        subset(srcIdx+1);
    }

    static void printSubset() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <select.length; i++) {
            if (select[i]) {
                sb.append(src[i]).append(" ");
            }
        }
        System.out.println(sb);
    }

    static void comb(int srcIdx, int tgtInx) {
        if (tgtInx == tgt.length) {
            System.out.print(Arrays.toString(tgt));
            return;
        }

        if (srcIdx == src.length) {
            return;
        }

        tgt[tgtInx] = src[srcIdx];
        comb(srcIdx+1, tgtInx+1);
        comb(srcIdx+1, tgtInx);
    }

    static void perm(int tgtIdx) {
        if (tgtIdx == tgt.length) {
            System.out.print(Arrays.toString(tgt));
            return;
        }

        for (int i = 0; i < src.length; i++) {
            if(select[i]) {
                continue;
            }

            tgt[tgtIdx] = src[i];
            select[i] = true;
            perm(tgtIdx+1);
            select[i] = false;
        }
    }
}
