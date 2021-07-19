/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.hatool;

import com.huawei.hms.hatool.w0;

public class b1$a {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        w0 w02;
        int n12 = w0.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            w02 = w0.c;
            n11 = w02.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            w02 = w0.a;
            n11 = w02.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            w02 = w0.b;
            n11 = w02.ordinal();
            nArray[n11] = n10 = 3;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

