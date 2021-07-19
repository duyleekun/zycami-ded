/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class ht
extends Enum {
    public static final /* enum */ ht a;
    private static final /* synthetic */ ht[] a;
    public static final /* enum */ ht b;
    public static final /* enum */ ht c;
    public static final /* enum */ ht d;
    private final int a;

    static {
        ht ht2;
        ht ht3;
        ht ht4;
        ht ht5;
        int n10 = 1;
        a = ht5 = new ht("INT", 0, n10);
        int n11 = 2;
        b = ht4 = new ht("LONG", n10, n11);
        int n12 = 3;
        c = ht3 = new ht("STRING", n11, n12);
        int n13 = 4;
        d = ht2 = new ht("BOOLEAN", n12, n13);
        ht[] htArray = new ht[n13];
        htArray[0] = ht5;
        htArray[n10] = ht4;
        htArray[n11] = ht3;
        htArray[n12] = ht2;
        a = htArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ht() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.a = var3_1;
    }

    public static ht a(int n10) {
        int n11 = 1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 != n11) {
                n11 = 3;
                if (n10 != n11) {
                    n11 = 4;
                    if (n10 != n11) {
                        return null;
                    }
                    return d;
                }
                return c;
            }
            return b;
        }
        return a;
    }

    public static ht valueOf(String string2) {
        return Enum.valueOf(ht.class, string2);
    }

    public static ht[] values() {
        return (ht[])a.clone();
    }
}

