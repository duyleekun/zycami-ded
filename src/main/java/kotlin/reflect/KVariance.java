/*
 * Decompiled with CFR 0.151.
 */
package kotlin.reflect;

public final class KVariance
extends Enum {
    public static final /* enum */ KVariance IN;
    public static final /* enum */ KVariance INVARIANT;
    public static final /* enum */ KVariance OUT;
    private static final /* synthetic */ KVariance[] a;

    static {
        KVariance kVariance;
        KVariance[] kVarianceArray = new KVariance[3];
        INVARIANT = kVariance = new KVariance("INVARIANT", 0);
        kVarianceArray[0] = kVariance;
        int n10 = 1;
        IN = kVariance = new KVariance("IN", n10);
        kVarianceArray[n10] = kVariance;
        n10 = 2;
        OUT = kVariance = new KVariance("OUT", n10);
        kVarianceArray[n10] = kVariance;
        a = kVarianceArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private KVariance() {
        void var2_-1;
        void var1_-1;
    }

    public static KVariance valueOf(String string2) {
        return Enum.valueOf(KVariance.class, string2);
    }

    public static KVariance[] values() {
        return (KVariance[])a.clone();
    }
}

