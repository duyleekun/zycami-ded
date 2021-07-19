/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzcs;
import com.google.android.gms.internal.measurement.zzdc;
import com.google.android.gms.internal.measurement.zzdd;
import com.google.android.gms.internal.measurement.zzdo;
import com.google.android.gms.internal.measurement.zzho;
import com.google.android.gms.internal.measurement.zzhs;
import com.google.android.gms.internal.measurement.zziy;

public final class zzdk
extends zzho
implements zziy {
    private zzdk() {
        zzdo zzdo2 = zzdo.zzb();
        super(zzdo2);
    }

    public /* synthetic */ zzdk(zzcs object) {
        object = zzdo.zzb();
        super((zzhs)object);
    }

    public final zzdk zza(zzdc zziy2) {
        zzdo zzdo2;
        boolean bl2 = this.zzb;
        if (bl2) {
            this.zzax();
            bl2 = false;
            zzdo2 = null;
            this.zzb = false;
        }
        zzdo2 = (zzdo)this.zza;
        zziy2 = (zzdd)zziy2.zzaA();
        zzdo.zzc(zzdo2, (zzdd)zziy2);
        return this;
    }
}

