/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class ia
extends Enum {
    public static final /* enum */ ia a;
    private static final /* synthetic */ ia[] a;
    public static final /* enum */ ia b;
    public static final /* enum */ ia c;
    private final int a;

    static {
        ia ia2;
        ia ia3;
        ia ia4;
        a = ia4 = new ia("RegIdExpired", 0, 0);
        int n10 = 1;
        b = ia3 = new ia("PackageUnregistered", n10, n10);
        int n11 = 2;
        c = ia2 = new ia("Init", n11, n11);
        ia[] iaArray = new ia[3];
        iaArray[0] = ia4;
        iaArray[n10] = ia3;
        iaArray[n11] = ia2;
        a = iaArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ia() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.a = var3_1;
    }

    public static ia a(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    return null;
                }
                return c;
            }
            return b;
        }
        return a;
    }

    public static ia valueOf(String string2) {
        return Enum.valueOf(ia.class, string2);
    }

    public static ia[] values() {
        return (ia[])a.clone();
    }

    public int a() {
        return this.a;
    }
}

