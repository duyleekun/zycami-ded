/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.location.e;

public final class h$b
extends Enum {
    public static final /* enum */ h$b a;
    public static final /* enum */ h$b b;
    private static final /* synthetic */ h$b[] c;

    static {
        h$b h$b;
        h$b h$b2;
        a = h$b2 = new h$b("IS_MIX_MODE", 0);
        int n10 = 1;
        b = h$b = new h$b("IS_NOT_MIX_MODE", n10);
        h$b[] h$bArray = new h$b[2];
        h$bArray[0] = h$b2;
        h$bArray[n10] = h$b;
        c = h$bArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private h$b() {
        void var2_-1;
        void var1_-1;
    }

    public static h$b valueOf(String string2) {
        return Enum.valueOf(h$b.class, string2);
    }

    public static h$b[] values() {
        return (h$b[])c.clone();
    }
}

