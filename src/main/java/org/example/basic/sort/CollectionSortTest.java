package org.example.basic.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionSortTest {
    public static void main(String[] args) {
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item(3, "666"));
        itemList.add(new Item(2, "777"));
        itemList.add(new Item(5, "444"));
        itemList.add(new Item(3, "111"));

        System.out.println(itemList);
        Collections.sort(itemList, (o1, o2)-> o1.itemName.compareTo(o2.itemName));
        Collections.sort(itemList, (o1, o2)-> o1.itemId == o2.itemId ?
                o1.itemName.compareTo(o2.itemName) : o1.itemId - o2.itemId);
        System.out.println(itemList);
    }



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
