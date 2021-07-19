/*
 * Decompiled with CFR 0.151.
 */
package com.google.mlkit.common.sdkinternal;

import com.google.android.gms.internal.mlkit_common.zzan;
import com.google.mlkit.common.sdkinternal.TaskQueue;
import com.google.mlkit.common.sdkinternal.TaskQueue$zza;

public final class zzp
implements Runnable {
    private final TaskQueue zza;
    private final Runnable zzb;

    public zzp(TaskQueue taskQueue, Runnable runnable) {
        this.zza = taskQueue;
        this.zzb = runnable;
    }

    public final void run() {
        TaskQueue taskQueue = this.zza;
        Runnable runnable = this.zzb;
        TaskQueue$zza taskQueue$zza = new TaskQueue$zza(taskQueue, null);
        try {
            runnable.run();
            taskQueue$zza.close();
            return;
        }
        catch (Throwable throwable) {
            try {
                taskQueue$zza.close();
            }
            catch (Throwable throwable2) {
                zzan.zza(throwable, throwable2);
            }
            throw throwable;
        }
    }
}

