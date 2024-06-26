package org.example.basic.ch05;

import java.util.Stack;

public class Stack1 {
    public static void main(String[] args) {
        // 정수를 stack에 넣고 빼고, 들여다보고 ...

        Stack<Integer> stack = new Stack<>();

        stack.push(5);
        stack.push(2);
        stack.push(3);
        stack.push(7);
        stack.pop();
        stack.push(1);
        stack.push(4);
        stack.pop();

        while(!stack.empty()) {
            System.out.println(stack.peek());
            stack.pop();
        }
    }
}
