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

        // 삽입정렬
        insertionSort(arr);

        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }

    static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int num = arr[i];
            int j = i-1;

            while(j >= 0 && arr[j] > num) {
                arr[j+1] = arr[j]; // 오른쪽으로 한칸 이동
                j--;
            }
            // 만약 arr[j]가 num보다 크지 않으면
            // 바로 그 숫자 오른쪽, 즉 arr[j+1]에 num을 삽입
            arr[j+1] = num;
        }
    }

}
