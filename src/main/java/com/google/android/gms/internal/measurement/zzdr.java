/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzcs;
import com.google.android.gms.internal.measurement.zzds;
import com.google.android.gms.internal.measurement.zzho;
import com.google.android.gms.internal.measurement.zzhs;
import com.google.android.gms.internal.measurement.zziy;

public final class zzdr
extends zzho
implements zziy {
    private zzdr() {
        zzds zzds2 = zzds.zzg();
        super(zzds2);
    }

    public /* synthetic */ zzdr(zzcs object) {
        object = zzds.zzg();
        super((zzhs)object);
    }

    public final zzdr zza(int n10) {
        boolean bl2 = this.zzb;
        if (bl2) {
            this.zzax();
            bl2 = false;
            this.zzb = false;
        }
        zzds.zzh((zzds)this.zza, n10);
        return this;
    }

    public final zzdr zzb(Iterable iterable) {
        boolean bl2 = this.zzb;
        if (bl2) {
            this.zzax();
            bl2 = false;
            this.zzb = false;
        }
        zzds.zzi((zzds)this.zza, iterable);
        return this;
    }
}

