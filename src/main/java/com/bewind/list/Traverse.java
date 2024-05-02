package com.bewind.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// 集合遍历
public class Traverse {
    public static void main(String[] args) {
        // 初始化List集合
        List<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("王五");

        iteratorExample(list);
        foreachExample(list);
        forIndexExample(list);
    }

    // ✅推荐 for each 遍历
    public static void foreachExample(List<String> list) {
        for (String s : list) {
            System.out.println("for each: " + s);
        }
    }

    // 迭代器遍历
    public static void iteratorExample(List<String> list) {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println("迭代器: " + iterator.next());
        }

        // 迭代器作用域更低的写法
        for (Iterator<String> it = list.iterator(); it.hasNext(); ) {
            System.out.println("迭代器控制作用域: " + it.next());
        }
    }

    // 传统 for 循环遍历数组
    public static void forIndexExample(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            String j = list.get(i);
            System.out.println("Index: " + j);
        }
    }
}
