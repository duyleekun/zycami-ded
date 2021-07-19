/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzcs;
import com.google.android.gms.internal.measurement.zzdd;
import com.google.android.gms.internal.measurement.zzho;
import com.google.android.gms.internal.measurement.zzhs;
import com.google.android.gms.internal.measurement.zziy;

public final class zzdc
extends zzho
implements zziy {
    private zzdc() {
        zzdd zzdd2 = zzdd.zzb();
        super(zzdd2);
    }

    public /* synthetic */ zzdc(zzcs object) {
        object = zzdd.zzb();
        super((zzhs)object);
    }

    public final zzdc zza(String string2) {
        boolean bl2 = this.zzb;
        if (bl2) {
            this.zzax();
            bl2 = false;
            this.zzb = false;
        }
        zzdd.zzc((zzdd)this.zza, string2);
        return this;
    }

    public final zzdc zzb(long l10) {
        boolean bl2 = this.zzb;
        if (bl2) {
            this.zzax();
            bl2 = false;
            this.zzb = false;
        }
        zzdd.zzd((zzdd)this.zza, l10);
        return this;
    }
}

