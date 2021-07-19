/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzkb;
import java.util.Iterator;

public final class zzka
implements Iterator {
    public final Iterator zza;
    public final /* synthetic */ zzkb zzb;

    public zzka(zzkb object) {
        this.zzb = object;
        this.zza = object = zzkb.zza((zzkb)object).iterator();
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }
}

