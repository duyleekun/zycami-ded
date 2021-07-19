/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.tasks;

import com.google.android.gms.tasks.Tasks$zza;
import com.google.android.gms.tasks.zzy;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class Tasks$zzb
implements Tasks$zza {
    private final CountDownLatch zza;

    private Tasks$zzb() {
        CountDownLatch countDownLatch;
        this.zza = countDownLatch = new CountDownLatch(1);
    }

    public /* synthetic */ Tasks$zzb(zzy zzy2) {
        this();
    }

    public final void onCanceled() {
        this.zza.countDown();
    }

    public final void onFailure(Exception exception) {
        this.zza.countDown();
    }

    public final void onSuccess(Object object) {
        this.zza.countDown();
    }

    public final void zza() {
        this.zza.await();
    }

    public final boolean zza(long l10, TimeUnit timeUnit) {
        return this.zza.await(l10, timeUnit);
    }
}

