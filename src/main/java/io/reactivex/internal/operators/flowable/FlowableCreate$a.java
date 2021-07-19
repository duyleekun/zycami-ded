/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.BackpressureStrategy;

public class FlowableCreate$a {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        BackpressureStrategy backpressureStrategy;
        int n12 = BackpressureStrategy.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            backpressureStrategy = BackpressureStrategy.MISSING;
            n11 = backpressureStrategy.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            backpressureStrategy = BackpressureStrategy.ERROR;
            n11 = backpressureStrategy.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            backpressureStrategy = BackpressureStrategy.DROP;
            n11 = backpressureStrategy.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            backpressureStrategy = BackpressureStrategy.LATEST;
            n11 = backpressureStrategy.ordinal();
            nArray[n11] = n10 = 4;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

