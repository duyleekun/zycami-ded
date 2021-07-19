/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.job.JobParameters
 *  android.app.job.JobService
 *  android.content.Context
 *  android.content.Intent
 */
package com.google.android.gms.measurement;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.measurement.internal.zzjg;
import com.google.android.gms.measurement.internal.zzjh;

public final class AppMeasurementJobService
extends JobService
implements zzjg {
    private zzjh zza;

    private final zzjh zzd() {
        zzjh zzjh2 = this.zza;
        if (zzjh2 == null) {
            this.zza = zzjh2 = new zzjh((Context)this);
        }
        return this.zza;
    }

    public void onCreate() {
        super.onCreate();
        this.zzd().zza();
    }

    public void onDestroy() {
        this.zzd().zzb();
        super.onDestroy();
    }

    public void onRebind(Intent intent) {
        this.zzd().zzh(intent);
    }

    public boolean onStartJob(JobParameters jobParameters) {
        this.zzd().zzg(jobParameters);
        return true;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    public boolean onUnbind(Intent intent) {
        this.zzd().zzf(intent);
        return true;
    }

    public final boolean zza(int n10) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public final void zzb(JobParameters jobParameters, boolean bl2) {
        this.jobFinished(jobParameters, false);
    }

    public final void zzc(Intent intent) {
    }
}

