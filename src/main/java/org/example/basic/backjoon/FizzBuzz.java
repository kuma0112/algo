package org.example.basic.backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FizzBuzz {
    static String[] array;
    static int answer;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        array = new String[3];
        for (int i = 0; i < 3; i++) {
            array[i] = br.readLine();
        }
        for(int i = 0; i < 3; i++) {
            if (!array[i].equals("Fizz") && !array[i].equals("Buzz") && !array[i].equals("FizzBuzz")) {
                if (i == 0) answer = Integer.parseInt(array[i]) + 3;
                else if (i == 1) answer = Integer.parseInt(array[i]) + 2;
                else answer = Integer.parseInt(array[i]) + 1;
            }
        }
        if (answer % 15 == 0) System.out.println("FizzBuzz");
        else if (answer % 5 == 0) System.out.println("Buzz");
        else if (answer % 3 == 0) System.out.println("Fizz");
        else System.out.println(answer);
    }
}
