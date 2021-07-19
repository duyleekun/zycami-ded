/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.framework.network.grs.c;

public final class b$a
extends Enum {
    public static final /* enum */ b$a a;
    public static final /* enum */ b$a b;
    public static final /* enum */ b$a c;
    private static final /* synthetic */ b$a[] d;

    static {
        b$a b$a;
        b$a b$a2;
        b$a b$a3;
        a = b$a3 = new b$a("GRSPOST", 0);
        int n10 = 1;
        b = b$a2 = new b$a("GRSGET", n10);
        int n11 = 2;
        c = b$a = new b$a("GRSDEFAULT", n11);
        b$a[] b$aArray = new b$a[3];
        b$aArray[0] = b$a3;
        b$aArray[n10] = b$a2;
        b$aArray[n11] = b$a;
        d = b$aArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private b$a() {
        void var2_-1;
        void var1_-1;
    }

    public static b$a valueOf(String string2) {
        return Enum.valueOf(b$a.class, string2);
    }

    public static b$a[] values() {
        return (b$a[])d.clone();
    }
}

