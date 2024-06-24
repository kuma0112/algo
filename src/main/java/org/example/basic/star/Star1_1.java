package org.example.basic.star;

public class Star1_1 {
    public static void main(String[] args) {
        int length = 7;
        int center = 3;

        for (int i = 0; i < center; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < length-2*i ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = 0; i < center+1 ; i++) {
            for (int j = 0; j < center - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2* i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
