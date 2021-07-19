/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzde;
import com.google.android.gms.internal.vision.zzez;
import java.util.NoSuchElementException;

public abstract class zzdm
extends zzez {
    private int position;
    private final int size;

    public zzdm(int n10, int n11) {
        zzde.zze(n11, n10);
        this.size = n10;
        this.position = n11;
    }

    public abstract Object get(int var1);

    public final boolean hasNext() {
        int n10 = this.position;
        int n11 = this.size;
        return n10 < n11;
    }

    public final boolean hasPrevious() {
        int n10 = this.position;
        return n10 > 0;
    }

    public final Object next() {
        int n10 = this.hasNext();
        if (n10 != 0) {
            int n11;
            n10 = this.position;
            this.position = n11 = n10 + 1;
            return this.get(n10);
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    public final int nextIndex() {
        return this.position;
    }

    public final Object previous() {
        int n10 = this.hasPrevious();
        if (n10 != 0) {
            this.position = n10 = this.position + -1;
            return this.get(n10);
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    public final int previousIndex() {
        return this.position + -1;
    }
}

