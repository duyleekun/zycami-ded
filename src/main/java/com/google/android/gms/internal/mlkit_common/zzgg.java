/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzep;
import com.google.android.gms.internal.mlkit_common.zzfh;
import com.google.android.gms.internal.mlkit_common.zzgb;
import com.google.android.gms.internal.mlkit_common.zzhb;

public class zzgg {
    private static final zzfh zza = zzfh.zza();
    private zzep zzb;
    private volatile zzhb zzc;
    private volatile zzep zzd;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final zzhb zzb(zzhb object) {
        Object object2 = this.zzc;
        if (object2 != null) return this.zzc;
        synchronized (this) {
            object2 = this.zzc;
            if (object2 != null) {
                return this.zzc;
            }
            try {
                this.zzc = object;
                this.zzd = object2 = zzep.zza;
            }
            catch (zzgb zzgb2) {
                this.zzc = object;
                this.zzd = object = zzep.zza;
            }
            return this.zzc;
        }
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        boolean bl2 = object instanceof zzgg;
        if (!bl2) {
            return false;
        }
        object = (zzgg)object;
        Object object2 = this.zzc;
        zzhb zzhb2 = ((zzgg)object).zzc;
        if (object2 == null && zzhb2 == null) {
            object2 = this.zzc();
            object = ((zzgg)object).zzc();
            return ((zzep)object2).equals(object);
        }
        if (object2 != null && zzhb2 != null) {
            return object2.equals(zzhb2);
        }
        if (object2 != null) {
            zzhb2 = object2.zzn();
            object = super.zzb(zzhb2);
            return object2.equals(object);
        }
        object = zzhb2.zzn();
        return this.zzb((zzhb)object).equals(zzhb2);
    }

    public int hashCode() {
        return 1;
    }

    public final zzhb zza(zzhb zzhb2) {
        zzhb zzhb3 = this.zzc;
        this.zzb = null;
        this.zzd = null;
        this.zzc = zzhb2;
        return zzhb3;
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
    public final zzep zzc() {
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
                this.zzd = object = zzep.zza;
                return this.zzd;
            } else {
                object = this.zzc;
                this.zzd = object = object.zze();
            }
            return this.zzd;
        }
    }
}

