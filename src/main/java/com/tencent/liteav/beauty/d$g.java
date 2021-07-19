/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.beauty;

public final class d$g
extends Enum {
    public static final /* enum */ d$g a;
    public static final /* enum */ d$g b;
    private static final /* synthetic */ d$g[] c;

    static {
        d$g d$g;
        d$g d$g2;
        a = d$g2 = new d$g("TXE_FILL_MODE_SCALL_TO_FILL", 0);
        int n10 = 1;
        b = d$g = new d$g("TXE_FILL_MODE_SCALL_ASPECT_FILL", n10);
        d$g[] d$gArray = new d$g[2];
        d$gArray[0] = d$g2;
        d$gArray[n10] = d$g;
        c = d$gArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private d$g() {
        void var2_-1;
        void var1_-1;
    }

    public static d$g valueOf(String string2) {
        return Enum.valueOf(d$g.class, string2);
    }

    public static d$g[] values() {
        return (d$g[])c.clone();
    }
}

