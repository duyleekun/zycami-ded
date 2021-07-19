/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push.service;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class ap$c
extends Enum {
    public static final /* enum */ ap$c a;
    private static final /* synthetic */ ap$c[] a;
    public static final /* enum */ ap$c b;
    public static final /* enum */ ap$c c;

    static {
        ap$c ap$c;
        ap$c ap$c2;
        ap$c ap$c3;
        a = ap$c3 = new ap$c("unbind", 0);
        int n10 = 1;
        b = ap$c2 = new ap$c("binding", n10);
        int n11 = 2;
        c = ap$c = new ap$c("binded", n11);
        ap$c[] ap$cArray = new ap$c[3];
        ap$cArray[0] = ap$c3;
        ap$cArray[n10] = ap$c2;
        ap$cArray[n11] = ap$c;
        a = ap$cArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ap$c() {
        void var2_-1;
        void var1_-1;
    }

    public static ap$c valueOf(String string2) {
        return Enum.valueOf(ap$c.class, string2);
    }

    public static ap$c[] values() {
        return (ap$c[])a.clone();
    }
}

