package org.example.basic.star;

import java.util.HashMap;
import java.util.Map;

public class star1 {
    /*
    *****
     ****
      ***
       **
        *

     */

    public static void main(String[] args) {
//        int n = 5;
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < i; j++) {
//                System.out.print(" ");
//            }
//            for (int k = n; k > i; k--) {
//                System.out.print("*");
//            }
//            System.out.println();
//        }
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 5; j++) {
//                if (j < i) {
//                    System.out.print(" ");
//                } else {
//                    System.out.print("*");
//                }
//            }
//            System.out.println();
//        }

        for (int i = 5; i > 0; i--) {
            System.out.printf("%5s\n", "*".repeat(i));
        }
    }
}
