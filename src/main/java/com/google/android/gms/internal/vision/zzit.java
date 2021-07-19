/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzio;
import java.util.Iterator;
import java.util.Map;

public final class zzit
implements Iterator {
    private Iterator zzzq;

    public zzit(Iterator iterator2) {
        this.zzzq = iterator2;
    }

    public final boolean hasNext() {
        return this.zzzq.hasNext();
    }

    public final /* synthetic */ Object next() {
        Map.Entry entry = (Map.Entry)this.zzzq.next();
        Object object = entry.getValue();
        boolean bl2 = object instanceof zzio;
        if (bl2) {
            object = new Object(entry, null);
            return object;
        }
        return entry;
    }

    public final void remove() {
        this.zzzq.remove();
    }
}

