package org.example.basic.ch07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 떡볶이떡자르기 {
    static int n,m, max;
    static int[] array;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 떡의 개수
        m = Integer.parseInt(st.nextToken()); // 적어도 이만큼 떡을 가지고 가고 싶다
        array = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken()); // 19 15 10 17
        }

        max = array[0];
        for (int i = 1; i < n; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        int result = findMax(array, m, 0, max);
        System.out.println(result);
    }

    static int findMax (int[] array, int target, int start, int end) {
        while (start <= end) {
            int mid = (start+end) / 2;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                int num = array[i] - mid;
                if (num > 0)
                    sum += num;
            }
            if (sum == target) return mid;
            if (sum > target) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return -1;
    }
}
