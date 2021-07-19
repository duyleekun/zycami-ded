/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.push;

public final class n
extends Enum {
    public static final /* enum */ n a;
    public static final /* enum */ n b;
    public static final /* enum */ n c;
    public static final /* enum */ n d;
    public static final /* synthetic */ n[] e;

    static {
        n n10;
        n n11;
        n n12;
        n n13;
        a = n13 = new n("STYLE_DEFAULT", 0);
        int n14 = 1;
        b = n12 = new n("STYLE_BIGTEXT", n14);
        int n15 = 2;
        c = n11 = new n("STYLE_BIGPICTURE", n15);
        int n16 = 3;
        d = n10 = new n("STYLE_INBOX", n16);
        n[] nArray = new n[4];
        nArray[0] = n13;
        nArray[n14] = n12;
        nArray[n15] = n11;
        nArray[n16] = n10;
        e = nArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public n() {
        void var2_-1;
        void var1_-1;
    }

    public static n valueOf(String string2) {
        return Enum.valueOf(n.class, string2);
    }

    public static n[] values() {
        return (n[])e.clone();
    }
}

