/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class gl$a
extends Enum {
    public static final /* enum */ gl$a a;
    private static final /* synthetic */ gl$a[] a;
    public static final /* enum */ gl$a b;
    public static final /* enum */ gl$a c;
    public static final /* enum */ gl$a d;
    public static final /* enum */ gl$a e;

    static {
        gl$a gl$a;
        gl$a gl$a2;
        gl$a gl$a3;
        gl$a gl$a4;
        gl$a gl$a5;
        a = gl$a5 = new gl$a("chat", 0);
        int n10 = 1;
        b = gl$a4 = new gl$a("available", n10);
        int n11 = 2;
        c = gl$a3 = new gl$a("away", n11);
        int n12 = 3;
        d = gl$a2 = new gl$a("xa", n12);
        int n13 = 4;
        e = gl$a = new gl$a("dnd", n13);
        gl$a[] gl$aArray = new gl$a[5];
        gl$aArray[0] = gl$a5;
        gl$aArray[n10] = gl$a4;
        gl$aArray[n11] = gl$a3;
        gl$aArray[n12] = gl$a2;
        gl$aArray[n13] = gl$a;
        a = gl$aArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private gl$a() {
        void var2_-1;
        void var1_-1;
    }

    public static gl$a valueOf(String string2) {
        return Enum.valueOf(gl$a.class, string2);
    }

    public static gl$a[] values() {
        return (gl$a[])a.clone();
    }
}

