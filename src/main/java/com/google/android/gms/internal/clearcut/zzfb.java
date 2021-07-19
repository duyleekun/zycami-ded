/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzfa;
import java.util.ListIterator;

public final class zzfb
implements ListIterator {
    private ListIterator zzpc;
    private final /* synthetic */ int zzpd;
    private final /* synthetic */ zzfa zzpe;

    public zzfb(zzfa object, int n10) {
        this.zzpe = object;
        this.zzpd = n10;
        this.zzpc = object = zzfa.zza((zzfa)object).listIterator(n10);
    }

    public final /* synthetic */ void add(Object object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public final boolean hasNext() {
        return this.zzpc.hasNext();
    }

    public final boolean hasPrevious() {
        return this.zzpc.hasPrevious();
    }

    public final /* synthetic */ Object next() {
        return (String)this.zzpc.next();
    }

    public final int nextIndex() {
        return this.zzpc.nextIndex();
    }

    public final /* synthetic */ Object previous() {
        return (String)this.zzpc.previous();
    }

    public final int previousIndex() {
        return this.zzpc.previousIndex();
    }

    public final void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public final /* synthetic */ void set(Object object) {
        object = new UnsupportedOperationException();
        throw object;
    }
}

