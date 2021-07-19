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
import com.google.android.gms.internal.measurement.zzp;

public final class zzbl
extends zzbg {
    public final /* synthetic */ Activity zza;
    public final /* synthetic */ zzbq zzb;

    public zzbl(zzbq object, Activity activity) {
        this.zzb = object;
        this.zza = activity;
        object = ((zzbq)object).zza;
        super((zzbr)object, true);
    }

    public final void zza() {
        zzp zzp2 = zzbr.zzR(this.zzb.zza);
        IObjectWrapper iObjectWrapper = ObjectWrapper.wrap(this.zza);
        long l10 = this.zzi;
        zzp2.onActivityResumed(iObjectWrapper, l10);
    }
}

