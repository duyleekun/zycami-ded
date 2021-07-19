/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class g$a
extends Enum {
    public static final /* enum */ g$a a;
    private static final /* synthetic */ g$a[] a;
    public static final /* enum */ g$a b;
    public static final /* enum */ g$a c;
    private final int a;

    static {
        g$a g$a;
        g$a g$a2;
        g$a g$a3;
        a = g$a3 = new g$a("UNKNOWN", 0, 0);
        int n10 = 1;
        b = g$a2 = new g$a("ALLOWED", n10, n10);
        int n11 = 2;
        c = g$a = new g$a("NOT_ALLOWED", n11, n11);
        g$a[] g$aArray = new g$a[3];
        g$aArray[0] = g$a3;
        g$aArray[n10] = g$a2;
        g$aArray[n11] = g$a;
        a = g$aArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private g$a() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.a = var3_1;
    }

    public static g$a valueOf(String string2) {
        return Enum.valueOf(g$a.class, string2);
    }

    public static g$a[] values() {
        return (g$a[])a.clone();
    }

    public int a() {
        return this.a;
    }
}

