/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzky;
import java.util.ListIterator;

public final class zzlb
implements ListIterator {
    private final /* synthetic */ zzky zzacg;
    private ListIterator zzach;
    private final /* synthetic */ int zzaci;

    public zzlb(zzky object, int n10) {
        this.zzacg = object;
        this.zzaci = n10;
        this.zzach = object = zzky.zza((zzky)object).listIterator(n10);
    }

    public final /* synthetic */ void add(Object object) {
        object = (String)object;
        object = new UnsupportedOperationException();
        throw object;
    }

    public final boolean hasNext() {
        return this.zzach.hasNext();
    }

    public final boolean hasPrevious() {
        return this.zzach.hasPrevious();
    }

    public final /* synthetic */ Object next() {
        return (String)this.zzach.next();
    }

    public final int nextIndex() {
        return this.zzach.nextIndex();
    }

    public final /* synthetic */ Object previous() {
        return (String)this.zzach.previous();
    }

    public final int previousIndex() {
        return this.zzach.previousIndex();
    }

    public final void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public final /* synthetic */ void set(Object object) {
        object = (String)object;
        object = new UnsupportedOperationException();
        throw object;
    }
}

