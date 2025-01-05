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

        // 퀵정렬
        quickSort(0, n-1);

        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }

    static void quickSort(int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = partition(left, right);

        quickSort(left, pivot-1);
        quickSort(pivot+1, right);
    }

    static int partition(int left, int right) {
        int pivot = arr[right];
        int i = left -1; // 피벗보다 작은 요소를 위한 가상 인덱스?

        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(i, j);
            }
        }
        swap(i+1, right);
        return i+1;
    }

    static void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
