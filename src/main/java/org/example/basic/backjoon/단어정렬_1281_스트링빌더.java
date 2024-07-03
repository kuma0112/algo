package org.example.basic.backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class 단어정렬_1281_스트링빌더 {
    static String[] strArray;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine()); // 13
        strArray = new String[num];
        for (int i = 0; i < num; i++) {
            strArray[i] = br.readLine();
        }

        Comparator<String> comparator = (o1, o2) -> {
            if (o1.length() - o2.length() == 0) {
                for (int i = 0; i < o1.length(); i++) {
                    if (o1.charAt(i) == o2.charAt(i)) continue;
                    return o1.charAt(i) - o2.charAt(i);
                }
            }
            return o1.length() - o2.length();
        };
        Arrays.sort(strArray, comparator);

        StringBuilder sb = new StringBuilder();
        sb.append(strArray[0]).append("\n");
        for (int i = 1; i < num; i++) {
            if (strArray[i-1].equals(strArray[i])) continue;
            sb.append(strArray[i]).append("\n");
        }
        System.out.println(sb);
    }
}
