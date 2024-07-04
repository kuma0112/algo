package org.example.basic.backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 치킨배달_Perm_NP_Memoi {
    static int N, M, houseSize, srcSize, min;
    static List<int[]> house, src;
    static int[] index; // np
    static int[][] memoi; // 미리 계산된 집 - 치킨집 거리

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        house = new ArrayList<>(); // 집
        src = new ArrayList<>(); // 치킨 집

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int a = Integer.parseInt(st.nextToken());
                if( a == 1 ) house.add(new int[] {i, j});
                else if( a == 2 ) src.add(new int[] {i, j});
            }
        }

        // 풀이
        min = Integer.MAX_VALUE;
        houseSize = house.size();
        srcSize = src.size();

        memoi = new int[houseSize][srcSize]; // 집 x 치킨 집

        for (int i = 0; i < houseSize; i++) { // 각각의 집에 대해서
            int[] h = house.get(i);
            for (int j = 0; j < srcSize; j++) { //치킨집
                int[] c = src.get(j);
                memoi[i][j] = Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]);
            }
        }

        // NP
        index = new int[srcSize]; // 치킨 집의 수만큼 배열을 생성 전부 00000...00
        // M개 만큼 뽑고 싶다.(조합)
        for (int i = srcSize - M; i < srcSize; i++) { // 0000011111 (M:5)
            index[i] = 1;
        }
        // index 배열은 최소를 의미 asc 로 정렬된 상태

        while(true) {

            // 조합 1개 완성 상태
            int sum = 0; // 치킨 거리를 모두 더한 값
            for (int i = 0; i < houseSize; i++) { // 각각의 집에 대해서
                int minDist = Integer.MAX_VALUE;

                for (int j = 0; j < srcSize; j++) { // index 배열
                    if( index[j] == 1) {
                        minDist = Math.min(minDist, memoi[i][j]);
                    }
                }

                sum += minDist;
            }

            min = Math.min(min, sum);

            if( ! np() ) break;

        }
        System.out.println(min);
    }
    static boolean np() {
        int i, j, k;
        i = j = k = srcSize - 1;
        while( i > 0 && index[i-1] >= index[i] ) --i;
        if( i == 0 ) return false;
        while( index[i-1] >= index[j]) --j;
        swap( index, i-1, j );
        while( i < k ) {
            swap(index, i++, k--);
        }
        return true;

    }
    // 일반화된 메소드(index 가 아닌 array)
    static void swap(int array[], int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
