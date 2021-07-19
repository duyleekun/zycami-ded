/*
 * Decompiled with CFR 0.151.
 */
package com.google.mlkit.common.sdkinternal;

import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.mlkit.common.sdkinternal.ModelResource;
import java.util.concurrent.Callable;

public final class zzl
implements Runnable {
    private final ModelResource zza;
    private final CancellationToken zzb;
    private final CancellationTokenSource zzc;
    private final Callable zzd;
    private final TaskCompletionSource zze;

    public zzl(ModelResource modelResource, CancellationToken cancellationToken, CancellationTokenSource cancellationTokenSource, Callable callable, TaskCompletionSource taskCompletionSource) {
        this.zza = modelResource;
        this.zzb = cancellationToken;
        this.zzc = cancellationTokenSource;
        this.zzd = callable;
        this.zze = taskCompletionSource;
    }

    public final void run() {
        ModelResource modelResource = this.zza;
        CancellationToken cancellationToken = this.zzb;
        CancellationTokenSource cancellationTokenSource = this.zzc;
        Callable callable = this.zzd;
        TaskCompletionSource taskCompletionSource = this.zze;
        modelResource.zza(cancellationToken, cancellationTokenSource, callable, taskCompletionSource);
    }
}

