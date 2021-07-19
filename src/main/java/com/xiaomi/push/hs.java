/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class hs
extends Enum {
    public static final /* enum */ hs a;
    private static final /* synthetic */ hs[] a;
    public static final /* enum */ hs b;
    private final int a;

    static {
        hs hs2;
        hs hs3;
        int n10 = 1;
        a = hs3 = new hs("MISC_CONFIG", 0, n10);
        int n11 = 2;
        b = hs2 = new hs("PLUGIN_CONFIG", n10, n11);
        hs[] hsArray = new hs[n11];
        hsArray[0] = hs3;
        hsArray[n10] = hs2;
        a = hsArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private hs() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.a = var3_1;
    }

    public static hs a(int n10) {
        int n11 = 1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 != n11) {
                return null;
            }
            return b;
        }
        return a;
    }

    public static hs valueOf(String string2) {
        return Enum.valueOf(hs.class, string2);
    }

    public static hs[] values() {
        return (hs[])a.clone();
    }

    public int a() {
        return this.a;
    }
}

