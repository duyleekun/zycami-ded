/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.zzel;
import com.google.android.gms.measurement.internal.zzkd;
import java.util.Map;

public final class zzjx
implements zzel {
    public final /* synthetic */ String zza;
    public final /* synthetic */ zzkd zzb;

    public zzjx(zzkd zzkd2, String string2) {
        this.zzb = zzkd2;
        this.zza = string2;
    }

    public final void zza(String object, int n10, Throwable throwable, byte[] byArray, Map object2) {
        object = this.zzb;
        object2 = this.zza;
        ((zzkd)object).zzG(n10, throwable, byArray, (String)object2);
    }
}

