package org.example.basic.backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class 팰린드롬수_1259 {
    static char[] array;
    static int length;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            array = br.readLine().toCharArray(); // '1' '2' '1'
            length = array.length;
            if (length == 1 && array[0] == '0') break;
            if (sees()) System.out.println("yes");
            else System.out.println("no");
        }

    }

    static boolean sees() {
        for (int i = 0; i < length - 1; i++) {
            if (array[i] != array[length - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}
