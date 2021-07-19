/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzeg;
import com.google.android.gms.internal.mlkit_common.zzej;
import com.google.android.gms.internal.mlkit_common.zzfq;
import com.google.android.gms.internal.mlkit_common.zzfq$zze;
import com.google.android.gms.internal.mlkit_common.zzhb;
import com.google.android.gms.internal.mlkit_common.zzhd;
import com.google.android.gms.internal.mlkit_common.zzhm;
import com.google.android.gms.internal.mlkit_common.zzig;

public class zzfq$zzb
extends zzej {
    public zzfq zza;
    public boolean zzb;
    private final zzfq zzc;

    public zzfq$zzb(zzfq zzfq2) {
        this.zzc = zzfq2;
        int n10 = zzfq$zze.zzd;
        this.zza = zzfq2 = (zzfq)zzfq2.zza(n10, null, null);
        this.zzb = false;
    }

    private static void zza(zzfq zzfq2, zzfq zzfq3) {
        zzhm.zza().zza(zzfq2).zzb(zzfq2, zzfq3);
    }

    public /* synthetic */ Object clone() {
        zzhd zzhd2 = this.zzc;
        int n10 = zzfq$zze.zze;
        zzhd2 = (zzfq$zzb)((zzfq)zzhd2).zza(n10, null, null);
        zzfq zzfq2 = (zzfq)this.zzf();
        ((zzfq$zzb)zzhd2).zza(zzfq2);
        return zzhd2;
    }

    public final /* synthetic */ zzej zza(zzeg zzeg2) {
        zzeg2 = (zzfq)zzeg2;
        return this.zza((zzfq)zzeg2);
    }

    public final zzfq$zzb zza(zzfq zzfq2) {
        boolean bl2 = this.zzb;
        if (bl2) {
            this.zzc();
            bl2 = false;
            this.zzb = false;
        }
        zzfq$zzb.zza(this.zza, zzfq2);
        return this;
    }

    public final /* synthetic */ zzej zzb() {
        return (zzfq$zzb)((zzej)this).clone();
    }

    public void zzc() {
        zzfq zzfq2 = this.zza;
        int n10 = zzfq$zze.zzd;
        zzfq2 = (zzfq)zzfq2.zza(n10, null, null);
        zzfq zzfq3 = this.zza;
        zzfq$zzb.zza(zzfq2, zzfq3);
        this.zza = zzfq2;
    }

    public zzfq zzd() {
        boolean bl2 = this.zzb;
        if (bl2) {
            return this.zza;
        }
        zzfq zzfq2 = this.zza;
        zzhm.zza().zza(zzfq2).zzb(zzfq2);
        this.zzb = true;
        return this.zza;
    }

    public final zzfq zze() {
        zzfq zzfq2 = (zzfq)this.zzf();
        boolean bl2 = zzfq2.zzi();
        if (bl2) {
            return zzfq2;
        }
        zzig zzig2 = new zzig(zzfq2);
        throw zzig2;
    }

    public /* synthetic */ zzhb zzf() {
        return this.zzd();
    }

    public /* synthetic */ zzhb zzg() {
        return this.zze();
    }

    public final boolean zzi() {
        return zzfq.zza(this.zza, false);
    }

    public final /* synthetic */ zzhb zzn() {
        return this.zzc;
    }
}

