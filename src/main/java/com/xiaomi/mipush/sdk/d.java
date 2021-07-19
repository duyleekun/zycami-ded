/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.mipush.sdk;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class d
extends Enum {
    public static final /* enum */ d a;
    private static final /* synthetic */ d[] a;
    public static final /* enum */ d b;
    public static final /* enum */ d c;
    public static final /* enum */ d d;
    private int a;

    static {
        d d10;
        d d11;
        d d12;
        d d13;
        int n10 = 1;
        a = d13 = new d("ASSEMBLE_PUSH_HUAWEI", 0, n10);
        int n11 = 2;
        b = d12 = new d("ASSEMBLE_PUSH_FCM", n10, n11);
        int n12 = 3;
        c = d11 = new d("ASSEMBLE_PUSH_COS", n11, n12);
        int n13 = 4;
        d = d10 = new d("ASSEMBLE_PUSH_FTOS", n12, n13);
        d[] dArray = new d[n13];
        dArray[0] = d13;
        dArray[n10] = d12;
        dArray[n11] = d11;
        dArray[n12] = d10;
        a = dArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private d() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.a = var3_1;
    }

    public static d valueOf(String string2) {
        return Enum.valueOf(d.class, string2);
    }

    public static d[] values() {
        return (d[])a.clone();
    }
}

