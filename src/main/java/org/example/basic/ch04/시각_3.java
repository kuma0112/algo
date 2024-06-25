package org.example.basic.ch04;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 시각_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int hour = Integer.parseInt(br.readLine());
        int minute = 60;
        int second = 60;
        int count = 0;

        for (int i = 0; i <= hour; i++) {
            if (i % 10 == 3 || i / 10 == 3) {
                count += second * minute;
                continue;
            }
            for (int j = 0; j < minute; j++) {
                if (j % 10 == 3 || j / 10 == 3) {
                    count += second;
                    continue;
                }
                for (int k = 0; k < second; k++) {
                    if (k % 10 == 3 || k / 10 == 3) {
                        count++;
                    }
                }
            }
        }

        System.out.println(count);

    }
}