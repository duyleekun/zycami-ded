/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.framework;

public final class i$a
extends Enum {
    public static final /* enum */ i$a a;
    public static final /* enum */ i$a b;
    private static final /* synthetic */ i$a[] c;

    static {
        i$a i$a;
        i$a i$a2;
        a = i$a2 = new i$a("INITIALIZING", 0);
        int n10 = 1;
        b = i$a = new i$a("READY", n10);
        i$a[] i$aArray = new i$a[2];
        i$aArray[0] = i$a2;
        i$aArray[n10] = i$a;
        c = i$aArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private i$a() {
        void var2_-1;
        void var1_-1;
    }

    public static i$a valueOf(String string2) {
        return Enum.valueOf(i$a.class, string2);
    }

    public static i$a[] values() {
        return (i$a[])c.clone();
    }
}

