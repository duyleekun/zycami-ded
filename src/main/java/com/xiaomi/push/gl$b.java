/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class gl$b
extends Enum {
    public static final /* enum */ gl$b a;
    private static final /* synthetic */ gl$b[] a;
    public static final /* enum */ gl$b b;
    public static final /* enum */ gl$b c;
    public static final /* enum */ gl$b d;
    public static final /* enum */ gl$b e;
    public static final /* enum */ gl$b f;
    public static final /* enum */ gl$b g;
    public static final /* enum */ gl$b h;

    static {
        gl$b gl$b;
        gl$b gl$b2;
        gl$b gl$b3;
        gl$b gl$b4;
        gl$b gl$b5;
        gl$b gl$b6;
        gl$b gl$b7;
        gl$b gl$b8;
        a = gl$b8 = new gl$b("available", 0);
        int n10 = 1;
        b = gl$b7 = new gl$b("unavailable", n10);
        int n11 = 2;
        c = gl$b6 = new gl$b("subscribe", n11);
        int n12 = 3;
        d = gl$b5 = new gl$b("subscribed", n12);
        int n13 = 4;
        e = gl$b4 = new gl$b("unsubscribe", n13);
        int n14 = 5;
        f = gl$b3 = new gl$b("unsubscribed", n14);
        g = gl$b2 = new gl$b("error", 6);
        int n15 = 7;
        h = gl$b = new gl$b("probe", n15);
        gl$b[] gl$bArray = new gl$b[8];
        gl$bArray[0] = gl$b8;
        gl$bArray[n10] = gl$b7;
        gl$bArray[n11] = gl$b6;
        gl$bArray[n12] = gl$b5;
        gl$bArray[n13] = gl$b4;
        gl$bArray[n14] = gl$b3;
        gl$bArray[6] = gl$b2;
        gl$bArray[n15] = gl$b;
        a = gl$bArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private gl$b() {
        void var2_-1;
        void var1_-1;
    }

    public static gl$b valueOf(String string2) {
        return Enum.valueOf(gl$b.class, string2);
    }

    public static gl$b[] values() {
        return (gl$b[])a.clone();
    }
}

