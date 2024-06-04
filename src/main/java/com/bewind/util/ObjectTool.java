package com.bewind.util;

import org.apache.commons.lang3.ObjectUtils;

public class ObjectTool {
    public static void main(String[] args) {
        isNullByCommonLang();
    }

    // 判断对象是否为空
    public static void isNullByCommonLang() {
        String str = null;
        String str2 = "";
        String str3 = "Apache Commons Lang";

        // 检查是否为null或空
        System.out.println(ObjectUtils.isEmpty(str)); // true
        System.out.println(ObjectUtils.isEmpty(str2)); // true
        System.out.println(ObjectUtils.isEmpty(str3)); // false
    }
}
