/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzbs;
import com.google.android.gms.internal.measurement.zzbu;
import com.google.android.gms.internal.measurement.zzbv;
import com.google.android.gms.internal.measurement.zzbw;
import com.google.android.gms.internal.measurement.zzce;
import com.google.android.gms.internal.measurement.zzcf;
import com.google.android.gms.internal.measurement.zzho;
import com.google.android.gms.internal.measurement.zzhs;
import com.google.android.gms.internal.measurement.zziy;

public final class zzbt
extends zzho
implements zziy {
    private zzbt() {
        zzbu zzbu2 = zzbu.zzi();
        super(zzbu2);
    }

    public /* synthetic */ zzbt(zzbs object) {
        object = zzbu.zzi();
        super((zzhs)object);
    }

    public final int zza() {
        return ((zzbu)this.zza).zzd();
    }

    public final zzcf zzb(int n10) {
        return ((zzbu)this.zza).zze(n10);
    }

    public final zzbt zzc(int n10, zzce zziy2) {
        zzbu zzbu2;
        boolean bl2 = this.zzb;
        if (bl2) {
            this.zzax();
            bl2 = false;
            zzbu2 = null;
            this.zzb = false;
        }
        zzbu2 = (zzbu)this.zza;
        zziy2 = (zzcf)zziy2.zzaA();
        zzbu.zzj(zzbu2, n10, (zzcf)zziy2);
        return this;
    }

    public final int zzd() {
        return ((zzbu)this.zza).zzg();
    }

    public final zzbw zze(int n10) {
        return ((zzbu)this.zza).zzh(n10);
    }

    public final zzbt zzf(int n10, zzbv zziy2) {
        zzbu zzbu2;
        boolean bl2 = this.zzb;
        if (bl2) {
            this.zzax();
            bl2 = false;
            zzbu2 = null;
            this.zzb = false;
        }
        zzbu2 = (zzbu)this.zza;
        zziy2 = (zzbw)zziy2.zzaA();
        zzbu.zzk(zzbu2, n10, (zzbw)zziy2);
        return this;
    }
}

