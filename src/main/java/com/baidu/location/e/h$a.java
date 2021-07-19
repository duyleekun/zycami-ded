/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.location.e;

public final class h$a
extends Enum {
    public static final /* enum */ h$a a;
    public static final /* enum */ h$a b;
    private static final /* synthetic */ h$a[] c;

    static {
        h$a h$a;
        h$a h$a2;
        a = h$a2 = new h$a("NEED_TO_LOG", 0);
        int n10 = 1;
        b = h$a = new h$a("NO_NEED_TO_LOG", n10);
        h$a[] h$aArray = new h$a[2];
        h$aArray[0] = h$a2;
        h$aArray[n10] = h$a;
        c = h$aArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private h$a() {
        void var2_-1;
        void var1_-1;
    }

    public static h$a valueOf(String string2) {
        return Enum.valueOf(h$a.class, string2);
    }

    public static h$a[] values() {
        return (h$a[])c.clone();
    }
}

