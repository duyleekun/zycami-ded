/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zziy;
import java.util.Iterator;

public final class zzja
implements Iterator {
    private Iterator zza;
    private final /* synthetic */ zziy zzb;

    public zzja(zziy object) {
        this.zzb = object;
        this.zza = object = zziy.zza((zziy)object).iterator();
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final /* synthetic */ Object next() {
        return (String)this.zza.next();
    }

    public final void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }
}

