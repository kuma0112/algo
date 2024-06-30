package org.example.basic.ch08;

public class 피보나치_재귀 {
    static long[] memoi = new long[100]; // 이미 계산된 것을 저장 후 재활용
    public static void main(String[] args) {
        memoi[1] = 1;
        memoi[2] = 1;
        int n = 50;
        for (int i = 3; i <= n; i++) {
             memoi[i] = memoi[i-1] + memoi[i-2];
        }
//        System.out.println(fibo(50)); // 숫자가 커지면 빠르게 처리가 안 됨. 답 안 나옴.
        System.out.println(memoi[n]);
    }
//
//    static long fibo(int x) {
//        if( x == 1 || x == 2) return 1;
//        if(memoi[x] != 0) return memoi[x]; // 이미 계산된 것이 있으면 그것을 리턴
////        memoi[x] = fibo(x -1) + fibo(x -2);
////        return memoi[x];
//        return memoi[x] = fibo(x-1) + fibo(x-2);
//    }
}
