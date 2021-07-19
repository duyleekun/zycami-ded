/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzbs;
import com.google.android.gms.internal.measurement.zzby;
import com.google.android.gms.internal.measurement.zzho;
import com.google.android.gms.internal.measurement.zzhs;
import com.google.android.gms.internal.measurement.zziy;

public final class zzbx
extends zzho
implements zziy {
    private zzbx() {
        zzby zzby2 = zzby.zzj();
        super(zzby2);
    }

    public /* synthetic */ zzbx(zzbs object) {
        object = zzby.zzj();
        super((zzhs)object);
    }

    public final zzbx zza(String string2) {
        boolean bl2 = this.zzb;
        if (bl2) {
            this.zzax();
            bl2 = false;
            this.zzb = false;
        }
        zzby.zzk((zzby)this.zza, string2);
        return this;
    }
}

