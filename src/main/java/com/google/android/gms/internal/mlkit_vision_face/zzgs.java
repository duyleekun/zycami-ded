/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzgp;
import com.google.android.gms.internal.mlkit_vision_face.zzgq;
import com.google.android.gms.internal.mlkit_vision_face.zzhl;
import java.util.Map;

public final class zzgs
implements Map.Entry {
    private Map.Entry zza;

    private zzgs(Map.Entry entry) {
        this.zza = entry;
    }

    public /* synthetic */ zzgs(Map.Entry entry, zzgp zzgp2) {
        this(entry);
    }

    public final Object getKey() {
        return this.zza.getKey();
    }

    public final Object getValue() {
        zzgq zzgq2 = (zzgq)this.zza.getValue();
        if (zzgq2 == null) {
            return null;
        }
        return zzgq.zza();
    }

    public final Object setValue(Object object) {
        boolean bl2 = object instanceof zzhl;
        if (bl2) {
            zzgq zzgq2 = (zzgq)this.zza.getValue();
            object = (zzhl)object;
            return zzgq2.zza((zzhl)object);
        }
        object = new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        throw object;
    }

    public final zzgq zza() {
        return (zzgq)this.zza.getValue();
    }
}

