package org.example.basic.ch05;

import java.util.ArrayDeque;
import java.util.Deque;

// stack -> ArrayDeque(가볍고 유연함)
public class Stack2 {
    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();

        // stack과 같은 메서드를 쓸 수 있음
        stack.push(5);
        stack.push(2);
        stack.push(3);
        stack.push(7);
        stack.pop();
        stack.push(1);
        stack.push(4);
        stack.pop();

        // stack.empty() 대신
        while(!stack.isEmpty()) {
            System.out.println(stack.peek());
            stack.pop();
        }
    }
}
