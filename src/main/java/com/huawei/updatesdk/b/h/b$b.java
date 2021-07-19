/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.updatesdk.b.h;

public final class b$b
extends Enum {
    public static final /* enum */ b$b a;
    public static final /* enum */ b$b b;
    public static final /* enum */ b$b c;
    private static final /* synthetic */ b$b[] d;

    static {
        b$b b$b;
        b$b b$b2;
        b$b b$b3;
        a = b$b3 = new b$b("NOT_INSTALLED", 0);
        int n10 = 1;
        b = b$b2 = new b$b("INSTALLED", n10);
        int n11 = 2;
        c = b$b = new b$b("INSTALLED_LOWCODE", n11);
        b$b[] b$bArray = new b$b[3];
        b$bArray[0] = b$b3;
        b$bArray[n10] = b$b2;
        b$bArray[n11] = b$b;
        d = b$bArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private b$b() {
        void var2_-1;
        void var1_-1;
    }

    public static b$b valueOf(String string2) {
        return Enum.valueOf(b$b.class, string2);
    }

    public static b$b[] values() {
        return (b$b[])d.clone();
    }
}

