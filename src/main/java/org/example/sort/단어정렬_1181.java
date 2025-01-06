package org.example.sort;

import java.io.*;
import java.util.*;

public class 단어정렬_1181 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        Set<String> stringSet = new HashSet<>();
        for (int i = 0; i < N; i++) {
            stringSet.add(br.readLine());
        }

        List<String> stringList = new ArrayList<>(stringSet);
        stringList.sort((o1, o2) -> {
            // 길이가 짧은 순으로 정렬
            if (o1.length() != o2.length()) {
                return o1.length() - o2.length();
            }
            // 길이가 같으면 사전 순으로 정렬
            for (int i = 0; i < o1.length(); i++) {
                if (o1.charAt(i) != o2.charAt(i)) {
                    return o1.charAt(i) - o2.charAt(i);
                }
            }
            return 0;
        });

        for (int i = 0; i < stringSet.size(); i++) {
            bw.write(stringList.get(i)+"\n");
        }
        bw.flush();
        bw.close();
    }
}
