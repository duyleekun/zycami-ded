/*
 * Decompiled with CFR 0.151.
 */
package com.google.mlkit.common.sdkinternal;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.mlkit.common.sdkinternal.MLTaskExecutor;
import java.util.concurrent.Callable;

public final class zzg
implements Runnable {
    private final Callable zza;
    private final TaskCompletionSource zzb;

    public zzg(Callable callable, TaskCompletionSource taskCompletionSource) {
        this.zza = callable;
        this.zzb = taskCompletionSource;
    }

    public final void run() {
        Callable callable = this.zza;
        TaskCompletionSource taskCompletionSource = this.zzb;
        MLTaskExecutor.zza(callable, taskCompletionSource);
    }
}

