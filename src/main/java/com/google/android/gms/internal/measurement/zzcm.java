/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzcl;
import com.google.android.gms.internal.measurement.zzcn;
import com.google.android.gms.internal.measurement.zzho;
import com.google.android.gms.internal.measurement.zzhs;
import com.google.android.gms.internal.measurement.zziy;

public final class zzcm
extends zzho
implements zziy {
    private zzcm() {
        zzcn zzcn2 = zzcn.zzf();
        super(zzcn2);
    }

    public /* synthetic */ zzcm(zzcl object) {
        object = zzcn.zzf();
        super((zzhs)object);
    }

    public final String zza() {
        return ((zzcn)this.zza).zza();
    }

    public final zzcm zzb(String string2) {
        boolean bl2 = this.zzb;
        if (bl2) {
            this.zzax();
            bl2 = false;
            this.zzb = false;
        }
        zzcn.zzg((zzcn)this.zza, string2);
        return this;
    }

    public final boolean zzc() {
        return ((zzcn)this.zza).zzb();
    }

    public final boolean zzd() {
        return ((zzcn)this.zza).zzc();
    }

    public final boolean zze() {
        return ((zzcn)this.zza).zzd();
    }

    public final int zzf() {
        return ((zzcn)this.zza).zze();
    }
}

