/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzhe;
import java.util.Iterator;

public final class zzhg
implements Iterator {
    private Iterator zza;
    private final /* synthetic */ zzhe zzb;

    public zzhg(zzhe object) {
        this.zzb = object;
        this.zza = object = zzhe.zza((zzhe)object).iterator();
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

