package org.example.자료구조;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class 균형잡힌세상_4949 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            String line = br.readLine();
            if (line.equals(".")) break;

            sb.append(solution(line)).append("\n");
        }
        System.out.println(sb);
    }

    static String solution(String line) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);

            if (c == '(' || c == '[') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.empty() || stack.peek() != '(') return "no";
                else stack.pop();
            } else if (c == ']') {
                if (stack.empty() || stack.peek() != '[') return "no";
                else stack.pop();
            }
        }

        return stack.empty() ? "yes" : "no";
    }
}
