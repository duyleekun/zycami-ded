/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzcs;
import com.google.android.gms.internal.measurement.zzcx;
import com.google.android.gms.internal.measurement.zzdp;
import com.google.android.gms.internal.measurement.zzdq;
import com.google.android.gms.internal.measurement.zzho;
import com.google.android.gms.internal.measurement.zzhs;
import com.google.android.gms.internal.measurement.zziy;

public final class zzcw
extends zzho
implements zziy {
    private zzcw() {
        zzcx zzcx2 = zzcx.zzi();
        super(zzcx2);
    }

    public /* synthetic */ zzcw(zzcs object) {
        object = zzcx.zzi();
        super((zzhs)object);
    }

    public final zzcw zza(int n10) {
        boolean bl2 = this.zzb;
        if (bl2) {
            this.zzax();
            bl2 = false;
            this.zzb = false;
        }
        zzcx.zzj((zzcx)this.zza, n10);
        return this;
    }

    public final zzcw zzb(zzdp zziy2) {
        zzcx zzcx2;
        boolean bl2 = this.zzb;
        if (bl2) {
            this.zzax();
            bl2 = false;
            zzcx2 = null;
            this.zzb = false;
        }
        zzcx2 = (zzcx)this.zza;
        zziy2 = (zzdq)zziy2.zzaA();
        zzcx.zzk(zzcx2, (zzdq)zziy2);
        return this;
    }

    public final zzcw zzc(zzdq zzdq2) {
        boolean bl2 = this.zzb;
        if (bl2) {
            this.zzax();
            bl2 = false;
            this.zzb = false;
        }
        zzcx.zzm((zzcx)this.zza, zzdq2);
        return this;
    }

    public final zzcw zzd(boolean bl2) {
        boolean bl3 = this.zzb;
        if (bl3) {
            this.zzax();
            bl3 = false;
            this.zzb = false;
        }
        zzcx.zzn((zzcx)this.zza, bl2);
        return this;
    }
}

