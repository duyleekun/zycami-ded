/*
 * Decompiled with CFR 0.151.
 */
package f.m2;

import kotlin.reflect.KVariance;

public final class u {
    public static final /* synthetic */ int[] a;

    static {
        int[] nArray = new int[KVariance.values().length];
        a = nArray;
        int n10 = KVariance.INVARIANT.ordinal();
        nArray[n10] = 1;
        n10 = KVariance.IN.ordinal();
        nArray[n10] = 2;
        n10 = KVariance.OUT.ordinal();
        nArray[n10] = 3;
    }
}

