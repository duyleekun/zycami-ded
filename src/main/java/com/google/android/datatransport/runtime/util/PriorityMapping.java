/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 */
package com.google.android.datatransport.runtime.util;

import android.util.SparseArray;
import com.google.android.datatransport.Priority;
import java.io.Serializable;
import java.util.HashMap;

public final class PriorityMapping {
    private static HashMap PRIORITY_INT_MAP;
    private static SparseArray PRIORITY_MAP;

    static {
        boolean bl2;
        Object object = new SparseArray();
        PRIORITY_MAP = object;
        object = new HashMap();
        PRIORITY_INT_MAP = object;
        Priority priority = Priority.DEFAULT;
        Integer n10 = 0;
        ((HashMap)object).put(priority, n10);
        object = PRIORITY_INT_MAP;
        priority = Priority.VERY_LOW;
        n10 = 1;
        ((HashMap)object).put(priority, n10);
        object = PRIORITY_INT_MAP;
        priority = Priority.HIGHEST;
        int n11 = 2;
        n10 = n11;
        ((HashMap)object).put(priority, n10);
        object = PRIORITY_INT_MAP.keySet().iterator();
        while (bl2 = object.hasNext()) {
            priority = (Priority)((Object)object.next());
            n10 = PRIORITY_MAP;
            Integer n12 = (Integer)PRIORITY_INT_MAP.get((Object)priority);
            int n13 = n12;
            n10.append(n13, (Object)priority);
        }
    }

    public static int toInt(Priority object) {
        Serializable serializable = (Integer)PRIORITY_INT_MAP.get(object);
        if (serializable != null) {
            return serializable;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PriorityMapping is missing known Priority value ");
        stringBuilder.append(object);
        object = stringBuilder.toString();
        serializable = new IllegalStateException((String)object);
        throw serializable;
    }

    public static Priority valueOf(int n10) {
        Object object = (Priority)((Object)PRIORITY_MAP.get(n10));
        if (object != null) {
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown Priority for value ");
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        object = new IllegalArgumentException(string2);
        throw object;
    }
}

