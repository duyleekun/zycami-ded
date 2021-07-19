/*
 * Decompiled with CFR 0.151.
 */
package com.geetest.sdk;

public final class bb$a
extends Enum {
    public static final /* enum */ bb$a NORMAL;
    public static final /* enum */ bb$a ONEPASS;
    public static final /* enum */ bb$a REQUESTING;
    public static final /* enum */ bb$a SHUTDOWN;
    private static final /* synthetic */ bb$a[] a;

    static {
        bb$a bb$a;
        bb$a bb$a2;
        bb$a bb$a3;
        bb$a bb$a4;
        SHUTDOWN = bb$a4 = new bb$a("SHUTDOWN", 0);
        int n10 = 1;
        ONEPASS = bb$a3 = new bb$a("ONEPASS", n10);
        int n11 = 2;
        NORMAL = bb$a2 = new bb$a("NORMAL", n11);
        int n12 = 3;
        REQUESTING = bb$a = new bb$a("REQUESTING", n12);
        bb$a[] bb$aArray = new bb$a[4];
        bb$aArray[0] = bb$a4;
        bb$aArray[n10] = bb$a3;
        bb$aArray[n11] = bb$a2;
        bb$aArray[n12] = bb$a;
        a = bb$aArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private bb$a() {
        void var2_-1;
        void var1_-1;
    }

    public static bb$a valueOf(String string2) {
        return Enum.valueOf(bb$a.class, string2);
    }

    public static bb$a[] values() {
        return (bb$a[])a.clone();
    }
}

