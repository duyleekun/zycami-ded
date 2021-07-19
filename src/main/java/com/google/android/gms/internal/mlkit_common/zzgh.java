/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzgc;
import java.util.Iterator;
import java.util.Map;

public final class zzgh
implements Iterator {
    private Iterator zza;

    public zzgh(Iterator iterator2) {
        this.zza = iterator2;
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final /* synthetic */ Object next() {
        Map.Entry entry = (Map.Entry)this.zza.next();
        Object object = entry.getValue();
        boolean bl2 = object instanceof zzgc;
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

