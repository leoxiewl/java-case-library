package com.bewind.compare;

import java.util.Comparator;

public class ComparatorExample {

    // 初始值为 null
    static Integer i;

    public static void main(String[] args) {
        if (i == 42) {
            System.out.println("Unbelievable");
        }
        // Exception in thread "main" java.lang.NullPointerException:
        // Cannot invoke "java.lang.Integer.intValue()" because "com.bewind.compare.ComparatorExample.i" is null

        // 就像所有的对象引用域一样，它的初始值为nu11。当程序计算表达式(i==42)时，它会将 Integer 与int 进行比较。
        // 几乎在任何一种情况下，当在一项操作中混合使用基本类型和装箱基本类型时，装箱基本类型就会自动拆箱，这种情况无一例外。
        // 如果 null 对象引用被自动拆箱，就会抛出一个NullPointerException异常。
    }
}
