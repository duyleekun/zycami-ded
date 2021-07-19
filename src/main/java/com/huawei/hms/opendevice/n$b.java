/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.opendevice;

public final class n$b
extends Enum {
    public static final /* enum */ n$b a;
    public static final /* enum */ n$b b;
    public static final /* enum */ n$b c;
    public static final /* enum */ n$b d;
    public static final /* enum */ n$b e;
    public static final /* enum */ n$b f;
    public static final /* synthetic */ n$b[] g;
    public String h;

    static {
        n$b n$b;
        n$b n$b2;
        n$b n$b3;
        n$b n$b4;
        n$b n$b5;
        n$b n$b6;
        a = n$b6 = new n$b("IOS", 0, "ios");
        int n10 = 1;
        b = n$b5 = new n$b("ANDROID", n10, "android");
        int n11 = 2;
        c = n$b4 = new n$b("HARMONY", n11, "harmony");
        int n12 = 3;
        d = n$b3 = new n$b("WINDOWS", n12, "windows");
        int n13 = 4;
        e = n$b2 = new n$b("EMBED", n13, "embed");
        int n14 = 5;
        f = n$b = new n$b("OTHERS", n14, "others");
        n$b[] n$bArray = new n$b[6];
        n$bArray[0] = n$b6;
        n$bArray[n10] = n$b5;
        n$bArray[n11] = n$b4;
        n$bArray[n12] = n$b3;
        n$bArray[n13] = n$b2;
        n$bArray[n14] = n$b;
        g = n$bArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public n$b() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.h = var3_1;
    }

    public static n$b valueOf(String string2) {
        return Enum.valueOf(n$b.class, string2);
    }

    public static n$b[] values() {
        return (n$b[])g.clone();
    }

    public String a() {
        return this.h;
    }
}

