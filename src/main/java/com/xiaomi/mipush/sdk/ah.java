/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.mipush.sdk;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class ah
extends Enum {
    public static final /* enum */ ah a;
    private static final /* synthetic */ ah[] a;
    public static final /* enum */ ah b;
    public static final /* enum */ ah c;
    public static final /* enum */ ah d;
    public static final /* enum */ ah e;
    public static final /* enum */ ah f;

    static {
        ah ah2;
        ah ah3;
        ah ah4;
        ah ah5;
        ah ah6;
        ah ah7;
        a = ah7 = new ah("HUAWEI", 0);
        int n10 = 1;
        b = ah6 = new ah("MEIZU", n10);
        int n11 = 2;
        c = ah5 = new ah("FCM", n11);
        int n12 = 3;
        d = ah4 = new ah("OPPO", n12);
        int n13 = 4;
        e = ah3 = new ah("VIVO", n13);
        int n14 = 5;
        f = ah2 = new ah("OTHER", n14);
        ah[] ahArray = new ah[6];
        ahArray[0] = ah7;
        ahArray[n10] = ah6;
        ahArray[n11] = ah5;
        ahArray[n12] = ah4;
        ahArray[n13] = ah3;
        ahArray[n14] = ah2;
        a = ahArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ah() {
        void var2_-1;
        void var1_-1;
    }

    public static ah valueOf(String string2) {
        return Enum.valueOf(ah.class, string2);
    }

    public static ah[] values() {
        return (ah[])a.clone();
    }
}

