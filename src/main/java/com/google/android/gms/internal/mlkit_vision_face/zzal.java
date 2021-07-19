/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzaf;
import java.util.AbstractSet;
import java.util.Iterator;

public final class zzal
extends AbstractSet {
    private final /* synthetic */ zzaf zza;

    public zzal(zzaf zzaf2) {
        this.zza = zzaf2;
    }

    public final void clear() {
        this.zza.clear();
    }

    public final boolean contains(Object object) {
        return this.zza.containsKey(object);
    }

    public final Iterator iterator() {
        return this.zza.zze();
    }

    public final boolean remove(Object object) {
        Object object2 = this.zza.zzb();
        if (object2 != null) {
            return object2.keySet().remove(object);
        }
        return (object = zzaf.zza(this.zza, object)) != (object2 = zzaf.zzh());
    }

    public final int size() {
        return this.zza.size();
    }
}

