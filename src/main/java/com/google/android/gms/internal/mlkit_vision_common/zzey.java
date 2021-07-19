/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzev;
import com.google.android.gms.internal.mlkit_vision_common.zzew;
import com.google.android.gms.internal.mlkit_vision_common.zzfr;
import java.util.Map;

public final class zzey
implements Map.Entry {
    private Map.Entry zza;

    private zzey(Map.Entry entry) {
        this.zza = entry;
    }

    public /* synthetic */ zzey(Map.Entry entry, zzev zzev2) {
        this(entry);
    }

    public final Object getKey() {
        return this.zza.getKey();
    }

    public final Object getValue() {
        zzew zzew2 = (zzew)this.zza.getValue();
        if (zzew2 == null) {
            return null;
        }
        return zzew.zza();
    }

    public final Object setValue(Object object) {
        boolean bl2 = object instanceof zzfr;
        if (bl2) {
            zzew zzew2 = (zzew)this.zza.getValue();
            object = (zzfr)object;
            return zzew2.zza((zzfr)object);
        }
        object = new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        throw object;
    }

    public final zzew zza() {
        return (zzew)this.zza.getValue();
    }
}

