/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.util.ErrorMode;

public class FlowableConcatMap$a {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        ErrorMode errorMode;
        int n12 = ErrorMode.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            errorMode = ErrorMode.BOUNDARY;
            n11 = errorMode.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            errorMode = ErrorMode.END;
            n11 = errorMode.ordinal();
            nArray[n11] = n10 = 2;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

