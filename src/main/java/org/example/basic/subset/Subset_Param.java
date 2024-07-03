package org.example.basic.subset;

// select 배열을 파라미터화!
// 이렇게 하면 뭐가 다르지? 아무튼 이것 때문에 타임 못 맞출 수 있으니 비트 마스킹 사용
public class Subset_Param {
    static int[] src = {1, 2, 3, 4, 5};

    public static void main(String[] args) {
        boolean[] select = new boolean[src.length];
        subset(0, select);
    }

    static void subset(int srcIdx, boolean[] select) {
        // 기저 조건
        if (srcIdx == src.length) {
            printSubset(select);
            return;
        }

        // srcIdx에 대해 선택 비선택 이어나가기
        select[srcIdx] = true;
        subset(srcIdx + 1, select);

        select[srcIdx] = false;
        subset(srcIdx + 1, select);
    }

    static void printSubset(boolean[] select) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < select.length; i++) {
            if (select[i]) {
                sb.append(src[i]).append(" ");
            }
        }

        System.out.println(sb);
    }
}
