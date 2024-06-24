package org.example.basic.ch03;

// 그리디한 생각을 자바코드로 변환 연습 필요
public class 거스름돈 {
    public static void main(String[] args) {
        int money = 1260;
        int cnt = 0;
        int[] coinTypes = {500, 100, 50, 10}; // 동전 큰 것부터 작은 것으로 배열

        for (int i = 0; i < 4; i++) {
            int coin = coinTypes[i];
            cnt += money / coin; // 몫. 12 / 5이면 2를 리턴
            money %= coin;
        }

        System.out.println(cnt);
    }
}
