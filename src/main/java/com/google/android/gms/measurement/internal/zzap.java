/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.zzaq;
import java.util.Iterator;

public final class zzap
implements Iterator {
    public final Iterator zza;
    public final /* synthetic */ zzaq zzb;

    public zzap(zzaq object) {
        this.zzb = object;
        this.zza = object = zzaq.zzg((zzaq)object).keySet().iterator();
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Remove not supported");
        throw unsupportedOperationException;
    }

    public final String zza() {
        return (String)this.zza.next();
    }
}

