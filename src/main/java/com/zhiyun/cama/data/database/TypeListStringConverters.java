/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class TypeListStringConverters {
    public static String stringListToString(List list) {
        boolean bl2;
        if (list != null && !(bl2 = list.isEmpty())) {
            int n10;
            StringBuilder stringBuilder = new StringBuilder();
            Iterator iterator2 = list.iterator();
            while ((n10 = iterator2.hasNext()) != 0) {
                int n11;
                String string2 = (String)iterator2.next();
                stringBuilder.append(string2);
                n10 = list.indexOf(string2);
                if (n10 == (n11 = list.size() + -1)) continue;
                string2 = ",";
                stringBuilder.append(string2);
            }
            return stringBuilder.toString();
        }
        return null;
    }

    public static List stringToStringList(String string2) {
        if (string2 == null) {
            return Collections.emptyList();
        }
        return Arrays.asList(string2.split(","));
    }
}

