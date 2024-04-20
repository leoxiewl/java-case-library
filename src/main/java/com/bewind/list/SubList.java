package com.bewind.list;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SubList {
    public static void main(String[] args) {
//        subListOOM();

        solveSubListOOM();
    }

//    SubList 相当于原始 List 的视图
//    原始 List 中数字 3 被删除了，说明删除子 List 中的元素影响到了原始 List；
//    尝试为原始 List 增加数字 0 之后再遍历子 List，会出现 ConcurrentModificationException。
    public static void subListOOM() {

        // 初始化 1~10 的 ArrayList
        List<Integer> list = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
        System.out.println("原始: " + list);

        // 取出 2、3、4
        List<Integer> subList = list.subList(1, 4);
        System.out.println("subList: " + subList);

        // 删除 subList 元素 3
        subList.remove(2);
        System.out.println(" 删除 subList 元素 3 后打印原始List: " + list);

        list.add(0);
        try {
            subList.forEach(System.out::println);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void solveSubListOOM() {

        List<Integer> list = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
        //方式一：重新使用 new ArrayList，创建独立的ArrayList
        List<Integer> subList1 = new ArrayList<>(list.subList(1, 4));

        //方式二：对于 Java 8 使用 Stream 的 skip 和 limit API 来跳过流中的元素，以及限制流中元素的个数，同样可以达到 SubList 切片的目的。
        List<Integer> subList2 = list.stream().skip(1).limit(3).collect(Collectors.toList());

        // 删除 subList 元素 3
        subList1.remove(2);
        subList2.remove(2);

        System.out.println(subList1);
        System.out.println(subList2);
        System.out.println(list);
    }
}

