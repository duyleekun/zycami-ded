/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzbg;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.internal.measurement.zzp;

public final class zzbf
extends zzbg {
    public final /* synthetic */ String zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ Object zzc;
    public final /* synthetic */ boolean zzd;
    public final /* synthetic */ zzbr zze;

    public zzbf(zzbr zzbr2, String string2, String string3, Object object, boolean bl2) {
        this.zze = zzbr2;
        this.zza = string2;
        this.zzb = string3;
        this.zzc = object;
        this.zzd = bl2;
        super(zzbr2, true);
    }

    public final void zza() {
        zzp zzp2 = zzbr.zzR(this.zze);
        String string2 = this.zza;
        String string3 = this.zzb;
        IObjectWrapper iObjectWrapper = ObjectWrapper.wrap(this.zzc);
        boolean bl2 = this.zzd;
        long l10 = this.zzh;
        zzp2.setUserProperty(string2, string3, iObjectWrapper, bl2, l10);
    }
}

