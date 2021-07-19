/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzj;
import java.util.Iterator;

public abstract class zzbj
implements Iterator {
    private final Iterator zza;

    public zzbj(Iterator iterator2) {
        this.zza = iterator2 = (Iterator)zzj.zza(iterator2);
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final Object next() {
        Object e10 = this.zza.next();
        return this.zza(e10);
    }

    public final void remove() {
        this.zza.remove();
    }

    public abstract Object zza(Object var1);
}

