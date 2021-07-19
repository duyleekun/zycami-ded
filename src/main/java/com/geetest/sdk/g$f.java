/*
 * Decompiled with CFR 0.151.
 */
package com.geetest.sdk;

public final class g$f
extends Enum {
    public static final /* enum */ g$f DISMISS;
    public static final /* enum */ g$f INIT;
    public static final /* enum */ g$f NUMBER_ONE_CLOSE;
    public static final /* enum */ g$f SHOW_LOADING;
    public static final /* enum */ g$f SHOW_WEB;
    private static final /* synthetic */ g$f[] a;

    static {
        g$f g$f;
        g$f g$f2;
        g$f g$f3;
        g$f g$f4;
        g$f g$f5;
        NUMBER_ONE_CLOSE = g$f5 = new g$f("NUMBER_ONE_CLOSE", 0);
        int n10 = 1;
        SHOW_LOADING = g$f4 = new g$f("SHOW_LOADING", n10);
        int n11 = 2;
        SHOW_WEB = g$f3 = new g$f("SHOW_WEB", n11);
        int n12 = 3;
        DISMISS = g$f2 = new g$f("DISMISS", n12);
        int n13 = 4;
        INIT = g$f = new g$f("INIT", n13);
        g$f[] g$fArray = new g$f[5];
        g$fArray[0] = g$f5;
        g$fArray[n10] = g$f4;
        g$fArray[n11] = g$f3;
        g$fArray[n12] = g$f2;
        g$fArray[n13] = g$f;
        a = g$fArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private g$f() {
        void var2_-1;
        void var1_-1;
    }

    public static g$f valueOf(String string2) {
        return Enum.valueOf(g$f.class, string2);
    }

    public static g$f[] values() {
        return (g$f[])a.clone();
    }
}

