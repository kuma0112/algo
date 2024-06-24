package org.example.basic.recursive;

public class RecursiveCallTest {
    public static void main(String[] args) {
//        m1();
//        m1_2(0);
//        m2();
        m3();
//        m4();
//        m5(5);
    }

//    static int m1_cnt = 0;
//    static void m1() {
////        int i = 0;
////        System.out.println("m1" + i);
//        m1();
//        System.out.println("m1" + m1_cnt++);
//    }
//
//    static void m1_2(int i) {
//        i++;
//        m1_2(i);
//    }

    static int m2_cnt = 5;
    static void m2() {
        System.out.println("앞 m2 cnt : " + m2_cnt);

        if(m2_cnt > 0) {
            m2_cnt--;
            m2();
        }

        System.out.println("뒤 m2 cnt : " + m2_cnt);
    }

    static int m3_cnt = 5;
    static void m3() {
        // 끝내기 전에 무조건 수행되어야 되는 애(기저조건 체크 전이기 때문에 호출만 되면 무조건 수행)는, 항상 한번 더 실행됨
        System.out.println("앞 m3 cnt : " + m3_cnt);

        if(m3_cnt == 0) {
            return;
        }

        m3_cnt--;
        m3();

        System.out.println("뒤 m3 cnt : " + m3_cnt); // 기저조건 체크 후에 있어서 기저 조건에 의해 리턴되면 수행되지 않아서 -1번 수행됨
    }

    static int m4_cnt = 5;
    static void m4() {
        // 앞뒤 메서드 실행 횟수를 같게 하고 싶다면 아래처럼 변경해야

        // 기저조건은 맨 위에 위치하는 것이 좋다. 들어와서 조건 안 맞으면 바로 나가 버리게
        if(m4_cnt == 0) {
            return;
        }
        System.out.println("앞 m4 cnt : " + m4_cnt);

        m4_cnt--;
        m4();
        m4_cnt ++; // 재귀 호출 전후에 동일한 static 변수의 값을 가지려면 변화량의 반대로 처리를 해줘야 한다.
        // call 되던 시점으로 복귀시키기

        System.out.println("뒤 m4 cnt : " + m4_cnt);
    }

// static 대신 파라미터를 공유해 보자.
    static void m5(int m5_cnt) {

        if(m5_cnt == 0) {
            return;
        }

        // 앞 뒤 출력을 쌍으로 맞추려면 기저 조건이 맨 위로 이동해야 한다.
        System.out.println("앞 m5 cnt : " + m5_cnt);

        // 1. 줄였다 복구하는 방법
//        m5_cnt--;
//        m5(m5_cnt);
//        m5_cnt ++; // 파라미터도 이렇게 복구!

        // 2. 줄이지 않고 줄이는 연산을 통해 전달 = 변수를 직접 줄이는 게 아니라 '변수를 줄이는 연산을 한 값'을 전달
//        m5(m5_cnt-1);
//        System.out.println("뒤 m5 cnt : " + m5_cnt);

        // 3. -- 연산자
//        m5(m5_cnt--); // 이건 왜 안 될까?
        // m5()가 호출된 순간에는 줄지 않음. 계속 5가 전달됨.
        // stack overflow 발생

        // 4. -- 연산자 앞에 붙이기
        m5(--m5_cnt); // 쌍이 맞지 않음. 변수를 바꾸는 것과 동일하기 때문에 원복시켜주어야.
//        m5_cnt++;
        System.out.println("뒤 m5 cnt : " + m5_cnt);
    }
}
