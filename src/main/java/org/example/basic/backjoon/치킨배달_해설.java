package org.example.basic.backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 치킨배달_해설 {
    static int N, M, houseSize, srcSize, min;
    static List<int[]> house, src, tgt;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        house = new ArrayList<>(); // 집
        src = new ArrayList<>(); // 치킨집
        tgt = new ArrayList<>(); // 선택된 치킨집

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int a = Integer.parseInt(st.nextToken());
                if ( a == 1 ) house.add(new int[] {i, j});
                else if (a == 2) src.add(new int[] {i, j});
            }
        }

        // 풀이
        min = Integer.MAX_VALUE;

        houseSize = house.size();
        srcSize = src.size();

        comb(0, 0);

        System.out.println(min);
    }

    static void comb(int srcIdx, int tgtIdx) {
        if (tgtIdx == M) {
            // M개의 치킨집을 뽑은 상태. tgt에 모두 들어가 있음
            // 마을 전체의 치킨거리 중 최소를 찾아내야 함
            // 모든 집에 대해서 가장 가까운 치킨 거리를 계산 후 더한다. 그 치킨거리 합산의 최소값
            int sum = 0;
            for (int i = 0; i < houseSize; i++) {
                int minDist = Integer.MAX_VALUE;

                int[] h = house.get(i); // 집 하나

                for (int j = 0; j < tgt.size(); j++) {
                    int[] c = tgt.get(j); // 치킨집 하나
                    minDist = Math.min(minDist, Math.abs(h[0]- c[0]) + Math.abs(h[1] - c[1]));
                }
                sum+= minDist;
            }
            min = Math.min(min, sum);
            return;
        }

        if (srcIdx == srcSize) return;

        tgt.add(src.get(srcIdx));
        comb(srcIdx+1, tgtIdx+1);

        tgt.remove(src.get(srcIdx));
        comb(srcIdx+1, tgtIdx);
    }
}
