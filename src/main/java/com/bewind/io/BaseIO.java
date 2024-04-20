package com.bewind.io;

import java.util.Scanner;

public class BaseIO {
    public static void main(String[] args) {

        // 输入
//        input();

       output();
    }

    // 输入
    public static void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello");
        String hi = scanner.nextLine();
        System.out.println("你输入了: " + hi);
    }

    public static void output() {
        // 格式化输出
        double amount = 100.00 / 30.00;
        // 普通情况
        System.out.println(amount);

        // 格式化 printf方法 一个字段宽度(field width)打印x:这包括8个字符，另外精度为小数点后2个字符
        System.out.printf("金额: %4.2f \n", amount);

        System.out.println("---------------------------");

        // printf 可以有多个参数
        String name = "Leo";
        int age = 18;
        System.out.printf("Name: %s, Age: %d",name,age);
    }
}
