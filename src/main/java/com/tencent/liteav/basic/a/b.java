/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.basic.a;

public final class b
extends Enum {
    public static final /* enum */ b a;
    public static final /* enum */ b b;
    public static final /* enum */ b c;
    public static final /* enum */ b d;
    public static final /* enum */ b e;
    public static final /* enum */ b f;
    private static final /* synthetic */ b[] g;

    static {
        b b10;
        b b11;
        b b12;
        b b13;
        b b14;
        b b15;
        a = b15 = new b("UNKNOWN", 0);
        int n10 = 1;
        b = b14 = new b("I420", n10);
        int n11 = 2;
        c = b13 = new b("TEXTURE_2D", n11);
        int n12 = 3;
        d = b12 = new b("TEXTURE_EXTERNAL_OES", n12);
        int n13 = 4;
        e = b11 = new b("NV21", n13);
        int n14 = 5;
        f = b10 = new b("RGBA", n14);
        b[] bArray = new b[6];
        bArray[0] = b15;
        bArray[n10] = b14;
        bArray[n11] = b13;
        bArray[n12] = b12;
        bArray[n13] = b11;
        bArray[n14] = b10;
        g = bArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private b() {
        void var2_-1;
        void var1_-1;
    }

    public static b valueOf(String string2) {
        return Enum.valueOf(b.class, string2);
    }

    public static b[] values() {
        return (b[])g.clone();
    }
}

