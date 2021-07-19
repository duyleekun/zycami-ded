/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.framework.b;

public final class b
extends Enum {
    public static final /* enum */ b a;
    public static final /* enum */ b b;
    private static final /* synthetic */ b[] c;

    static {
        b b10;
        b b11;
        a = b11 = new b("FINISH_SHARE", 0);
        int n10 = 1;
        b = b10 = new b("BEFORE_SHARE", n10);
        b[] bArray = new b[2];
        bArray[0] = b11;
        bArray[n10] = b10;
        c = bArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private b() {
        void var2_-1;
        void var1_-1;
    }

    public static b valueOf(String string2) {
        return Enum.valueOf(b.class, string2);
    }

    public static b[] values() {
        return (b[])c.clone();
    }
}

