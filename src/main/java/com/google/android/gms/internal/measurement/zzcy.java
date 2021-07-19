/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzcs;
import com.google.android.gms.internal.measurement.zzcz;
import com.google.android.gms.internal.measurement.zzho;
import com.google.android.gms.internal.measurement.zzhs;
import com.google.android.gms.internal.measurement.zziy;

public final class zzcy
extends zzho
implements zziy {
    private zzcy() {
        zzcz zzcz2 = zzcz.zzf();
        super(zzcz2);
    }

    public /* synthetic */ zzcy(zzcs object) {
        object = zzcz.zzf();
        super((zzhs)object);
    }

    public final zzcy zza(int n10) {
        boolean bl2 = this.zzb;
        if (bl2) {
            this.zzax();
            bl2 = false;
            this.zzb = false;
        }
        zzcz.zzg((zzcz)this.zza, n10);
        return this;
    }

    public final zzcy zzb(long l10) {
        boolean bl2 = this.zzb;
        if (bl2) {
            this.zzax();
            bl2 = false;
            this.zzb = false;
        }
        zzcz.zzh((zzcz)this.zza, l10);
        return this;
    }
}

