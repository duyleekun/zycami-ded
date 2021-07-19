/*
 * Decompiled with CFR 0.151.
 */
package com.google.mlkit.common.sdkinternal;

import com.google.mlkit.common.sdkinternal.MlKitThreadPool;

public final class zzh
implements Runnable {
    private final Runnable zza;

    public zzh(Runnable runnable) {
        this.zza = runnable;
    }

    public final void run() {
        MlKitThreadPool.zza(this.zza);
    }
}

