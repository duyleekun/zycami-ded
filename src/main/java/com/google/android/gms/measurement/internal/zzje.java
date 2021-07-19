/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.job.JobParameters
 */
package com.google.android.gms.measurement.internal;

import android.app.job.JobParameters;
import com.google.android.gms.measurement.internal.zzei;
import com.google.android.gms.measurement.internal.zzjh;

public final class zzje
implements Runnable {
    private final zzjh zza;
    private final zzei zzb;
    private final JobParameters zzc;

    public zzje(zzjh zzjh2, zzei zzei2, JobParameters jobParameters) {
        this.zza = zzjh2;
        this.zzb = zzei2;
        this.zzc = jobParameters;
    }

    public final void run() {
        zzjh zzjh2 = this.zza;
        zzei zzei2 = this.zzb;
        JobParameters jobParameters = this.zzc;
        zzjh2.zzi(zzei2, jobParameters);
    }
}

