package org.example.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 영식이의손가락_1614 {
    static long M, N, count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        M = Integer.parseInt(br.readLine()); // 2
        N = Integer.parseInt(br.readLine()); // 3
        if(M == 1) {
            count = (long)(N*8);
        }else if(M == 2) {
            count = (long)(1+(N/2)*8+(N%2)*6);
        }else if(M == 3) {
            count = (long)(2+(N/2)*8+(N%2)*4);
        }else if(M == 4) {
            count = (long)(3+(N/2)*8+(N%2)*2);
        }else {
            count = (long)(4 + N*8);
        }
        System.out.println(count);
    }
}
