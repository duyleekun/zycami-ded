/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzbs;
import com.google.android.gms.internal.measurement.zzcf;
import com.google.android.gms.internal.measurement.zzho;
import com.google.android.gms.internal.measurement.zzhs;
import com.google.android.gms.internal.measurement.zziy;

public final class zzce
extends zzho
implements zziy {
    private zzce() {
        zzcf zzcf2 = zzcf.zzj();
        super(zzcf2);
    }

    public /* synthetic */ zzce(zzbs object) {
        object = zzcf.zzj();
        super((zzhs)object);
    }

    public final zzce zza(String string2) {
        boolean bl2 = this.zzb;
        if (bl2) {
            this.zzax();
            bl2 = false;
            this.zzb = false;
        }
        zzcf.zzk((zzcf)this.zza, string2);
        return this;
    }
}

