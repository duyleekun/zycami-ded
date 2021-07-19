/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

public final class f {
    public static final int a;
    public static final int b;
    public static final int c;
    public static final int d;

    static {
        int n10 = 1;
        int n11 = 3;
        a = f.a(n10, n11);
        b = f.a(n10, 4);
        n10 = 2;
        c = f.a(n10, 0);
        d = f.a(n11, n10);
    }

    public static int a(int n10) {
        return n10 & 7;
    }

    public static int a(int n10, int n11) {
        return n10 << 3 | n11;
    }

    public static int b(int n10) {
        return n10 >>> 3;
    }
}

