/*
 * Decompiled with CFR 0.151.
 */
package com.google.mlkit.common.sdkinternal;

import com.google.mlkit.common.sdkinternal.MLTaskExecutor;
import java.util.concurrent.Executor;

public final class MLTaskExecutor$zza
extends Enum
implements Executor {
    public static final /* enum */ MLTaskExecutor$zza zza;
    private static final /* synthetic */ MLTaskExecutor$zza[] zzb;

    static {
        MLTaskExecutor$zza mLTaskExecutor$zza;
        zza = mLTaskExecutor$zza = new MLTaskExecutor$zza("INSTANCE", 0);
        MLTaskExecutor$zza[] mLTaskExecutor$zzaArray = new MLTaskExecutor$zza[]{mLTaskExecutor$zza};
        zzb = mLTaskExecutor$zzaArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private MLTaskExecutor$zza() {
        void var1_-1;
    }

    public static MLTaskExecutor$zza[] values() {
        return (MLTaskExecutor$zza[])zzb.clone();
    }

    public final void execute(Runnable runnable) {
        MLTaskExecutor.zza(MLTaskExecutor.getInstance()).post(runnable);
    }
}

