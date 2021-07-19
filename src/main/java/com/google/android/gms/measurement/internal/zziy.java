/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 */
package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import com.google.android.gms.measurement.internal.zzja;
import com.google.android.gms.measurement.internal.zzjb;

public final class zziy
implements Runnable {
    public final /* synthetic */ zzja zza;

    public zziy(zzja zzja2) {
        this.zza = zzja2;
    }

    public final void run() {
        zzjb zzjb2 = this.zza.zza;
        Context context = zzjb2.zzx.zzaw();
        this.zza.zza.zzx.zzas();
        ComponentName componentName = new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementService");
        zzjb.zzJ(zzjb2, componentName);
    }
}

