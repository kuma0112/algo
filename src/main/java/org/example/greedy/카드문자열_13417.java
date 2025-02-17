package org.example.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 카드문자열_13417 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 3

        for (int i = 0; i < N; i++) {
            ArrayList<Character> list = new ArrayList<>();
            int alphabet = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < alphabet; j++) {
                list.add(st.nextToken().charAt(0));
            }
            solution(list);
        }
    }
    static void solution(ArrayList<Character> array) {
        LinkedList<Character> list = new LinkedList<>();
        list.add(array.get(0));
        Character first = array.get(0);
        Character last = array.get(0);

        for (int i = 1; i < array.size() ; i++) {
            Character temp = array.get(i);
            if (temp <= first) {
                first = temp;
                list.addFirst(temp);
            } else {
                last = temp;
                list.addLast(temp);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        System.out.println(sb.toString());
    }
}
