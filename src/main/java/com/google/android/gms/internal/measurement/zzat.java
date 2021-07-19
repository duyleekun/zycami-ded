/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzbg;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.internal.measurement.zzp;

public final class zzat
extends zzbg {
    public final /* synthetic */ String zza;
    public final /* synthetic */ Object zzb;
    public final /* synthetic */ zzbr zzc;

    public zzat(zzbr zzbr2, boolean bl2, int n10, String string2, Object object, Object object2, Object object3) {
        this.zzc = zzbr2;
        this.zza = string2;
        this.zzb = object;
        super(zzbr2, false);
    }

    public final void zza() {
        zzp zzp2 = zzbr.zzR(this.zzc);
        String string2 = this.zza;
        IObjectWrapper iObjectWrapper = ObjectWrapper.wrap(this.zzb);
        IObjectWrapper iObjectWrapper2 = ObjectWrapper.wrap(null);
        IObjectWrapper iObjectWrapper3 = ObjectWrapper.wrap(null);
        zzp2.logHealthData(5, string2, iObjectWrapper, iObjectWrapper2, iObjectWrapper3);
    }
}

