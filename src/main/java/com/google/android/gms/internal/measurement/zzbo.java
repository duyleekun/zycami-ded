/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 */
package com.google.android.gms.internal.measurement;

import android.app.Activity;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzbg;
import com.google.android.gms.internal.measurement.zzbq;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.internal.measurement.zzm;
import com.google.android.gms.internal.measurement.zzp;

public final class zzbo
extends zzbg {
    public final /* synthetic */ Activity zza;
    public final /* synthetic */ zzm zzb;
    public final /* synthetic */ zzbq zzc;

    public zzbo(zzbq object, Activity activity, zzm zzm2) {
        this.zzc = object;
        this.zza = activity;
        this.zzb = zzm2;
        object = ((zzbq)object).zza;
        super((zzbr)object, true);
    }

    public final void zza() {
        zzp zzp2 = zzbr.zzR(this.zzc.zza);
        IObjectWrapper iObjectWrapper = ObjectWrapper.wrap(this.zza);
        zzm zzm2 = this.zzb;
        long l10 = this.zzi;
        zzp2.onActivitySaveInstanceState(iObjectWrapper, zzm2, l10);
    }
}

