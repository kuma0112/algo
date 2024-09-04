package org.example.backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 로또 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            if (k==0) break;

            int[] array = new int[k];
            for (int i = 0; i < k; i++) {
                array[i] = Integer.parseInt(st.nextToken());
            }

            dfs(array, new int[6], 0, 0);
            System.out.println();
        }
    }

    static void dfs(int[] numbers, int[] result, int start, int length) {
        if (length == 6) {
            for (int i = 0; i < 6; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = start; i<numbers.length; i++) {
            result[length] = numbers[i];
            dfs(numbers, result, i+1, length+1);
        }
    }
}
