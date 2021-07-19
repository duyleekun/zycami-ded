/*
 * Decompiled with CFR 0.151.
 */
package com.bumptech.glide.load.engine.bitmap_recycle;

import java.util.Iterator;
import java.util.TreeMap;

public class PrettyPrintTreeMap
extends TreeMap {
    public String toString() {
        Object object;
        int n10;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("( ");
        Iterator iterator2 = this.entrySet().iterator();
        while ((n10 = iterator2.hasNext()) != 0) {
            Object object2 = iterator2.next();
            stringBuilder.append('{');
            object = object2.getKey();
            stringBuilder.append(object);
            char c10 = ':';
            stringBuilder.append(c10);
            object2 = object2.getValue();
            stringBuilder.append(object2);
            object2 = "}, ";
            stringBuilder.append((String)object2);
        }
        int n11 = this.isEmpty();
        if (n11 == 0) {
            n11 = stringBuilder.length() + -2;
            n10 = stringBuilder.length();
            object = "";
            stringBuilder.replace(n11, n10, (String)object);
        }
        stringBuilder.append(" )");
        return stringBuilder.toString();
    }
}

