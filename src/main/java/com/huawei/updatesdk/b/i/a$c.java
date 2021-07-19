/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.updatesdk.b.i;

public final class a$c
extends Enum {
    public static final /* enum */ a$c a;
    public static final /* enum */ a$c b;
    private static final /* synthetic */ a$c[] c;

    static {
        a$c a$c;
        a$c a$c2;
        a = a$c2 = new a$c("CONFIRM", 0);
        int n10 = 1;
        b = a$c = new a$c("CANCEL", n10);
        a$c[] a$cArray = new a$c[2];
        a$cArray[0] = a$c2;
        a$cArray[n10] = a$c;
        c = a$cArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private a$c() {
        void var2_-1;
        void var1_-1;
    }

    public static a$c valueOf(String string2) {
        return Enum.valueOf(a$c.class, string2);
    }

    public static a$c[] values() {
        return (a$c[])c.clone();
    }
}

