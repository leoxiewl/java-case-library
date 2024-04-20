package com.bewind.list;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayToList {
    public static void main(String[] args) {
//        int[] arr = {1, 2, 3};
//        arrayAsList(arr);
//
//        Integer[] arrBox = {1, 2, 3};
//        arrayAsListByBox(arrBox);
//
//        arraysStream(arr);

        String[] strings = {"a", "ab", "abc"};
        arraysAsListByStrArr(strings);
    }

    // ❌不能直接使用 Arrays.asList 来转换基本类型数组
    public static void arrayAsList(int[] arr) {
        List list = Arrays.asList(arr);
        System.out.println("list: " + list);
        System.out.println("list size: " + list.size());
        System.out.println("list class: " + list.get(0).getClass());
        System.out.println("------------------------------");
        // 运行结果
//        list: [[I@49e4cb85]
//        list size: 1
//        list class: class [I

        // 这个 list 包含的是一个数组，整个 List 的元素个数是 1
    }

    // ❌ Arrays.asList 返回的 List 不支持增删操作
    // ❌ 对原始数组的修改会影响到我们获得的那个 List
    public static void arraysAsListByStrArr(String[] strings) {
        String[] arr = {"1", "2", "3"};
        List list = Arrays.asList(arr);
        arr[1] = "4"; // 注意
        try {
            list.add("5");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println("arr: " + Arrays.toString(arr));
        System.out.println("list: " + list);
        System.out.println("------------------------------");
//        log.info("arr:{} list:{}", Arrays.toString(arr), list);

        // 结果 报错，list值没有改变
//        java.lang.UnsupportedOperationException
//        at java.base/java.util.AbstractList.add(AbstractList.java:153)
//        at java.base/java.util.AbstractList.add(AbstractList.java:111)
//        at com.bewind.list.ArrayToList.arraysAsListByStrArr(ArrayToList.java:43)
//        at com.bewind.list.ArrayToList.main(ArrayToList.java:20)
//        arr: [1, 4, 3]
//        list: [1, 4, 3]

        System.out.println("解决");
        String[] arr1 = {"1", "2", "3"};
        List list1 = new ArrayList(Arrays.asList(arr1));
        arr1[1] = "4";
        try {
            list1.add("5");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("arr: " + Arrays.toString(arr1));
        System.out.println("list: " + list1);
        System.out.println("------------------------------");
    }

    // 请求参数为 Integer 包装类
    public static void arrayAsListByBox(Integer[] arr) {
        List list = Arrays.asList(arr);
        System.out.println("list: " + list);
        System.out.println("list size: " + list.size());
        System.out.println("list class: " + list.get(0).getClass());
        System.out.println("------------------------------");
    }

    // Java8以上，Arrays.stream
    public static void arraysStream(int[] arr) {
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        System.out.println("list: " + list);
        System.out.println("list size: " + list.size());
        System.out.println("list class: " + list.get(0).getClass());
        System.out.println("------------------------------");
    }

}
