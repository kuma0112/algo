package org.example.basic.ch03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 일이될때까지_2 {
    static int result1;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 기존 풀이
        while (n > 1) {
            if (n % k == 0) {
                n = n / k;
                result++;
            } else {
                int target = (n / k) * k;
                result += (n-target);
                n=target;
            }
        }

        System.out.println(result);

    }
}
