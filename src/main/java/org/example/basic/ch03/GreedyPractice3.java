package org.example.basic.ch03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 55+5- 45+10 -5+5
public class GreedyPractice3 {
    static int result;
    static int sumOfPlus;
    static int sumOfMinus;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine(); // 55+5-45+10-5+5
        String[] str2 = str.split("-"); // 55+5, 45+10, 5+5

        String[] numbers = str2[0].split("\\+"); // 55, 5
        for(String number:numbers) {
            sumOfPlus += Integer.parseInt(number); // 60
        }

        for (int i = 1; i < str2.length; i++) {
            String[] numbers2 = str2[i].split("\\+"); // 45, 10, 5, 5
            for(String number:numbers2) {
                sumOfMinus += Integer.parseInt(number); // 55,  65
            }
        }

        result = sumOfPlus - sumOfMinus;
        System.out.println(result);
    }
}
