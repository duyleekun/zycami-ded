/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.f;

import io.reactivex.parallel.ParallelFailureHandling;

public class h$a {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        ParallelFailureHandling parallelFailureHandling;
        int n12 = ParallelFailureHandling.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            parallelFailureHandling = ParallelFailureHandling.RETRY;
            n11 = parallelFailureHandling.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            parallelFailureHandling = ParallelFailureHandling.SKIP;
            n11 = parallelFailureHandling.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            parallelFailureHandling = ParallelFailureHandling.STOP;
            n11 = parallelFailureHandling.ordinal();
            nArray[n11] = n10 = 3;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

