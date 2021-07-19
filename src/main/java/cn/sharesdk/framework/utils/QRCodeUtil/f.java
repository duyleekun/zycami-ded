/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.framework.utils.QRCodeUtil;

public final class f
extends Enum {
    public static final /* enum */ f a;
    public static final /* enum */ f b;
    public static final /* enum */ f c;
    public static final /* enum */ f d;
    private static final f[] e;
    private static final /* synthetic */ f[] g;
    private final int f;

    static {
        f f10;
        f f11;
        f f12;
        f f13;
        int n10 = 1;
        a = f13 = new f("L", 0, n10);
        b = f12 = new f("M", n10, 0);
        int n11 = 2;
        int n12 = 3;
        c = f11 = new f("Q", n11, n12);
        d = f10 = new f("H", n12, n11);
        int n13 = 4;
        f[] fArray = new f[n13];
        fArray[0] = f13;
        fArray[n10] = f12;
        fArray[n11] = f11;
        fArray[n12] = f10;
        g = fArray;
        f[] fArray2 = new f[n13];
        fArray2[0] = f12;
        fArray2[n10] = f13;
        fArray2[n11] = f10;
        fArray2[n12] = f11;
        e = fArray2;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private f() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.f = var3_1;
    }

    public static f valueOf(String string2) {
        return Enum.valueOf(f.class, string2);
    }

    public static f[] values() {
        return (f[])g.clone();
    }

    public int a() {
        return this.f;
    }
}

