/*
 * Decompiled with CFR 0.151.
 */
package com.google.mlkit.common.sdkinternal;

import com.google.mlkit.common.sdkinternal.zzo;
import java.util.concurrent.Executor;

public final class TaskQueue$zzb {
    public final Executor zza;
    public final Runnable zzb;

    private TaskQueue$zzb(Executor executor, Runnable runnable) {
        this.zza = executor;
        this.zzb = runnable;
    }

    public /* synthetic */ TaskQueue$zzb(Executor executor, Runnable runnable, zzo zzo2) {
        this(executor, runnable);
    }
}

