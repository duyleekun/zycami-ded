/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzew;
import java.util.Iterator;
import java.util.Map;

public final class zzex
implements Iterator {
    private Iterator zza;

    public zzex(Iterator iterator2) {
        this.zza = iterator2;
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final /* synthetic */ Object next() {
        Map.Entry entry = (Map.Entry)this.zza.next();
        Object object = entry.getValue();
        boolean bl2 = object instanceof zzew;
        if (bl2) {
            object = new Object(entry, null);
            return object;
        }
        return entry;
    }

    public final void remove() {
        this.zza.remove();
    }
}

