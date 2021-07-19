/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzio;
import com.google.android.gms.internal.vision.zzir;
import com.google.android.gms.internal.vision.zzjn;
import java.util.Map;

public final class zziq
implements Map.Entry {
    private Map.Entry zzzm;

    private zziq(Map.Entry entry) {
        this.zzzm = entry;
    }

    public /* synthetic */ zziq(Map.Entry entry, zzir zzir2) {
        this(entry);
    }

    public final Object getKey() {
        return this.zzzm.getKey();
    }

    public final Object getValue() {
        zzio zzio2 = (zzio)this.zzzm.getValue();
        if (zzio2 == null) {
            return null;
        }
        return zzio.zzhp();
    }

    public final Object setValue(Object object) {
        boolean bl2 = object instanceof zzjn;
        if (bl2) {
            zzio zzio2 = (zzio)this.zzzm.getValue();
            object = (zzjn)object;
            return zzio2.zzi((zzjn)object);
        }
        object = new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        throw object;
    }

    public final zzio zzhr() {
        return (zzio)this.zzzm.getValue();
    }
}

