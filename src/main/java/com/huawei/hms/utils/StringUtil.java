/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.utils;

import java.util.regex.Pattern;

public class StringUtil {
    public static String addByteForNum(String string2, int n10, char c10) {
        int n11 = string2.length();
        if (n11 == n10) {
            return string2;
        }
        if (n11 > n10) {
            return string2.substring(n11 -= n10);
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (n11 < n10) {
            stringBuffer.append(c10);
            ++n11;
        }
        stringBuffer.append(string2);
        return stringBuffer.toString();
    }

    public static boolean checkVersion(String string2) {
        return Pattern.compile("(^([0-9]{1,2}\\.){2}[0-9]{1,2}$)|(^([0-9]{1,2}\\.){3}[0-9]{1,3}$)").matcher(string2).find();
    }

    public static int convertVersion2Integer(String object) {
        int n10 = StringUtil.checkVersion((String)object);
        int n11 = 0;
        String string2 = null;
        if (n10 != 0) {
            int n12;
            String string3 = "\\.";
            n10 = ((String[])(object = object.split(string3))).length;
            if (n10 < (n12 = 3)) {
                return 0;
            }
            string3 = object[0];
            n10 = Integer.parseInt(string3) * 10000000;
            n11 = Integer.parseInt(object[1]) * 100000;
            n10 += n11;
            string2 = object[2];
            n11 = Integer.parseInt(string2) * 1000;
            n10 += n11;
            n11 = ((String[])object).length;
            int n13 = 4;
            if (n11 == n13) {
                object = object[n12];
                int n14 = Integer.parseInt((String)object);
                n10 += n14;
            }
            return n10;
        }
        return 0;
    }

    public static String objDesc(Object object) {
        if (object == null) {
            object = "null";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            String string2 = object.getClass().getName();
            stringBuilder.append(string2);
            char c10 = '@';
            stringBuilder.append(c10);
            int n10 = object.hashCode();
            object = Integer.toHexString(n10);
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
        }
        return object;
    }
}

