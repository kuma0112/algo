package org.example.basic.ch07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 떡볶이떡자르기_2 {
    static int n,m, result;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 떡의 개수
        m = Integer.parseInt(st.nextToken()); // 적어도 이만큼 떡을 가지고 가고 싶다
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); // 19 15 10 17
        }

        int start = 0;
        int end = 1_000_000_000; // 문제에서 제시된 높이에 대한 범위 중 최대값 (실제 배열에 든 가장 긴 떡 길이와는 무관)

        while(start <= end) {
            long total = 0; // 자르고 남는 떡의 총합. m을 만족시켜야 한다.

            int  mid = (start + end) /2;
            for (int i = 0; i < n; i++) {
                if (arr[i] > mid){
                    total += arr[i] - mid;
                }
            }
            if (total < m) {
                end = mid-1;
            } else {
                result = mid;
                start = mid +1;
            }
        }
        System.out.println(result);
    }

}
