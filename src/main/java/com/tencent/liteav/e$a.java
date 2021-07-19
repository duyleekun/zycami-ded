/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav;

public final class e$a
extends Enum {
    public static final /* enum */ e$a a;
    public static final /* enum */ e$a b;
    public static final /* enum */ e$a c;
    private static final /* synthetic */ e$a[] d;

    static {
        e$a e$a;
        e$a e$a2;
        e$a e$a3;
        a = e$a3 = new e$a("PENDING", 0);
        int n10 = 1;
        b = e$a2 = new e$a("CONFIRM", n10);
        int n11 = 2;
        c = e$a = new e$a("NEGATIVE", n11);
        e$a[] e$aArray = new e$a[3];
        e$aArray[0] = e$a3;
        e$aArray[n10] = e$a2;
        e$aArray[n11] = e$a;
        d = e$aArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private e$a() {
        void var2_-1;
        void var1_-1;
    }

    public static e$a valueOf(String string2) {
        return Enum.valueOf(e$a.class, string2);
    }

    public static e$a[] values() {
        return (e$a[])d.clone();
    }
}

