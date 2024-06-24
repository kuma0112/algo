package org.example.basic.array;

public class Array_02_Basic {
    public static void main(String[] args) {
        // 배열의 맨 앞부터 각 3자리씩 일정한 규칙이 있다.
        // 1번 * 2번 = 3번
        // 규칙에 위반되는 것들이 몇 개인지 출력
        int[] intArray = {3,2,6, 3,4,4, 1,4,2, 2,3,6, 1,3,5, 1,5,1, 1,1,1, 2,4,2, 2,2,4};
//        int index = 0;
//        for (int i = 0; i < intArray.length/3; i++) {
//            int a = intArray[(3 * i)];
//            int b = intArray[1+ (3*i)];
//            int c = intArray[2+ (3*i)];
//            if ((a * b) != c) {
//                index ++;
//            }
//        }
//        System.out.println(index);

        int intLength = intArray.length-2;
        int wrongCount = 0;
        for (int i = 0; i <intLength; i= i+3) {
            // i, i+1, i+2 세 항목을 따진다.
            if(intArray[i] * intArray[i+1] != intArray[i+2]){
                wrongCount ++;
            }
        }
        System.out.println(wrongCount);
    }
}
