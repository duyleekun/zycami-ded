/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzky;
import java.util.Iterator;

public final class zzla
implements Iterator {
    private Iterator zzacf;
    private final /* synthetic */ zzky zzacg;

    public zzla(zzky object) {
        this.zzacg = object;
        this.zzacf = object = zzky.zza((zzky)object).iterator();
    }

    public final boolean hasNext() {
        return this.zzacf.hasNext();
    }

    public final /* synthetic */ Object next() {
        return (String)this.zzacf.next();
    }

    public final void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }
}

