/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzez;
import com.google.android.gms.internal.mlkit_vision_face.zzfr;
import com.google.android.gms.internal.mlkit_vision_face.zzgl;
import com.google.android.gms.internal.mlkit_vision_face.zzhl;

public class zzgu {
    private static final zzfr zza = zzfr.zza();
    private zzez zzb;
    private volatile zzhl zzc;
    private volatile zzez zzd;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final zzhl zzb(zzhl object) {
        Object object2 = this.zzc;
        if (object2 != null) return this.zzc;
        synchronized (this) {
            object2 = this.zzc;
            if (object2 != null) {
                return this.zzc;
            }
            try {
                this.zzc = object;
                this.zzd = object2 = zzez.zza;
            }
            catch (zzgl zzgl2) {
                this.zzc = object;
                this.zzd = object = zzez.zza;
            }
            return this.zzc;
        }
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        boolean bl2 = object instanceof zzgu;
        if (!bl2) {
            return false;
        }
        object = (zzgu)object;
        Object object2 = this.zzc;
        zzhl zzhl2 = ((zzgu)object).zzc;
        if (object2 == null && zzhl2 == null) {
            object2 = this.zzc();
            object = ((zzgu)object).zzc();
            return ((zzez)object2).equals(object);
        }
        if (object2 != null && zzhl2 != null) {
            return object2.equals(zzhl2);
        }
        if (object2 != null) {
            zzhl2 = object2.zzi();
            object = super.zzb(zzhl2);
            return object2.equals(object);
        }
        object = zzhl2.zzi();
        return this.zzb((zzhl)object).equals(zzhl2);
    }

    public int hashCode() {
        return 1;
    }

    public final zzhl zza(zzhl zzhl2) {
        zzhl zzhl3 = this.zzc;
        this.zzb = null;
        this.zzd = null;
        this.zzc = zzhl2;
        return zzhl3;
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
    public final zzez zzc() {
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
                this.zzd = object = zzez.zza;
                return this.zzd;
            } else {
                object = this.zzc;
                this.zzd = object = object.zze();
            }
            return this.zzd;
        }
    }
}

