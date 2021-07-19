/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.location.e;

public final class h$c
extends Enum {
    public static final /* enum */ h$c a;
    public static final /* enum */ h$c b;
    public static final /* enum */ h$c c;
    public static final /* enum */ h$c d;
    public static final /* enum */ h$c e;
    private static final /* synthetic */ h$c[] f;

    static {
        h$c h$c;
        h$c h$c2;
        h$c h$c3;
        h$c h$c4;
        h$c h$c5;
        a = h$c5 = new h$c("NETWORK_UNKNOWN", 0);
        int n10 = 1;
        b = h$c4 = new h$c("NETWORK_WIFI", n10);
        int n11 = 2;
        c = h$c3 = new h$c("NETWORK_2G", n11);
        int n12 = 3;
        d = h$c2 = new h$c("NETWORK_3G", n12);
        int n13 = 4;
        e = h$c = new h$c("NETWORK_4G", n13);
        h$c[] h$cArray = new h$c[5];
        h$cArray[0] = h$c5;
        h$cArray[n10] = h$c4;
        h$cArray[n11] = h$c3;
        h$cArray[n12] = h$c2;
        h$cArray[n13] = h$c;
        f = h$cArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private h$c() {
        void var2_-1;
        void var1_-1;
    }

    public static h$c valueOf(String string2) {
        return Enum.valueOf(h$c.class, string2);
    }

    public static h$c[] values() {
        return (h$c[])f.clone();
    }
}

