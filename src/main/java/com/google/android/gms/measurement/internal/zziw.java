/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 */
package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import com.google.android.gms.measurement.internal.zzja;
import com.google.android.gms.measurement.internal.zzjb;

public final class zziw
implements Runnable {
    public final /* synthetic */ ComponentName zza;
    public final /* synthetic */ zzja zzb;

    public zziw(zzja zzja2, ComponentName componentName) {
        this.zzb = zzja2;
        this.zza = componentName;
    }

    public final void run() {
        zzjb zzjb2 = this.zzb.zza;
        ComponentName componentName = this.zza;
        zzjb.zzJ(zzjb2, componentName);
    }
}

