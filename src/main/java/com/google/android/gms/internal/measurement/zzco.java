/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzcl;
import com.google.android.gms.internal.measurement.zzcm;
import com.google.android.gms.internal.measurement.zzcn;
import com.google.android.gms.internal.measurement.zzcp;
import com.google.android.gms.internal.measurement.zzho;
import com.google.android.gms.internal.measurement.zzhs;
import com.google.android.gms.internal.measurement.zziy;
import java.util.Collections;
import java.util.List;

public final class zzco
extends zzho
implements zziy {
    private zzco() {
        zzcp zzcp2 = zzcp.zzm();
        super(zzcp2);
    }

    public /* synthetic */ zzco(zzcl object) {
        object = zzcp.zzm();
        super((zzhs)object);
    }

    public final int zza() {
        return ((zzcp)this.zza).zzf();
    }

    public final zzcn zzb(int n10) {
        return ((zzcp)this.zza).zzg(n10);
    }

    public final zzco zzc(int n10, zzcm zziy2) {
        zzcp zzcp2;
        boolean bl2 = this.zzb;
        if (bl2) {
            this.zzax();
            bl2 = false;
            zzcp2 = null;
            this.zzb = false;
        }
        zzcp2 = (zzcp)this.zza;
        zziy2 = (zzcn)zziy2.zzaA();
        zzcp.zzn(zzcp2, n10, (zzcn)zziy2);
        return this;
    }

    public final List zzd() {
        return Collections.unmodifiableList(((zzcp)this.zza).zzh());
    }

    public final zzco zze() {
        boolean bl2 = this.zzb;
        if (bl2) {
            this.zzax();
            bl2 = false;
            this.zzb = false;
        }
        zzcp.zzo((zzcp)this.zza);
        return this;
    }
}

