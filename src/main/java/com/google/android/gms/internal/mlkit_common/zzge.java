/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzgc;
import com.google.android.gms.internal.mlkit_common.zzgf;
import com.google.android.gms.internal.mlkit_common.zzhb;
import java.util.Map;

public final class zzge
implements Map.Entry {
    private Map.Entry zza;

    private zzge(Map.Entry entry) {
        this.zza = entry;
    }

    public /* synthetic */ zzge(Map.Entry entry, zzgf zzgf2) {
        this(entry);
    }

    public final Object getKey() {
        return this.zza.getKey();
    }

    public final Object getValue() {
        zzgc zzgc2 = (zzgc)this.zza.getValue();
        if (zzgc2 == null) {
            return null;
        }
        return zzgc.zza();
    }

    public final Object setValue(Object object) {
        boolean bl2 = object instanceof zzhb;
        if (bl2) {
            zzgc zzgc2 = (zzgc)this.zza.getValue();
            object = (zzhb)object;
            return zzgc2.zza((zzhb)object);
        }
        object = new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        throw object;
    }

    public final zzgc zza() {
        return (zzgc)this.zza.getValue();
    }
}

