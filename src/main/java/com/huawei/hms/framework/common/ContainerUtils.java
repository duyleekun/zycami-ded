/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.framework.common;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ContainerUtils {
    public static final String FIELD_DELIMITER = "&";
    public static final String KEY_VALUE_DELIMITER = "=";

    public static boolean equals(Map object, Map map) {
        int n10;
        int n11;
        boolean bl2 = true;
        if (object == map) {
            return bl2;
        }
        boolean bl3 = false;
        if (object != null && map != null && (n11 = object.size()) == (n10 = map.size())) {
            object = object.entrySet().iterator();
            while ((n11 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                Map.Entry entry = (Map.Entry)object.next();
                Object object2 = entry.getKey();
                if ((object2 = map.get(object2)) == (entry = entry.getValue())) continue;
                bl3 = bl2;
                break;
            }
            return bl3 ^ true;
        }
        return false;
    }

    public static int hashCode(Map map) {
        return ContainerUtils.toString(map).hashCode();
    }

    public static String toString(List object) {
        boolean bl2;
        if (object == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int n10 = 0;
        String string2 = null;
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            int n11 = n10 + 1;
            if (n10 > 0) {
                string2 = FIELD_DELIMITER;
                stringBuilder.append(string2);
            }
            string2 = e10.toString();
            stringBuilder.append(string2);
            n10 = n11;
        }
        return stringBuilder.toString();
    }

    public static String toString(Map object) {
        boolean bl2;
        if (object == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int n10 = 0;
        String string2 = null;
        object = object.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            Map.Entry entry = (Map.Entry)object.next();
            int n11 = n10 + 1;
            if (n10 > 0) {
                string2 = FIELD_DELIMITER;
                stringBuilder.append(string2);
            }
            string2 = entry.getKey().toString();
            stringBuilder.append(string2);
            stringBuilder.append(KEY_VALUE_DELIMITER);
            string2 = entry.getValue().toString();
            stringBuilder.append(string2);
            n10 = n11;
        }
        return stringBuilder.toString();
    }

    public static String toString(Set object) {
        boolean bl2;
        if (object == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int n10 = 0;
        String string2 = null;
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            int n11 = n10 + 1;
            if (n10 > 0) {
                string2 = FIELD_DELIMITER;
                stringBuilder.append(string2);
            }
            string2 = e10.toString();
            stringBuilder.append(string2);
            n10 = n11;
        }
        return stringBuilder.toString();
    }
}

