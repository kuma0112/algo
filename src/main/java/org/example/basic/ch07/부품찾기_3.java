package org.example.basic.ch07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 부품찾기_3 {
    static int n, m;
    static int[] arr, targets;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine()); // 5
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); // 8 3 7 9 2
        }
        Arrays.sort(arr);

        m = Integer.parseInt(br.readLine()); // 3
        targets = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            targets[i] = Integer.parseInt(st.nextToken()); // 5 7 9
        }

        for (int i = 0; i < m; i++) {
            int result = Arrays.binarySearch(arr, targets[i]);
            if (result >= 0) {
                sb.append("yes ");
            } else {
                sb.append("no ");
            }
        }

        System.out.println(sb);
    }

}
