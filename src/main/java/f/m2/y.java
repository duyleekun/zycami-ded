/*
 * Decompiled with CFR 0.151.
 */
package f.m2;

import kotlin.reflect.KVariance;

public final class y {
    public static final /* synthetic */ int[] a;
    public static final /* synthetic */ int[] b;

    static {
        int n10;
        int n11;
        int n12;
        int[] nArray = new int[KVariance.values().length];
        a = nArray;
        KVariance kVariance = KVariance.IN;
        int n13 = kVariance.ordinal();
        nArray[n13] = n12 = 1;
        KVariance kVariance2 = KVariance.INVARIANT;
        int n14 = kVariance2.ordinal();
        nArray[n14] = n11 = 2;
        KVariance kVariance3 = KVariance.OUT;
        int n15 = kVariance3.ordinal();
        nArray[n15] = n10 = 3;
        nArray = new int[KVariance.values().length];
        b = nArray;
        n13 = kVariance2.ordinal();
        nArray[n13] = n12;
        int n16 = kVariance.ordinal();
        nArray[n16] = n11;
        n16 = kVariance3.ordinal();
        nArray[n16] = n10;
    }
}

