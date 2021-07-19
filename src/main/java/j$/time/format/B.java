/*
 * Decompiled with CFR 0.151.
 */
package j$.time.format;

public final class B
extends Enum {
    public static final /* enum */ B a;
    public static final /* enum */ B b;
    public static final /* enum */ B c;
    public static final /* enum */ B d;
    private static final /* synthetic */ B[] e;

    static {
        B b10;
        B b11;
        B b12;
        B b13;
        a = b13 = new B("NORMAL", 0);
        int n10 = 1;
        b = b12 = new B("ALWAYS", n10);
        int n11 = 2;
        B b14 = new B("NEVER", n11);
        int n12 = 3;
        c = b11 = new B("NOT_NEGATIVE", n12);
        int n13 = 4;
        d = b10 = new B("EXCEEDS_PAD", n13);
        B[] bArray = new B[5];
        bArray[0] = b13;
        bArray[n10] = b12;
        bArray[n11] = b14;
        bArray[n12] = b11;
        bArray[n13] = b10;
        e = bArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private B() {
        void var2_-1;
        void var1_-1;
    }

    public static B valueOf(String string2) {
        return Enum.valueOf(B.class, string2);
    }

    public static B[] values() {
        return (B[])e.clone();
    }
}

