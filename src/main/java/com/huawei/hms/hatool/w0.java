/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.hatool;

public final class w0
extends Enum {
    public static final /* enum */ w0 a;
    public static final /* enum */ w0 b;
    public static final /* enum */ w0 c;
    public static final /* enum */ w0 d;
    public static final /* synthetic */ w0[] e;

    static {
        w0 w02;
        w0 w03;
        w0 w04;
        w0 w05;
        a = w05 = new w0("IMEI", 0);
        int n10 = 1;
        b = w04 = new w0("UDID", n10);
        int n11 = 2;
        c = w03 = new w0("SN", n11);
        int n12 = 3;
        d = w02 = new w0("EMPTY", n12);
        w0[] w0Array = new w0[4];
        w0Array[0] = w05;
        w0Array[n10] = w04;
        w0Array[n11] = w03;
        w0Array[n12] = w02;
        e = w0Array;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public w0() {
        void var2_-1;
        void var1_-1;
    }

    public static w0 valueOf(String string2) {
        return Enum.valueOf(w0.class, string2);
    }

    public static w0[] values() {
        return (w0[])e.clone();
    }
}

