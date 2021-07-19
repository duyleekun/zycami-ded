/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.d;

public class l {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        d d10;
        int n12 = d.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            d10 = d.a;
            n11 = d10.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            d10 = d.b;
            n11 = d10.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            d10 = d.c;
            n11 = d10.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            d10 = d.d;
            n11 = d10.ordinal();
            nArray[n11] = n10 = 4;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

