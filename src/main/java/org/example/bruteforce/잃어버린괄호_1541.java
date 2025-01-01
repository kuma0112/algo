package org.example.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 잃어버린괄호_1541 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        // 1. -를 기준으로 식을 분리하기
        String[] splitByMinus = s.split("-");
        // 만약 5+7, 12+3, 1+2라고 나왔다면
        // 5+7 진행하고 first에 넣어두기
        // 나머지 다 더하고 second에 넣어두기
        // first-second

        int first = getSum(splitByMinus[0]);
        int second = 0;
        for(int i = 1; i < splitByMinus.length; i++) {
            second += getSum(splitByMinus[i]);
        }
        int result = first - second;
        System.out.println(result);
    }

    static int getSum(String s) {
        String[] splitByPlus = s.split("\\+");
        int sum = 0;
        for (String num: splitByPlus) {
            sum += Integer.parseInt(num);
        }

        return sum;
    }
}