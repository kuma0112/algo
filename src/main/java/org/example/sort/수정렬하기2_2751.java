package org.example.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수정렬하기2_2751 {
    static int[] arr, temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        temp = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 병합정렬
        mergeSort(0, n-1);

        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }

    static void mergeSort(int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;

        mergeSort(left, mid);
        mergeSort(mid + 1, right);
        merge(left, mid, right);
    }

    static void merge(int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                k++;
                i++;
            } else {
                temp[k] = arr[j];
                k++;
                j++;
            }
        }

        while (i <= mid) {
            temp[k] = arr[i];
            k++;
            i++;
        }

        while (j <= right) {
            temp[k] = arr[j];
            k++;
            j++;
        }

        for (int l = 0; l < j; l++) {
            arr[l] = temp[l];
        }
    }
}
