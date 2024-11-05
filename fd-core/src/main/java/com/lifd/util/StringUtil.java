package com.lifd.util;

/**
 * @author : lifengdi
 * @createTime : 2024/11/5 10:20
 */
public class StringUtil {

    /**
     * 判断字符串是否为空
     * @param value 要判断的值
     * @return boolean
     */
    public static boolean isBlank(String value) {
        if (value == null) {
            return true;
        }
        int strLen = value.length();
        if (strLen == 0) {
            return true;
        } else {
            for (int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(value.charAt(i))) {
                    return false;
                }
            }

            return true;
        }
    }
}
