package com.bewind.streamapi;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ImmutableList {
    public static void main(String[] args) {
        // 创建一个不可变的集合
        createImmutableList();
        createImmutableSet();
        createImmutableMap();
    }

    public static void createImmutableList() {
        List<String> list = List.of("java", "python", "go");
//        list.add("c"); // java.lang.UnsupportedOperationException
        for (String s : list) {
            System.out.println(s);
        }
    }

    public static void createImmutableSet() {
        Set<String> set = Set.of("java", "python", "go");
//        set.remove("java"); //java.lang.UnsupportedOperationException
        for (String s : set) {
            System.out.println(s);
        }
    }

    // map 中可以传递的参数是有限的，最多可以传递10个键值对。如果要传递超过10个键值对传入entry对象即可
    public static void createImmutableMap() {
        Map<String, Integer> map = Map.of("v1", 1, "v2", 2, "v3", 3);
//        map.put("v4", 4);
        for (String s : map.keySet()) {
            System.out.println(s);
        }
    }
}
