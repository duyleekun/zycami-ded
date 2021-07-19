/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgq;
import com.google.android.gms.internal.measurement.zzgs;
import com.google.android.gms.internal.measurement.zzhe;
import com.google.android.gms.internal.measurement.zzic;
import com.google.android.gms.internal.measurement.zzix;

public class zzif {
    private static final zzhe zzb = zzhe.zza();
    public volatile zzix zza;
    private volatile zzgs zzc;

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        boolean bl2 = object instanceof zzif;
        if (!bl2) {
            return false;
        }
        object = (zzif)object;
        Object object2 = this.zza;
        zzix zzix2 = ((zzif)object).zza;
        if (object2 == null && zzix2 == null) {
            object2 = this.zzb();
            object = ((zzif)object).zzb();
            return ((zzgs)object2).equals(object);
        }
        if (object2 != null && zzix2 != null) {
            return object2.equals(zzix2);
        }
        if (object2 != null) {
            zzix2 = object2.zzbK();
            ((zzif)object).zzc(zzix2);
            object = ((zzif)object).zza;
            return object2.equals(object);
        }
        object = zzix2.zzbK();
        this.zzc((zzix)object);
        return this.zza.equals(zzix2);
    }

    public int hashCode() {
        return 1;
    }

    public final int zza() {
        Object object = this.zzc;
        if (object != null) {
            return ((zzgq)this.zzc).zza.length;
        }
        object = this.zza;
        if (object != null) {
            return this.zza.zzbw();
        }
        return 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final zzgs zzb() {
        Object object = this.zzc;
        if (object != null) {
            return this.zzc;
        }
        synchronized (this) {
            object = this.zzc;
            if (object != null) {
                return this.zzc;
            }
            object = this.zza;
            if (object == null) {
                this.zzc = object = zzgs.zzb;
                return this.zzc;
            } else {
                object = this.zza;
                this.zzc = object = object.zzbo();
            }
            return this.zzc;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void zzc(zzix object) {
        Object object2 = this.zza;
        if (object2 != null) {
            return;
        }
        synchronized (this) {
            object2 = this.zza;
            if (object2 != null) {
                return;
            }
            try {
                this.zza = object;
                this.zzc = object2 = zzgs.zzb;
            }
            catch (zzic zzic2) {
                this.zza = object;
                this.zzc = object = zzgs.zzb;
            }
            return;
        }
    }
}

