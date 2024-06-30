package org.example.basic.binarySearch;

import java.util.Arrays;

public class ArrayTest {
    public static void main(String[] args) {
        //인덱스       0,1,2,3,4
        int[] arr = {1,3,5,7,9};
        System.out.println(Arrays.binarySearch(arr,1)); // 0
        System.out.println(Arrays.binarySearch(arr,2)); // -2
        // 2는 1과 3사이에 있어야 함. 즉 인덱스 1이어야 함.
        // 1을 음수로 만든 후, 거기에 -1을 해 주기. -> -2
        System.out.println(Arrays.binarySearch(arr,0)); // -1
        // 0은 인덱스 0번에 있어야 하므로, 0에서 -1.
    }
}
