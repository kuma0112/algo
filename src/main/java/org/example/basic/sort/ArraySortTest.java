package org.example.basic.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

// 자바는 이미 최고의 정렬 API를 제공하고 있다.
// 우리가 정렬을 배우는 이유는 정렬이 필요할 때 적절히 사용하기 위해서!
public class ArraySortTest {
    public static void main(String[] args) {
//        // 정수 정렬
//        int[] intArray = {3, 5, 2, 7, 9, 4};
//        Arrays.sort(intArray);
//        System.out.println(Arrays.toString(intArray)); // [2, 3, 4, 5, 7, 9]
//
//        // 문자열
//        String[] strArray = {"hello", "ABC", "World", "UPLUS"};
//        Arrays.sort(strArray, Collections.reverseOrder()); // 반대로 정렬하고 싶다면
//        System.out.println(Arrays.toString(strArray)); // [ABC, UPLUS, World, hello]
//        // 소문자는 뒤로 가는 것을 보시라!

        Item[] itemArray = {
                new Item(3, "666"),
                new Item(2, "777"),
                new Item(5, "444"),
                new Item(3, "111"),
        };

//        Arrays.sort(itemArray, Collections.reverseOrder());

        // 이렇게 정렬 조건을 주면 comparable interface를 따로 Implement하지 않아도 되고
        // 있어도 sort()에 넣은 정렬조건으로 정렬이 된다.
//        Arrays.sort(itemArray, [정렬 조건]);

        // 정렬 기준을 가지고 잇는 Comparator(comparable아님 주의)  interface 객체를 정렬 기준으로 전달
        // 정렬 방법 2 : Comparable 객체 전달(익명 함수)/ 대상 객체에 comparable 구현 없어도 됨
//        Arrays.sort(itemArray, new Comparator<Item>() {
//            @Override
//            public int compare(Item o1, Item o2) {
////                return o1.itemId - o2.itemId;
//                return o1.itemName.compareTo(o2.itemName);
//            }
//        });
//
////        Arrays.sort(itemArray);
//        System.out.println(Arrays.toString(itemArray)); // 그냥 바로 날리면 오류
//        // Arrays.sort로 정렬하려면 Comparable 인터페이스를 implement한 객체여야 함.


        // 정렬 방법 3 : 람다
        Arrays.sort(itemArray, (o1, o2) -> o1.itemId - o2.itemId);

//        Arrays.sort(itemArray);
        System.out.println(Arrays.toString(itemArray)); // 그냥 바로 날리면 오류
    }

    // 정렬을 하기 위한 방법 1 : Comparable interface를 구현한다.

    static class Item implements Comparable<Item>{
        int itemId;
        String itemName;

        Item(int itemId, String itemName) {
            this.itemId = itemId;
            this.itemName = itemName;
        }

        @Override
        public String toString() {
            return "Item{" + "itemId=" + itemId + ", itemName='" + itemName + '\'' + '}';
        }

        @Override
        public int compareTo(Item o) {
//            // itemId를 asc로 정렬하고 싶다면?
//            return this.itemId - o.itemId;
//            // 음수가 나오면 this가 앞. 반대로 하려면 순서 바꾸거나 전체 마이너스 처리.

//            // itemName 기준 정렬로 정렬하고 싶다면?
//            return this.itemName.compareTo(o.itemName);

            // item id로 우선 비교 후 id가 같으면 name 기준 정렬
            return this.itemId == o.itemId ? this.itemName.compareTo(o.itemName) : this.itemId-o.itemId;
        }
    }
}
