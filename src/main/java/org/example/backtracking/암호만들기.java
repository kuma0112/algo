package org.example.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 암호만들기 {
    static int L, C;
    static char[] array, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken()); // 암호 길이
        C = Integer.parseInt(st.nextToken()); // 암호에 사용된 알파벳 개수

        array = new char[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            array[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(array);
        answer = new char[L];
        dfs(0, 0);
    }

    static void dfs(int startIdx, int length) {
        if (length == L) {
            boolean hasVowel = false;
            int numberOfConst = 0;
            for (int i = 0; i < L; i++) {
                if (answer[i] == 'a' || answer[i] == 'e' || answer[i] == 'i' || answer[i] == 'o' || answer[i] == 'u') {
                    hasVowel = true;
                } else {
                    numberOfConst++;
                }
            }

            if (hasVowel && numberOfConst >= 2) {
                for (int i = 0; i < L; i++) {
                    System.out.print(answer[i]);
                }
                System.out.println();
            }
            return;
        }
        for (int i = startIdx; i < C; i++) {
            answer[length] = array[i]; // 문자 집어넣기
            dfs(i + 1, length + 1);
        }

    }
}
