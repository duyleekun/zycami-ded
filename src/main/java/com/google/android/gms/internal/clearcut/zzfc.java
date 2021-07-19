/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzfa;
import java.util.Iterator;

public final class zzfc
implements Iterator {
    private final /* synthetic */ zzfa zzpe;
    private Iterator zzpf;

    public zzfc(zzfa object) {
        this.zzpe = object;
        this.zzpf = object = zzfa.zza((zzfa)object).iterator();
    }

    public final boolean hasNext() {
        return this.zzpf.hasNext();
    }

    public final /* synthetic */ Object next() {
        return (String)this.zzpf.next();
    }

    public final void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }
}

