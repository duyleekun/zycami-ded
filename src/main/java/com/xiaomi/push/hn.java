/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class hn
extends Enum {
    public static final /* enum */ hn a;
    private static final /* synthetic */ hn[] a;
    public static final /* enum */ hn b;
    private final int a;

    static {
        hn hn2;
        hn hn3;
        a = hn3 = new hn("START", 0, 0);
        int n10 = 1;
        b = hn2 = new hn("BIND", n10, n10);
        hn[] hnArray = new hn[2];
        hnArray[0] = hn3;
        hnArray[n10] = hn2;
        a = hnArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private hn() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.a = var3_1;
    }

    public static hn valueOf(String string2) {
        return Enum.valueOf(hn.class, string2);
    }

    public static hn[] values() {
        return (hn[])a.clone();
    }

    public int a() {
        return this.a;
    }
}

