/*
 * Decompiled with CFR 0.151.
 */
package com.geetest.sdk;

public final class af$a
extends Enum {
    public static final /* enum */ af$a FLUSH;
    public static final /* enum */ af$a OTHER;
    public static final /* enum */ af$a SEND;
    public static final /* enum */ af$a WRITE;
    private static final /* synthetic */ af$a[] a;

    static {
        af$a af$a;
        af$a af$a2;
        af$a af$a3;
        af$a af$a4;
        WRITE = af$a4 = new af$a("WRITE", 0);
        int n10 = 1;
        SEND = af$a3 = new af$a("SEND", n10);
        int n11 = 2;
        FLUSH = af$a2 = new af$a("FLUSH", n11);
        int n12 = 3;
        OTHER = af$a = new af$a("OTHER", n12);
        af$a[] af$aArray = new af$a[4];
        af$aArray[0] = af$a4;
        af$aArray[n10] = af$a3;
        af$aArray[n11] = af$a2;
        af$aArray[n12] = af$a;
        a = af$aArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private af$a() {
        void var2_-1;
        void var1_-1;
    }

    public static af$a valueOf(String string2) {
        return Enum.valueOf(af$a.class, string2);
    }

    public static af$a[] values() {
        return (af$a[])a.clone();
    }
}

