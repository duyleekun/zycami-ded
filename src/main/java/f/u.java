/*
 * Decompiled with CFR 0.151.
 */
package f;

import kotlin.LazyThreadSafetyMode;

public final class u {
    public static final /* synthetic */ int[] a;

    static {
        int[] nArray = new int[LazyThreadSafetyMode.values().length];
        a = nArray;
        int n10 = LazyThreadSafetyMode.SYNCHRONIZED.ordinal();
        nArray[n10] = 1;
        n10 = LazyThreadSafetyMode.PUBLICATION.ordinal();
        nArray[n10] = 2;
        n10 = LazyThreadSafetyMode.NONE.ordinal();
        nArray[n10] = 3;
    }
}

