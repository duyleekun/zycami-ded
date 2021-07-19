/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.BackpressureOverflowStrategy;

public class FlowableOnBackpressureBufferStrategy$a {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        BackpressureOverflowStrategy backpressureOverflowStrategy;
        int n12 = BackpressureOverflowStrategy.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            backpressureOverflowStrategy = BackpressureOverflowStrategy.DROP_LATEST;
            n11 = backpressureOverflowStrategy.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            backpressureOverflowStrategy = BackpressureOverflowStrategy.DROP_OLDEST;
            n11 = backpressureOverflowStrategy.ordinal();
            nArray[n11] = n10 = 2;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

