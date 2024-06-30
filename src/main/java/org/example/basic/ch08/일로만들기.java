package org.example.basic.ch08;

import java.util.Scanner;

public class 일로만들기 {
    static int count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] memoi = new int[n];
        memoi[1] = 1;
        memoi[2] = 1;
        memoi(6);
        System.out.println(count);
    }

    static void memoi(int n) {
        while (true) {
            if (n==1) {
                count++;
                break;
            }
            if (n % 5 == 0) {
                count++;
                memoi(n/5);
                break;
            } else if (n % 3 == 0) {
                count++;
                memoi(n/3);
                break;
            } else if (n % 2 == 0) {
                count++;
                memoi(n/2);
                break;
            } else {
                count++;
                memoi(1);
                break;
            }
        }
    }
}
