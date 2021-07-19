/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.basic.opengl;

public final class k
extends Enum {
    public static final /* enum */ k a;
    public static final /* enum */ k b;
    public static final /* enum */ k c;
    public static final /* enum */ k d;
    private static final /* synthetic */ k[] e;

    static {
        k k10;
        k k11;
        k k12;
        k k13;
        a = k13 = new k("NORMAL", 0);
        int n10 = 1;
        b = k12 = new k("ROTATION_90", n10);
        int n11 = 2;
        c = k11 = new k("ROTATION_180", n11);
        int n12 = 3;
        d = k10 = new k("ROTATION_270", n12);
        k[] kArray = new k[4];
        kArray[0] = k13;
        kArray[n10] = k12;
        kArray[n11] = k11;
        kArray[n12] = k10;
        e = kArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private k() {
        void var2_-1;
        void var1_-1;
    }

    public static k valueOf(String string2) {
        return Enum.valueOf(k.class, string2);
    }

    public static k[] values() {
        return (k[])e.clone();
    }
}

