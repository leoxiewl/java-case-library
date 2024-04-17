package com.bewind.javabean;

public class CreateBeanByStaticFactory {
    public static void main(String[] args) {
        Boolean b1 = Boolean.valueOf(true);
        System.out.println(b1);
        Shape circle = Shape.newInstance(true);
    }

    public static Boolean valueOf(boolean b) {
        return b ? Boolean.TRUE : Boolean.FALSE;
    }
}

abstract class Shape{

    // 灵活创建子类
    public static Shape newInstance(boolean isCircle){
        return isCircle ? new Circle():new Square();
    }
}

class Circle extends Shape{}
class Square extends Shape{}
