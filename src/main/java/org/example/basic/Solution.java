package org.example.basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int M;
    static double sum;
    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int temp = 0;
        for (int i = 0; i < N; i++) {
            M = Math.max(temp, array[i]);
            temp = M;
        }

        double[] doubleArray = new double[N];
        for (int i = 0; i < N; i++) {
            doubleArray[i] = ((double) array[i] / M) * 100;
        }

        for (int i = 0; i < N; i++) {
            sum += doubleArray[i];
        }

        System.out.println(sum / N);
    }
}
