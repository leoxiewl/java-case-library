package com.bewind.compare;

// 自动装箱拆箱会导致程序执行变慢
// 下面这个程序编译起来没有错误和警告，变量被反复的装箱和拆箱，导致程序执行变慢
public class ComparatorExample01 {
    public static void main(String[] args) {
        Long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println(sum);
    }
}
