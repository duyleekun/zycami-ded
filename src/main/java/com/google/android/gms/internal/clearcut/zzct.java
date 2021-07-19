/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcr;
import com.google.android.gms.internal.clearcut.zzcs;
import com.google.android.gms.internal.clearcut.zzdo;
import java.util.Map;

public final class zzct
implements Map.Entry {
    private Map.Entry zzll;

    private zzct(Map.Entry entry) {
        this.zzll = entry;
    }

    public /* synthetic */ zzct(Map.Entry entry, zzcs zzcs2) {
        this(entry);
    }

    public final Object getKey() {
        return this.zzll.getKey();
    }

    public final Object getValue() {
        zzcr zzcr2 = (zzcr)this.zzll.getValue();
        if (zzcr2 == null) {
            return null;
        }
        return zzcr.zzbr();
    }

    public final Object setValue(Object object) {
        boolean bl2 = object instanceof zzdo;
        if (bl2) {
            zzcr zzcr2 = (zzcr)this.zzll.getValue();
            object = (zzdo)object;
            return zzcr2.zzi((zzdo)object);
        }
        object = new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        throw object;
    }

    public final zzcr zzbs() {
        return (zzcr)this.zzll.getValue();
    }
}

