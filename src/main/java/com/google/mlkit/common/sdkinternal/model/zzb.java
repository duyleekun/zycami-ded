/*
 * Decompiled with CFR 0.151.
 */
package com.google.mlkit.common.sdkinternal.model;

import com.google.mlkit.common.sdkinternal.ModelType;

public final class zzb {
    public static final /* synthetic */ int[] zza;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        ModelType modelType;
        int n12 = ModelType.values().length;
        int[] nArray = new int[n12];
        zza = nArray;
        try {
            modelType = ModelType.BASE;
            n11 = modelType.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = zza;
            modelType = ModelType.AUTOML;
            n11 = modelType.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = zza;
            modelType = ModelType.TRANSLATE;
            n11 = modelType.ordinal();
            nArray[n11] = n10 = 3;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

