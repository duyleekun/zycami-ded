/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 */
package com.google.android.gms.tasks;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.tasks.zzb;
import java.util.concurrent.Executor;

public final class TaskExecutors$zza
implements Executor {
    private final Handler zza;

    public TaskExecutors$zza() {
        Looper looper = Looper.getMainLooper();
        zzb zzb2 = new zzb(looper);
        this.zza = zzb2;
    }

    public final void execute(Runnable runnable) {
        this.zza.post(runnable);
    }
}

