package org.example.basic.subset;

// 전체 부분집합을 bit의 표현으로 단순화할 수 있다.
public class Subset_Param_BinaryCount {

    static int[] src = {1, 2, 3, 4, 5}; // 부분 집합의 개수는 2의 5승.
    //    static int subsetCnt = 2 * 2 * 2 * 2 * 2;
    static int subseCnt = 1 << src.length; // 32

    public static void main(String[] args) {
        for (int i = 0; i < subseCnt; i++) {
            // 0~31에 이르는 각각의 i는 부분집합의 한 경우를 의미
            // 00000 ~ 11111
            System.out.printf(i + "[%5s]", Integer.toBinaryString(i));
            System.out.println();

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < src.length; j++) {
                if ((i & 1 << j) != 0) {
                    sb.append(src[j]).append(" ");
                }
            }

            System.out.println(sb);
        }
    }
}
