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
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.internal.measurement.zzp;

public final class zzae
extends zzbg {
    public final /* synthetic */ Activity zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ zzbr zzd;

    public zzae(zzbr zzbr2, Activity activity, String string2, String string3) {
        this.zzd = zzbr2;
        this.zza = activity;
        this.zzb = string2;
        this.zzc = string3;
        super(zzbr2, true);
    }

    public final void zza() {
        zzp zzp2 = zzbr.zzR(this.zzd);
        IObjectWrapper iObjectWrapper = ObjectWrapper.wrap(this.zza);
        String string2 = this.zzb;
        String string3 = this.zzc;
        long l10 = this.zzh;
        zzp2.setCurrentScreen(iObjectWrapper, string2, string3, l10);
    }
}

