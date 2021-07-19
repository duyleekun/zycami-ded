/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Service
 *  android.app.job.JobParameters
 *  android.content.Context
 *  android.content.Intent
 *  android.os.IBinder
 */
package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.measurement.internal.zzjg;
import com.google.android.gms.measurement.internal.zzjh;

public final class AppMeasurementService
extends Service
implements zzjg {
    private zzjh zza;

    private final zzjh zzd() {
        zzjh zzjh2 = this.zza;
        if (zzjh2 == null) {
            this.zza = zzjh2 = new zzjh((Context)this);
        }
        return this.zza;
    }

    public IBinder onBind(Intent intent) {
        return this.zzd().zze(intent);
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

    public int onStartCommand(Intent intent, int n10, int n11) {
        this.zzd().zzc(intent, n10, n11);
        return 2;
    }

    public boolean onUnbind(Intent intent) {
        this.zzd().zzf(intent);
        return true;
    }

    public final boolean zza(int n10) {
        return this.stopSelfResult(n10);
    }

    public final void zzb(JobParameters object, boolean bl2) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public final void zzc(Intent intent) {
        WakefulBroadcastReceiver.completeWakefulIntent(intent);
    }
}

