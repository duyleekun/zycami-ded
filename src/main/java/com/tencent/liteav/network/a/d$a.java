/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.network.a;

public final class d$a
extends Enum {
    public static final /* enum */ d$a a;
    public static final /* enum */ d$a b;
    public static final /* enum */ d$a c;
    private static final /* synthetic */ d$a[] d;

    static {
        d$a d$a;
        d$a d$a2;
        d$a d$a3;
        a = d$a3 = new d$a("NO_NETWORK", 0);
        int n10 = 1;
        b = d$a2 = new d$a("WIFI", n10);
        int n11 = 2;
        c = d$a = new d$a("MOBILE", n11);
        d$a[] d$aArray = new d$a[3];
        d$aArray[0] = d$a3;
        d$aArray[n10] = d$a2;
        d$aArray[n11] = d$a;
        d = d$aArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private d$a() {
        void var2_-1;
        void var1_-1;
    }

    public static d$a valueOf(String string2) {
        return Enum.valueOf(d$a.class, string2);
    }

    public static d$a[] values() {
        return (d$a[])d.clone();
    }
}

