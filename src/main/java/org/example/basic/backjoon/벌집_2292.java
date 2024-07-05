package org.example.basic.backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 벌집_2292 {
    static int small;
    static int big;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int num = 1;
        int count = 1;

        small = 1;
        big = 1;

        while(true) {
            if (N >= small && N <= big) {
                System.out.println(count);
                break;
            }
            small = big+1;
            big = small + num * 6-1;
            num ++;
            count ++;
        }
    }
}
