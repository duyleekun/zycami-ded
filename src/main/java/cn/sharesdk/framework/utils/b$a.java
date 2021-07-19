/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.framework.utils;

public final class b$a
extends Enum {
    public static final /* enum */ b$a a;
    public static final /* enum */ b$a b;
    private static final /* synthetic */ b$a[] c;

    static {
        b$a b$a;
        b$a b$a2;
        a = b$a2 = new b$a("HMAC_SHA1", 0);
        int n10 = 1;
        b = b$a = new b$a("PLAINTEXT", n10);
        b$a[] b$aArray = new b$a[2];
        b$aArray[0] = b$a2;
        b$aArray[n10] = b$a;
        c = b$aArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private b$a() {
        void var2_-1;
        void var1_-1;
    }

    public static b$a valueOf(String string2) {
        return Enum.valueOf(b$a.class, string2);
    }

    public static b$a[] values() {
        return (b$a[])c.clone();
    }
}

