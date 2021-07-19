/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.updatesdk.a.b.c.c;

public final class d$a
extends Enum {
    public static final /* enum */ d$a a;
    public static final /* enum */ d$a b;
    public static final /* enum */ d$a c;
    public static final /* enum */ d$a d;
    public static final /* enum */ d$a e;
    public static final /* enum */ d$a f;
    public static final /* enum */ d$a g;
    public static final /* enum */ d$a h;
    private static final /* synthetic */ d$a[] i;

    static {
        d$a d$a;
        d$a d$a2;
        d$a d$a3;
        d$a d$a4;
        d$a d$a5;
        d$a d$a6;
        d$a d$a7;
        d$a d$a8;
        a = d$a8 = new d$a("NORMAL", 0);
        int n10 = 1;
        b = d$a7 = new d$a("NO_NETWORK", n10);
        int n11 = 2;
        c = d$a6 = new d$a("JSON_ERROR", n11);
        int n12 = 3;
        d = d$a5 = new d$a("PARAM_ERROR", n12);
        int n13 = 4;
        e = d$a4 = new d$a("IO_EXCEPTION", n13);
        int n14 = 5;
        f = d$a3 = new d$a("CONNECT_EXCEPTION", n14);
        g = d$a2 = new d$a("UNKNOWN_EXCEPTION", 6);
        int n15 = 7;
        h = d$a = new d$a("NO_PROGUARD", n15);
        d$a[] d$aArray = new d$a[8];
        d$aArray[0] = d$a8;
        d$aArray[n10] = d$a7;
        d$aArray[n11] = d$a6;
        d$aArray[n12] = d$a5;
        d$aArray[n13] = d$a4;
        d$aArray[n14] = d$a3;
        d$aArray[6] = d$a2;
        d$aArray[n15] = d$a;
        i = d$aArray;
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
        return (d$a[])i.clone();
    }
}

