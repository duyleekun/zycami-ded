/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.beauty;

public final class d$d
extends Enum {
    public static final /* enum */ d$d a;
    public static final /* enum */ d$d b;
    public static final /* enum */ d$d c;
    private static final /* synthetic */ d$d[] d;

    static {
        d$d d$d;
        d$d d$d2;
        d$d d$d3;
        a = d$d3 = new d$d("MODE_SAME_AS_OUTPUT", 0);
        int n10 = 1;
        b = d$d2 = new d$d("MODE_SAME_AS_INPUT", n10);
        int n11 = 2;
        c = d$d = new d$d("MODE_THRESHOLD", n11);
        d$d[] d$dArray = new d$d[3];
        d$dArray[0] = d$d3;
        d$dArray[n10] = d$d2;
        d$dArray[n11] = d$d;
        d = d$dArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private d$d() {
        void var2_-1;
        void var1_-1;
    }

    public static d$d valueOf(String string2) {
        return Enum.valueOf(d$d.class, string2);
    }

    public static d$d[] values() {
        return (d$d[])d.clone();
    }
}

