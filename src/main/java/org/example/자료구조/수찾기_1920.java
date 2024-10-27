package org.example.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수찾기_1920 {
    static int N, M;
    static int[] array, target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        array = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);

        M = Integer.parseInt(br.readLine());
        target = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < target.length; i++) {
            if (binarySearch(array, target[i]) == -1) {
                System.out.println("0");
            } else System.out.println("1");
        }
    }

    public static int binarySearch(int[] array, int key) {
        int low = 0;
        int high = array.length -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (key <array[mid]) {
                high = mid - 1;
            } else if (key > array[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
