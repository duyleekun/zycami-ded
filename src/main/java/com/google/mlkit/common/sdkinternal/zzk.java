/*
 * Decompiled with CFR 0.151.
 */
package com.google.mlkit.common.sdkinternal;

import com.google.mlkit.common.sdkinternal.ModelResource;

public final class zzk
implements Runnable {
    private final ModelResource zza;

    public zzk(ModelResource modelResource) {
        this.zza = modelResource;
    }

    public final void run() {
        this.zza.zza();
    }
}

