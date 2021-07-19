/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzdf;
import com.google.android.gms.internal.mlkit_vision_common.zzdx;
import com.google.android.gms.internal.mlkit_vision_common.zzer;
import com.google.android.gms.internal.mlkit_vision_common.zzfr;

public class zzfa {
    private static final zzdx zza = zzdx.zza();
    private zzdf zzb;
    private volatile zzfr zzc;
    private volatile zzdf zzd;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final zzfr zzb(zzfr object) {
        Object object2 = this.zzc;
        if (object2 != null) return this.zzc;
        synchronized (this) {
            object2 = this.zzc;
            if (object2 != null) {
                return this.zzc;
            }
            try {
                this.zzc = object;
                this.zzd = object2 = zzdf.zza;
            }
            catch (zzer zzer2) {
                this.zzc = object;
                this.zzd = object = zzdf.zza;
            }
            return this.zzc;
        }
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        boolean bl2 = object instanceof zzfa;
        if (!bl2) {
            return false;
        }
        object = (zzfa)object;
        Object object2 = this.zzc;
        zzfr zzfr2 = ((zzfa)object).zzc;
        if (object2 == null && zzfr2 == null) {
            object2 = this.zzc();
            object = ((zzfa)object).zzc();
            return ((zzdf)object2).equals(object);
        }
        if (object2 != null && zzfr2 != null) {
            return object2.equals(zzfr2);
        }
        if (object2 != null) {
            zzfr2 = object2.zzi();
            object = super.zzb(zzfr2);
            return object2.equals(object);
        }
        object = zzfr2.zzi();
        return this.zzb((zzfr)object).equals(zzfr2);
    }

    public int hashCode() {
        return 1;
    }

    public final zzfr zza(zzfr zzfr2) {
        zzfr zzfr3 = this.zzc;
        this.zzb = null;
        this.zzd = null;
        this.zzc = zzfr2;
        return zzfr3;
    }

    public final int zzb() {
        Object object = this.zzd;
        if (object != null) {
            return this.zzd.zza();
        }
        object = this.zzc;
        if (object != null) {
            return this.zzc.zzj();
        }
        return 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final zzdf zzc() {
        Object object = this.zzd;
        if (object != null) {
            return this.zzd;
        }
        synchronized (this) {
            object = this.zzd;
            if (object != null) {
                return this.zzd;
            }
            object = this.zzc;
            if (object == null) {
                this.zzd = object = zzdf.zza;
                return this.zzd;
            } else {
                object = this.zzc;
                this.zzd = object = object.zze();
            }
            return this.zzd;
        }
    }
}

