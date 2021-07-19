/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import com.xiaomi.push.iy;
import com.xiaomi.push.iz;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class iy$a
implements Comparator {
    private iy$a() {
    }

    public /* synthetic */ iy$a(iz iz2) {
        this();
    }

    public int compare(Object object, Object object2) {
        if (object == null && object2 == null) {
            return 0;
        }
        if (object == null) {
            return -1;
        }
        if (object2 == null) {
            return 1;
        }
        boolean bl2 = object instanceof List;
        if (bl2) {
            object = (List)object;
            object2 = (List)object2;
            return iy.a((List)object, (List)object2);
        }
        bl2 = object instanceof Set;
        if (bl2) {
            object = (Set)object;
            object2 = (Set)object2;
            return iy.a((Set)object, (Set)object2);
        }
        bl2 = object instanceof Map;
        if (bl2) {
            object = (Map)object;
            object2 = (Map)object2;
            return iy.a((Map)object, (Map)object2);
        }
        bl2 = object instanceof byte[];
        if (bl2) {
            object = (byte[])object;
            object2 = (byte[])object2;
            return iy.a((byte[])object, (byte[])object2);
        }
        object = (Comparable)object;
        object2 = (Comparable)object2;
        return iy.a((Comparable)object, (Comparable)object2);
    }
}

