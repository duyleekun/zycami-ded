/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzfl;
import com.google.android.gms.internal.mlkit_common.zzfq;
import com.google.android.gms.internal.mlkit_common.zzfq$zzb;
import com.google.android.gms.internal.mlkit_common.zzfq$zzc;
import com.google.android.gms.internal.mlkit_common.zzhb;
import com.google.android.gms.internal.mlkit_common.zzhd;

public class zzfq$zzd
extends zzfq$zzb
implements zzhd {
    public zzfq$zzd(zzfq$zzc zzfq$zzc) {
        super(zzfq$zzc);
    }

    public void zzc() {
        super.zzc();
        Object object = this.zza;
        zzfq zzfq2 = object;
        zzfq2 = (zzfq$zzc)object;
        ((zzfq$zzc)zzfq2).zzc = object = (zzfl)((zzfq$zzc)object).zzc.clone();
    }

    public /* synthetic */ zzfq zzd() {
        return (zzfq$zzc)((zzfq$zzb)this).zzf();
    }

    public /* synthetic */ zzhb zzf() {
        boolean bl2 = this.zzb;
        if (bl2) {
            return (zzfq$zzc)this.zza;
        }
        ((zzfq$zzc)this.zza).zzc.zzb();
        return (zzfq$zzc)super.zzd();
    }
}

