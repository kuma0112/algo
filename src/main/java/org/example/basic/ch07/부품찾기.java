package org.example.basic.ch07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 부품찾기 {
    static int n, m;
    static int[] array;
    static int[] consumer;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine()); // 5
        array = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken()); // 8 3 7 9 2
        }
        Arrays.sort(array);

        m = Integer.parseInt(br.readLine()); // 3
        consumer = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            consumer[i] = Integer.parseInt(st.nextToken()); // 5 7 9
        }

        for (int i = 0; i < m; i++) {
            if (binarySearch(consumer[i], 0, n - 1)) {
                sb.append("yes ");
            } else {
                sb.append("no ");
            }
        }

        System.out.println(sb);
    }

    static boolean binarySearch(int target, int start, int end) {
        if (start > end) {
            return false;
        }
        int mid = (start + end) / 2;
        if (array[mid] == target) {
            return true;
        } else if (array[mid] > target) {
            return binarySearch(target, start, mid - 1);
        } else {
            return binarySearch(target, mid + 1, end);
        }
    }
}
