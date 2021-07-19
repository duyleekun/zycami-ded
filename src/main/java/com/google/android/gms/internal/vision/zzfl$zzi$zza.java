/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzfk;
import com.google.android.gms.internal.vision.zzfl$zzf;
import com.google.android.gms.internal.vision.zzfl$zzf$zza;
import com.google.android.gms.internal.vision.zzfl$zzi;
import com.google.android.gms.internal.vision.zzfl$zzj;
import com.google.android.gms.internal.vision.zzid;
import com.google.android.gms.internal.vision.zzid$zza;
import com.google.android.gms.internal.vision.zzjp;

public final class zzfl$zzi$zza
extends zzid$zza
implements zzjp {
    private zzfl$zzi$zza() {
        zzfl$zzi zzfl$zzi = zzfl$zzi.zzds();
        super(zzfl$zzi);
    }

    public /* synthetic */ zzfl$zzi$zza(zzfk zzfk2) {
        this();
    }

    public final zzfl$zzi$zza zza(zzfl$zzf$zza zzjp2) {
        zzfl$zzi zzfl$zzi;
        boolean bl2 = this.zzxy;
        if (bl2) {
            this.zzgs();
            bl2 = false;
            zzfl$zzi = null;
            this.zzxy = false;
        }
        zzfl$zzi = (zzfl$zzi)this.zzxx;
        zzjp2 = (zzfl$zzf)((zzid)zzjp2.zzgw());
        zzfl$zzi.zza(zzfl$zzi, (zzfl$zzf)zzjp2);
        return this;
    }

    public final zzfl$zzi$zza zza(zzfl$zzj zzfl$zzj) {
        boolean bl2 = this.zzxy;
        if (bl2) {
            this.zzgs();
            bl2 = false;
            this.zzxy = false;
        }
        zzfl$zzi.zza((zzfl$zzi)this.zzxx, zzfl$zzj);
        return this;
    }

    public final zzfl$zzi$zza zze(Iterable iterable) {
        boolean bl2 = this.zzxy;
        if (bl2) {
            this.zzgs();
            bl2 = false;
            this.zzxy = false;
        }
        zzfl$zzi.zza((zzfl$zzi)this.zzxx, iterable);
        return this;
    }
}

