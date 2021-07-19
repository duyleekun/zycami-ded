/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.basic.a;

public final class c
extends Enum {
    public static final /* enum */ c a;
    public static final /* enum */ c b;
    public static final /* enum */ c c;
    public static final /* enum */ c d;
    public static final /* enum */ c e;
    public static final /* enum */ c f;
    public static final /* enum */ c g;
    public static final /* enum */ c h;
    public static final /* enum */ c i;
    public static final /* enum */ c j;
    public static final /* enum */ c k;
    public static final /* enum */ c l;
    public static final /* enum */ c m;
    public static final /* enum */ c n;
    public static final /* enum */ c o;
    public static final /* enum */ c p;
    public static final /* enum */ c q;
    public static final /* enum */ c r;
    public static final /* enum */ c s;
    public static final /* enum */ c t;
    public static final /* enum */ c u;
    public static final /* enum */ c v;
    public static final /* enum */ c w;
    public static final /* enum */ c x;
    private static final /* synthetic */ c[] y;

    static {
        c c10;
        c c11;
        c c12;
        c c13;
        c c14;
        c c15;
        c c16;
        c c17;
        c c18;
        c c19;
        c c20;
        c c21;
        c c22;
        c c23;
        c c24;
        a = c24 = new c("RESOLUTION_TYPE_INVALID", 0);
        b = c23 = new c("RESOLUTION_TYPE_360_640", 1);
        c = c22 = new c("RESOLUTION_TYPE_540_960", 2);
        d = c21 = new c("RESOLUTION_TYPE_720_1280", 3);
        e = c20 = new c("RESOLUTION_TYPE_640_360", 4);
        f = c19 = new c("RESOLUTION_TYPE_960_540", 5);
        g = c18 = new c("RESOLUTION_TYPE_1280_720", 6);
        h = c17 = new c("RESOLUTION_TYPE_320_480", 7);
        i = c16 = new c("RESOLUTION_TYPE_180_320", 8);
        j = c15 = new c("RESOLUTION_TYPE_270_480", 9);
        k = c14 = new c("RESOLUTION_TYPE_320_180", 10);
        l = c13 = new c("RESOLUTION_TYPE_480_270", 11);
        m = c12 = new c("RESOLUTION_TYPE_240_320", 12);
        n = c11 = new c("RESOLUTION_TYPE_360_480", 13);
        c c25 = c11;
        c[] cArray = new c("RESOLUTION_TYPE_480_640", 14);
        o = cArray;
        c[] cArray2 = cArray;
        p = c10 = new c("RESOLUTION_TYPE_320_240", 15);
        c c26 = c10;
        q = c11 = new c("RESOLUTION_TYPE_480_360", 16);
        c c27 = c11;
        cArray = new c("RESOLUTION_TYPE_640_480", 17);
        r = cArray;
        c[] cArray3 = cArray;
        s = c10 = new c("RESOLUTION_TYPE_480_480", 18);
        c c28 = c10;
        t = c11 = new c("RESOLUTION_TYPE_270_270", 19);
        c c29 = c11;
        cArray = new c("RESOLUTION_TYPE_160_160", 20);
        u = cArray;
        c[] cArray4 = cArray;
        v = c10 = new c("RESOLUTION_TYPE_120_120", 21);
        c c30 = c10;
        w = c11 = new c("RESOLUTION_TYPE_1080_1920", 22);
        x = c10 = new c("RESOLUTION_TYPE_1920_1080", 23);
        cArray = new c[]{c24, c23, c22, c21, c20, c19, c18, c17, c16, c15, c14, c13, c12, c25, cArray2, c26, c27, cArray3, c28, c29, cArray4, c30, c11, c10};
        y = cArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private c() {
        void var2_-1;
        void var1_-1;
    }

    public static c valueOf(String string2) {
        return Enum.valueOf(c.class, string2);
    }

    public static c[] values() {
        return (c[])y.clone();
    }
}

