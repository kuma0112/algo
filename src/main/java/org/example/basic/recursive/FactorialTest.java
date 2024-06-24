package org.example.basic.recursive;

public class FactorialTest {
    public static void main(String[] args) {
        factorial(5); // 5 4 3 2 1 순으로 곱해야 함.
        int result = factorial2(5);
        System.out.println(result);
        factorial3(5,1);
    }
    static int result = 1;
    static void factorial(int n) {
        if(n==1){
            System.out.println(result);
            return;
        }

        result = result * n;

        factorial(n-1);

    }

    static int factorial2(int n) {
        if(n==1){
            return 1;
        }

        return n * factorial2(n-1);

    }

    static void factorial3(int n, int result) {
        if(n==1){
            System.out.println(result);
            return;
        }

        factorial3(n-1, result * n);
    }
}
