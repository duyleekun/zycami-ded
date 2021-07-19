/*
 * Decompiled with CFR 0.151.
 */
package com.mob.commons;

import com.mob.commons.InternationalDomain;

public class j$1 {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        InternationalDomain internationalDomain;
        int n12 = InternationalDomain.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            internationalDomain = InternationalDomain.JP;
            n11 = internationalDomain.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            internationalDomain = InternationalDomain.US;
            n11 = internationalDomain.ordinal();
            nArray[n11] = n10 = 2;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

