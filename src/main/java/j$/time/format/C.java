/*
 * Decompiled with CFR 0.151.
 */
package j$.time.format;

public final class C
extends Enum {
    public static final /* enum */ C b;
    public static final /* enum */ C c;
    public static final /* enum */ C d;
    public static final /* enum */ C e;
    public static final /* enum */ C f;
    public static final /* enum */ C g;
    private static final /* synthetic */ C[] h;
    private final int a;

    static {
        C c10;
        C c11;
        C c12;
        C c13;
        C c14;
        C c15;
        int n10 = 2;
        b = c15 = new C("FULL", 0, n10, 0);
        int n11 = 1;
        c = c14 = new C("FULL_STANDALONE", n11, 32770, 0);
        d = c13 = new C("SHORT", n10, n11, n11);
        int n12 = 3;
        e = c12 = new C("SHORT_STANDALONE", n12, 32769, n11);
        int n13 = 4;
        f = c11 = new C("NARROW", n13, n13, n11);
        int n14 = 5;
        g = c10 = new C("NARROW_STANDALONE", n14, 32772, n11);
        C[] cArray = new C[6];
        cArray[0] = c15;
        cArray[n11] = c14;
        cArray[n10] = c13;
        cArray[n12] = c12;
        cArray[n13] = c11;
        cArray[n14] = c10;
        h = cArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private C() {
        void var4_-1;
        void var1_-1;
        this.a = var4_-1;
    }

    public static C valueOf(String string2) {
        return Enum.valueOf(C.class, string2);
    }

    public static C[] values() {
        return (C[])h.clone();
    }

    int m() {
        return this.a;
    }
}

