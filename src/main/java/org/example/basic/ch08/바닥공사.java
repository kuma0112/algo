package org.example.basic.ch08;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 바닥공사 {
    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] memoi = new long[n+1];

        memoi[1] = 1;
        memoi[2] = 3;

        for (int i = 3; i <= n; i++) {
            memoi[i] = (2 * memoi[i-2] + memoi[i-1]) % 796796;
            System.out.println(memoi[i]);
        }
    }
}
