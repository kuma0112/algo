package org.example.sort;

import java.io.*;

public class 수정렬하기2_2751 {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 퀵정렬
        quickSort(0, n-1);

        for (int i = 0; i < n; i++) {
            bw.write(arr[i] + "\n");
        }

        bw.flush();
        bw.close();
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
        int pivot = arr[left];
        int i = left;

        for (int j = left+1; j <= right; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(i, j);
            }
        }
        swap(left, i);
        return i;
    }

    static void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
