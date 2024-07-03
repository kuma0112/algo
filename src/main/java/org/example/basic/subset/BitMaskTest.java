package org.example.basic.subset;

public class BitMaskTest {
    public static void main(String[] args) {
//        System.out.println(1 << 1); // 0001 -> 0010 : 2
//        System.out.println(2 << 3); // 0010 -> 0001 0000 : 16
//        System.out.println(3 << 2); // 0011 -> 1100 : 12
        System.out.println(3 & 1); // 0011 0001 -> 0001 (1겹치는 부분만 1)
        System.out.println(3 | 1); // 0011 0001 -> 0011 (1이 있기만 하면 1)
        System.out.println(3 | 1 << 2); // 0011 0100 -> 0111 : 7 (<<먼저 수행됨)
        System.out.println(3 & 1 << 2); // 0011 0100 -> 0000 : 0
        System.out.println(3 & 1 << 1); // 0011 0010 -> 0010 : 2

        // 0111 : 7인데, 7이라는 값 자체보다 몇 번째가 0이고 1이냐가 중요.
        System.out.println(7 & 1 << 1);
        // a & 1 << b의 의미는 무엇이냐 하면,
        // a를 bit로 표현하면 b자리가 1인지 0인지 알 수 있다는 뜻.
        // 결과가 0이면 0이고, 0이 아니면 1이라는 뜻.

        System.out.println(7 | 1 << 1); // 1111 : 15
        // 이렇게 하면 a의 b자리를 1로 변경할 수 있다. 다른 애들은 그냥 받겠다. 해당 자리는 꼭 1로 만들겠다.


    }
}
