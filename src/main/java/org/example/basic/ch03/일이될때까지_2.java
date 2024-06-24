package org.example.basic.ch03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.StringTokenizer;

public class 일이될때까지 {
    static int result1;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

//        // 기존 풀이
//        long startTime = System.nanoTime();
//        while (n > 1) {
//            if (n % k == 0) {
//                n = n / k;
//            } else {
//                n -= 1;
//            }
//            result1 ++;
//        }
//        long endTime = System.nanoTime();
//        System.out.println(result1);
//        System.out.println(" result 1 : " + (endTime - startTime));
//
        // 수정 풀이
        long startTime = System.nanoTime();
        while ( n >= k) {
            int target = (n / k) * k;
            result += (n-target);
            n = target;

            n /= k;
            result += 1;
        }
        result += (n-1);
        long endTime = System.nanoTime();

        System.out.println(result);
        System.out.println(" result : " + (endTime - startTime));
    }
}
