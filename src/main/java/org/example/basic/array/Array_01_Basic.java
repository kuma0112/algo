package org.example.basic.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Array_01_Basic {
    public static void main(String[] args) {
        // "abbcccddddeeeeeffffggghhiabbcccddddeeeeeffffggghhi"
        // 위 문자열 줄 각 알파벳 문자의 사용 횟수 (빈도수)
        // a~z까지 모든 알파벳의 사용 횟수를 출력하세요.

//        String input = "abbcccddddeeeeeffffggghhiabbcccddddeeeeeffffggghhi";
//        Map<Character, Integer> hashMap = new HashMap<>();
//        int index = 0;
//        for (int i = 0; i<input.length(); i++) {
//            char key = input.charAt(i);
//            hashMap.put(key, hashMap.getOrDefault(key, 0) + 1);
//        }
//        for (char c = 'a'; c <= 'z'; c++) {
//            if (hashMap.containsKey(c)) {
//                System.out.println(c + ": " + hashMap.get(c));
//            } else {
//                System.out.println(c + ": 0");
//            }
//        }

//        int[] array = new int[26];
//
//        for (int i = 0; i < input.length(); i++) {
//            char ch = input.charAt(i);
//            array[ch-'a']++;
//        }
//
//        for (int i = 0; i < array.length; i++) {
//            char ch = (char) (i+'a');
//            System.out.println(ch + " : " + array[i]);
//        }
//
//        int[] alphabet = new int[26];
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        input = br.readLine();
//        for (int i = 0; i < input.length(); i++) {
//            alphabet[input.charAt(i) - 'a']++;
//        }
//
//        char character = 'a';
//        for (int a : alphabet) {
//            System.out.printf("%c의 갯수: %d\n", character++, a);
//        }
        int[] alphabetCount = new int[26]; //  [0] = a, [1] = b...
        String str = "abbcccddddeeeeeffffggghhiabbcccddddeeeeeffffggghhi";
        int strLength = str.length();
        for (int i = 0; i<strLength; i++) {
            alphabetCount[str.charAt(i) - 'a']++; // 모두 0으로 초기화되어 있나?
        }
        for (int i = 0; i<26; i++) {
            char c = (char) (i + 'a');
            System.out.println(c + " " + alphabetCount[i]);
        }
    }
}
