/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.util;

import java.util.HashMap;
import java.util.Iterator;

public class MapUtils {
    public static void writeStringMapToJson(StringBuilder stringBuilder, HashMap hashMap) {
        boolean bl2;
        stringBuilder.append("{");
        Iterator iterator2 = hashMap.keySet().iterator();
        boolean bl3 = true;
        while (bl2 = iterator2.hasNext()) {
            String string2;
            String string3 = (String)iterator2.next();
            if (!bl3) {
                string2 = ",";
                stringBuilder.append(string2);
            } else {
                bl3 = false;
            }
            string2 = (String)hashMap.get(string3);
            String string4 = "\"";
            stringBuilder.append(string4);
            stringBuilder.append(string3);
            string3 = "\":";
            stringBuilder.append(string3);
            if (string2 == null) {
                string3 = "null";
                stringBuilder.append(string3);
                continue;
            }
            stringBuilder.append(string4);
            stringBuilder.append(string2);
            stringBuilder.append(string4);
        }
        stringBuilder.append("}");
    }
}

