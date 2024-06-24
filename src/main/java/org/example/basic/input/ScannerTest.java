package org.example.basic.input;

import java.util.Arrays;
import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
//        // 1 2 3 4 5
//        {
//            Scanner sc = new Scanner(System.in);
//            int[] input = new int[5];
//            for (int i = 0; i < 5; i++) {
//                input[i] = sc.nextInt();
//            }
////            for (int i = 0; i < 5; i++) {
////                System.out.println(input[i]);
////            }
//            System.out.println(Arrays.toString(input));
//        }

//        // 1 A 3 B 5
//        {
//            Scanner sc = new Scanner(System.in);
//            char[] input = new char[5];
//
//            for (int i = 0; i<5; i++) {
//                input[i] = sc.next().charAt(0); // .next는 문자열로 받아서 "1"로 받음.
//            }
//            System.out.println(Arrays.toString(input));
//        }

//        // XYZQU
//        {
//            Scanner sc = new Scanner(System.in);
////            String line = sc.nextLine();
////            System.out.println(line);
//
////            char[] input = new char[5];
////            input = sc.nextLine().toCharArray(); // "XYZQU" -> 'X', 'Y' ...
//            char[] input = sc.nextLine().toCharArray();
//            System.out.println(Arrays.toString(input));
//
//        }
//
//        /*
//        6
//        1 2 3 4 5 1
//         */
//        {
//            Scanner sc = new Scanner(System.in);
//            int N = sc.nextInt();
//            int[] input = new int[N];
//
//            for (int i = 0; i < N; i++) {
//                input[i] = sc.nextInt();
//            }
//            System.out.println(Arrays.toString(input));
//        }

/*
5
XYZQU
 */
        {
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();
            sc.nextLine(); // 남아 있는 빈 개행문자 처리
            char[] input = sc.nextLine().toCharArray();

            System.out.println(Arrays.toString(input));
        }
    }
}
