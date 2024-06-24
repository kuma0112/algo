package org.example.basic.star;

public class star2 {
    public static void main(String[] args) {
//        int middle = 4;
//
//        // 상단 부분
//        for (int i = 0; i < middle; i++) {
//            for (int j = 0; j < i; j++) {
//                System.out.print(" ");
//            }
//            for (int j = 0; j < 2 * (middle - i) - 1; j++) {
//                System.out.print("*");
//            }
//            System.out.println();
//        }
//
//        // 하단 부분
//        for (int i = middle - 2; i >= 0; i--) {
//            for (int j = 0; j < i; j++) {
//                System.out.print(" ");
//            }
//            for (int j = 0; j < 2 * (middle - i) - 1; j++) {
//                System.out.print("*");
//            }
//            System.out.println();
//        }
        // 반복문 + 출력 + 반전 시점
        // 반전 : 정확히 반인 곳에서 공백 기준으로 점점 증가? 점점 감소? 판단 -> 밑으로 가면
        // 옆으로 가면서 공백 출력 나머지 조건 (전체 7중 공백 빼 만큼) 출력

        int turnCnt = 7/2; // 3.5가 아니고 3으로 정수 처리

        int spaceCnt = 0;
        boolean spaceIncrease = true; // 공백문자 수 증가할건지 감소할 건지 판단하는 친구
        for (int i = 0; i < 7; i++) {
            // 1. 출력하지 않을 부분까지 따진다.
            for (int j = 0; j < 7; j++) {
                if (j < spaceCnt) {
                    System.out.print(" ");
                } else if (j < 7-spaceCnt){
                    System.out.print("*");
                }
            }

            //2. 출력할 부분까지만 따진다.
            for (int j = 0; j< 7 - spaceCnt; j ++) {
                if (j <spaceCnt) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }

            // 3. 앞 공백, 뒤 별 출력 순서가 명백하므로 for문을 분리하여 if조건 체크 제거
            for (int j = 0; j< spaceCnt; j ++) {
                System.out.print(" ");
            }
            for (int j = spaceCnt; j < 7- spaceCnt; j ++) {
                System.out.print("*");
            }


            System.out.println();
            // 행 별 출력이 완료 -> 공백 증가 감소 판단해야 함
            if (spaceIncrease) {
                spaceCnt ++;
            } else {
                spaceCnt --;
            }

            if (spaceCnt == turnCnt) {
                spaceIncrease = false;
            }
        }
        int n = 7;

        for (int i = n / 2; i > 0; i--) {
            System.out.print(" ".repeat(n / 2 - i));
            System.out.println("*".repeat(i * 2 + 1));
        }

        for (int i = 0; i < n / 2 + 1; i++) {
            System.out.print(" ".repeat(n / 2 - i));
            System.out.println("*".repeat(i * 2 + 1));
        }

    }
}
