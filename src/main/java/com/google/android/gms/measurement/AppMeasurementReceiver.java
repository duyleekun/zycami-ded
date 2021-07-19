/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver$PendingResult
 *  android.content.Context
 *  android.content.Intent
 */
package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.measurement.internal.zzfb;
import com.google.android.gms.measurement.internal.zzfb$zza;

public final class AppMeasurementReceiver
extends WakefulBroadcastReceiver
implements zzfb$zza {
    private zzfb zza;

    public BroadcastReceiver.PendingResult doGoAsync() {
        return this.goAsync();
    }

    public void doStartService(Context context, Intent intent) {
        WakefulBroadcastReceiver.startWakefulService(context, intent);
    }

    public void onReceive(Context context, Intent intent) {
        zzfb zzfb2 = this.zza;
        if (zzfb2 == null) {
            this.zza = zzfb2 = new zzfb(this);
        }
        this.zza.zzb(context, intent);
    }
}

