/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzbb;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class zzbc
implements Iterator {
    private final int limit;
    private int position = 0;
    private final /* synthetic */ zzbb zzfl;

    public zzbc(zzbb zzbb2) {
        int n10;
        this.zzfl = zzbb2;
        this.limit = n10 = zzbb2.size();
    }

    private final byte nextByte() {
        zzbb zzbb2;
        try {
            zzbb2 = this.zzfl;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            String string2 = indexOutOfBoundsException.getMessage();
            NoSuchElementException noSuchElementException = new NoSuchElementException(string2);
            throw noSuchElementException;
        }
        int n10 = this.position;
        int n11 = n10 + 1;
        this.position = n11;
        return zzbb2.zzj(n10);
    }

    public final boolean hasNext() {
        int n10 = this.position;
        int n11 = this.limit;
        return n10 < n11;
    }

    public final /* synthetic */ Object next() {
        return this.nextByte();
    }

    public final void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }
}

