/*
 * Decompiled with CFR 0.151.
 */
package com.google.mlkit.common.model;

import com.google.firebase.inject.Provider;

public class RemoteModelManager$RemoteModelManagerRegistration {
    private final Class zza;
    private final Provider zzb;

    public RemoteModelManager$RemoteModelManagerRegistration(Class clazz, Provider provider) {
        this.zza = clazz;
        this.zzb = provider;
    }

    public final Class zza() {
        return this.zza;
    }

    public final Provider zzb() {
        return this.zzb;
    }
}

