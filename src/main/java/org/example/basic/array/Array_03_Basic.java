package org.example.basic.array;

public class Array_03_Basic {
    public static void main(String[] args) {
        String str = "XYZEBFFGQOVVPWGFFCEAYX";
//        // 좌우 비대칭 문자가 있으면 출력.
//        // 전체 비대칭 문자가 몇 개인지 출력.
//        int length = str.length();
//        int middle = length/2 ;
//        int wrongCount = 0;
//        for (int i = 0; i < middle; i++) {
//            if (str.charAt(i) != str.charAt(length-i-1)) {
//                System.out.println(str.charAt(i));
//                System.out.println(str.charAt(length-i-1));
//                wrongCount ++;
//            }
//        }
//        System.out.println(wrongCount);

        char[] charArray = str.toCharArray();
        int wrongCount = 0;
        int center = charArray.length/2;
        for (int left = 0, right = charArray.length-1 ; left < center; left++, right--) {
            if( charArray[left] != charArray[right] ) {
                System.out.println(charArray[left] + " " + charArray[right]);
                wrongCount++;
            }
        }
        System.out.println(wrongCount);
    }
}
