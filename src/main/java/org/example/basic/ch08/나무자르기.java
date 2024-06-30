package org.example.basic.ch08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 나무자르기 {
    static int n,m;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        solve(arr, m, 0, 30000);
    }

    static void solve(int[] arr, int target, int start, int end) {
        int result = 0;
        while(start<= end) {
            int mid = (start + end) / 2;
            int num = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] - mid >= 0) {
                    num += arr[i] - mid;
                }
            }
            if (num == target) {
                System.out.println(mid);
                break;
            }
            if (num < target)
                end = mid-1;
            if (num > target)
                start = mid +1;
        }
    }
}
