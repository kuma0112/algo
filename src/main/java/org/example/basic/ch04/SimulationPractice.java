package org.example.basic.ch04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class SimulationPractice {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String command = br.readLine();
            StringTokenizer st = new StringTokenizer(command);
            if (command.startsWith("push")) {
                st.nextToken();
                stack.push(Integer.parseInt(st.nextToken()));
            }

            if (command.startsWith("pop")) {
                if (!stack.empty()) {
                    int num = stack.pop();
                    System.out.println(num);
                } else System.out.println("-1");
            }

            if (command.startsWith("size")) {
                System.out.println(stack.size());
            }

            if (command.startsWith("empty")) {
                if (stack.empty()) {
                    System.out.println("1");
                } else System.out.println("0");
            }

            if (command.startsWith("top")) {
                if (!stack.empty()) {
                    int num = stack.peek();
                    System.out.println(num);
                } else System.out.println("-1");
            }
        }
    }
}
