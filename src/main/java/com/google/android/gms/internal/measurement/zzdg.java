/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzcs;
import com.google.android.gms.internal.measurement.zzdh;
import com.google.android.gms.internal.measurement.zzdi;
import com.google.android.gms.internal.measurement.zzdj;
import com.google.android.gms.internal.measurement.zzho;
import com.google.android.gms.internal.measurement.zzhs;
import com.google.android.gms.internal.measurement.zziy;

public final class zzdg
extends zzho
implements zziy {
    private zzdg() {
        zzdh zzdh2 = zzdh.zzd();
        super(zzdh2);
    }

    public /* synthetic */ zzdg(zzcs object) {
        object = zzdh.zzd();
        super((zzhs)object);
    }

    public final zzdj zza(int n10) {
        return ((zzdh)this.zza).zzb(0);
    }

    public final zzdg zzb(zzdi zziy2) {
        zzdh zzdh2;
        boolean bl2 = this.zzb;
        if (bl2) {
            this.zzax();
            bl2 = false;
            zzdh2 = null;
            this.zzb = false;
        }
        zzdh2 = (zzdh)this.zza;
        zziy2 = (zzdj)zziy2.zzaA();
        zzdh.zze(zzdh2, (zzdj)zziy2);
        return this;
    }
}

