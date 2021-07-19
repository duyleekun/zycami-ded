/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzik;
import java.util.Iterator;

public final class zzim
implements Iterator {
    private Iterator zza;
    private final /* synthetic */ zzik zzb;

    public zzim(zzik object) {
        this.zzb = object;
        this.zza = object = zzik.zza((zzik)object).iterator();
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

