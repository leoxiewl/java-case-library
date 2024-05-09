package com.bewind.string;

public class BaseString {
    public static void main(String[] args) {
        // String 对象创建的两种方式
        createBean01();
        createBean02();

        // 字符串比较
        compareString();

        // 字符串比较忽略大小写
        compareStringIgnoreCase();

        testCharAt();

        testTrim();
    }

    // ✅
    public static void createBean01() {
        String s1 = "hello";
        String s2 = "hello";
        System.out.println(s1 == s2); // true
    }

    // 创建两次对象，一次在堆中，一次在常量池中
    public static void createBean02() {
        String s1 = new String("hello");
        String s2 = new String("hello");
        System.out.println(s1 == s2); // false
    }

    // 字符串比较
    public static void compareString() {
        String s1 = new String("hello");
        String s2 = new String("hello");
        System.out.println(s1.equals(s2)); // true
    }

    // 比较不区分大小写
    public static void compareStringIgnoreCase() {
        String str1 = "abc";
        String str2 = "ABC";
        System.out.println("比较不区分大小写: " + str1.equalsIgnoreCase(str2));
    }

    public static void testCharAt() {
        String str = "hello";
        char c = str.charAt(0);
        System.out.println("testCharAt: " + c); // h
    }

    public static void testTrim(){
        String str = " d f ";
        System.out.println("去除空格: " + str.trim());
    }

}
