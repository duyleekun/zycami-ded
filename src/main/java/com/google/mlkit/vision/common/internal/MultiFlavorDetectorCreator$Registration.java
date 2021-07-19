/*
 * Decompiled with CFR 0.151.
 */
package com.google.mlkit.vision.common.internal;

import com.google.firebase.inject.Provider;

public class MultiFlavorDetectorCreator$Registration {
    private final Class zza;
    private final Provider zzb;
    private final int zzc;

    public MultiFlavorDetectorCreator$Registration(Class clazz, Provider provider) {
        this(clazz, provider, 100);
    }

    public MultiFlavorDetectorCreator$Registration(Class clazz, Provider provider, int n10) {
        this.zza = clazz;
        this.zzb = provider;
        this.zzc = n10;
    }

    public final Class zza() {
        return this.zza;
    }

    public final Provider zzb() {
        return this.zzb;
    }

    public final int zzc() {
        return this.zzc;
    }
}

