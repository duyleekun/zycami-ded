/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzbs;
import com.google.android.gms.internal.measurement.zzbw;
import com.google.android.gms.internal.measurement.zzby;
import com.google.android.gms.internal.measurement.zzho;
import com.google.android.gms.internal.measurement.zzhs;
import com.google.android.gms.internal.measurement.zziy;

public final class zzbv
extends zzho
implements zziy {
    private zzbv() {
        zzbw zzbw2 = zzbw.zzo();
        super(zzbw2);
    }

    public /* synthetic */ zzbv(zzbs object) {
        object = zzbw.zzo();
        super((zzhs)object);
    }

    public final String zza() {
        return ((zzbw)this.zza).zzc();
    }

    public final zzbv zzb(String string2) {
        boolean bl2 = this.zzb;
        if (bl2) {
            this.zzax();
            bl2 = false;
            this.zzb = false;
        }
        zzbw.zzp((zzbw)this.zza, string2);
        return this;
    }

    public final int zzc() {
        return ((zzbw)this.zza).zze();
    }

    public final zzby zzd(int n10) {
        return ((zzbw)this.zza).zzf(n10);
    }

    public final zzbv zze(int n10, zzby zzby2) {
        boolean bl2 = this.zzb;
        if (bl2) {
            this.zzax();
            bl2 = false;
            this.zzb = false;
        }
        zzbw.zzq((zzbw)this.zza, n10, zzby2);
        return this;
    }
}

