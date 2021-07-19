/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzba;
import com.google.android.gms.internal.mlkit_vision_face.zzbb;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Set;

public abstract class zzbd
extends AbstractMap {
    private transient Set zza;
    private transient Set zzb;
    private transient Collection zzc;

    public Set entrySet() {
        Set set = this.zza;
        if (set == null) {
            this.zza = set = this.zza();
        }
        return set;
    }

    public Set keySet() {
        Set set = this.zzb;
        if (set == null) {
            this.zzb = set = new zzbb(this);
        }
        return set;
    }

    public Collection values() {
        Collection collection = this.zzc;
        if (collection == null) {
            this.zzc = collection = new zzba(this);
        }
        return collection;
    }

    public abstract Set zza();
}

