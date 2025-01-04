package org.example.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수정렬하기2_2751 {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 선택정렬
        selectionSort(arr);

        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }

    static void selectionSort(int[] arr) {
        int min;
        int minIdx;
        for (int i = 0; i < arr.length; i++) {
            min = arr[i];
            minIdx = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minIdx = j;
                }
            }
            swap(i, minIdx);
        }
    }

    static void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
