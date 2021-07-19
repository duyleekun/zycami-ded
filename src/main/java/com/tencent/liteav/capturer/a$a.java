/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.capturer;

public final class a$a
extends Enum {
    public static final /* enum */ a$a a;
    public static final /* enum */ a$a b;
    public static final /* enum */ a$a c;
    public static final /* enum */ a$a d;
    public static final /* enum */ a$a e;
    public static final /* enum */ a$a f;
    public static final /* enum */ a$a g;
    public static final /* enum */ a$a h;
    public static final /* enum */ a$a i;
    private static final /* synthetic */ a$a[] j;
    private final int mHeight;
    private final int mWidth;

    static {
        a$a a$a;
        a$a a$a2;
        a$a a$a3;
        a$a a$a4;
        a$a a$a5;
        a$a a$a6;
        a$a a$a7;
        a$a a$a8;
        a$a a$a9;
        int n10 = -1;
        a = a$a9 = new a$a("RESOLUTION_INVALID", 0, n10, n10);
        int n11 = 1;
        int n12 = 320;
        b = a$a8 = new a$a("RESOLUTION_180_320", n11, 180, n12);
        int n13 = 2;
        int n14 = 480;
        c = a$a7 = new a$a("RESOLUTION_270_480", n13, 270, n14);
        d = a$a6 = new a$a("RESOLUTION_320_480", 3, n12, n14);
        e = a$a5 = new a$a("RESOLUTION_360_640", 4, 360, 640);
        f = a$a4 = new a$a("RESOLUTION_540_960", 5, 540, 960);
        g = a$a3 = new a$a("RESOLUTION_720_1280", 6, 720, 1280);
        int n15 = 1080;
        n14 = 1920;
        h = a$a2 = new a$a("RESOLUTION_1080_1920", 7, n15, n14);
        int n16 = 8;
        i = a$a = new a$a("RESOLUTION_HIGHEST", n16, n15, n14);
        a$a[] a$aArray = new a$a[9];
        a$aArray[0] = a$a9;
        a$aArray[n11] = a$a8;
        a$aArray[n13] = a$a7;
        a$aArray[3] = a$a6;
        a$aArray[4] = a$a5;
        a$aArray[5] = a$a4;
        a$aArray[6] = a$a3;
        a$aArray[7] = a$a2;
        a$aArray[n16] = a$a;
        j = a$aArray;
    }

    /*
     * WARNING - void declaration
     */
    private a$a() {
        void var4_2;
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.mWidth = var3_1;
        this.mHeight = var4_2;
    }

    private int a() {
        return this.mWidth;
    }

    public static /* synthetic */ int a(a$a a$a) {
        return a$a.a();
    }

    private int b() {
        return this.mHeight;
    }

    public static /* synthetic */ int b(a$a a$a) {
        return a$a.b();
    }

    public static a$a valueOf(String string2) {
        return Enum.valueOf(a$a.class, string2);
    }

    public static a$a[] values() {
        return (a$a[])j.clone();
    }
}

