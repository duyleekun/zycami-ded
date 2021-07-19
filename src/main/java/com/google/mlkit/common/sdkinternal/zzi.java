/*
 * Decompiled with CFR 0.151.
 */
package com.google.mlkit.common.sdkinternal;

import com.google.mlkit.common.sdkinternal.MlKitThreadPool;
import java.util.concurrent.ThreadFactory;

public final class zzi
implements ThreadFactory {
    private final MlKitThreadPool zza;

    public zzi(MlKitThreadPool mlKitThreadPool) {
        this.zza = mlKitThreadPool;
    }

    public final Thread newThread(Runnable runnable) {
        return this.zza.zzb(runnable);
    }
}

