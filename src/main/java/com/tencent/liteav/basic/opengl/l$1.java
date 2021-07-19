/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.basic.opengl;

import com.tencent.liteav.basic.opengl.k;

public class l$1 {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        k k10;
        int n12 = k.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            k10 = k.b;
            n11 = k10.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            k10 = k.c;
            n11 = k10.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            k10 = k.d;
            n11 = k10.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            k10 = k.a;
            n11 = k10.ordinal();
            nArray[n11] = n10 = 4;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

