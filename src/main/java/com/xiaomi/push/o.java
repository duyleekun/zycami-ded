/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class o
extends Enum {
    public static final /* enum */ o a;
    private static final /* synthetic */ o[] a;
    public static final /* enum */ o b;
    public static final /* enum */ o c;
    public static final /* enum */ o d;
    public static final /* enum */ o e;

    static {
        o o10;
        o o11;
        o o12;
        o o13;
        o o14;
        a = o14 = new o("China", 0);
        int n10 = 1;
        b = o13 = new o("Global", n10);
        int n11 = 2;
        c = o12 = new o("Europe", n11);
        int n12 = 3;
        d = o11 = new o("Russia", n12);
        int n13 = 4;
        e = o10 = new o("India", n13);
        o[] oArray = new o[5];
        oArray[0] = o14;
        oArray[n10] = o13;
        oArray[n11] = o12;
        oArray[n12] = o11;
        oArray[n13] = o10;
        a = oArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private o() {
        void var2_-1;
        void var1_-1;
    }

    public static o valueOf(String string2) {
        return Enum.valueOf(o.class, string2);
    }

    public static o[] values() {
        return (o[])a.clone();
    }
}

