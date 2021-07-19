/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzbc;
import java.util.Map;
import java.util.Set;

public abstract class zzy
implements zzbc {
    private transient Set zza;
    private transient Map zzb;

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        boolean bl2 = object instanceof zzbc;
        if (bl2) {
            object = (zzbc)object;
            Map map = this.zzg();
            object = object.zzg();
            return map.equals(object);
        }
        return false;
    }

    public int hashCode() {
        return this.zzg().hashCode();
    }

    public String toString() {
        return this.zzg().toString();
    }

    public boolean zza(Object object, Object object2) {
        return this.zza(object).add(object2);
    }

    public abstract Set zzc();

    public abstract Map zzd();

    public Set zzf() {
        Set set = this.zza;
        if (set == null) {
            this.zza = set = this.zzc();
        }
        return set;
    }

    public Map zzg() {
        Map map = this.zzb;
        if (map == null) {
            this.zzb = map = this.zzd();
        }
        return map;
    }
}

