/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzfg;
import com.google.android.gms.internal.mlkit_common.zzfl;
import com.google.android.gms.internal.mlkit_common.zzfq$zzc;
import com.google.android.gms.internal.mlkit_common.zzfq$zzf;
import com.google.android.gms.internal.mlkit_common.zzhb;
import com.google.android.gms.internal.mlkit_common.zzjd;
import java.util.Map;

public final class zzfj
extends zzfg {
    public final int zza(Map.Entry object) {
        object = (zzfq$zzf)object.getKey();
        object = new NoSuchMethodError();
        throw object;
    }

    public final zzfl zza(Object object) {
        return ((zzfq$zzc)object).zzc;
    }

    public final void zza(zzjd object, Map.Entry entry) {
        object = (zzfq$zzf)entry.getKey();
        object = new NoSuchMethodError();
        throw object;
    }

    public final boolean zza(zzhb zzhb2) {
        return zzhb2 instanceof zzfq$zzc;
    }

    public final zzfl zzb(Object object) {
        object = (zzfq$zzc)object;
        zzfl zzfl2 = ((zzfq$zzc)object).zzc;
        boolean bl2 = zzfl2.zzc();
        if (bl2) {
            ((zzfq$zzc)object).zzc = zzfl2 = (zzfl)((zzfq$zzc)object).zzc.clone();
        }
        return ((zzfq$zzc)object).zzc;
    }

    public final void zzc(Object object) {
        ((zzfg)this).zza(object).zzb();
    }
}

