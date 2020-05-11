package com.seckill.zuul.util;

public class StringUtils {

    public static boolean isNullOrBlank(Object str) {
        if (str == null || str.toString().trim().length() == 0) {
            return true;
        } else {
            return false;
        }
    }
}
