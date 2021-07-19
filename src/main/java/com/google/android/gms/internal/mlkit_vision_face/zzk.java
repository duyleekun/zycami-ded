/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzbl;
import com.google.android.gms.internal.mlkit_vision_face.zzj;
import java.util.NoSuchElementException;

public abstract class zzk
extends zzbl {
    private final int zza;
    private int zzb;

    public zzk(int n10, int n11) {
        zzj.zzb(n11, n10);
        this.zza = n10;
        this.zzb = n11;
    }

    public final boolean hasNext() {
        int n10 = this.zzb;
        int n11 = this.zza;
        return n10 < n11;
    }

    public final boolean hasPrevious() {
        int n10 = this.zzb;
        return n10 > 0;
    }

    public final Object next() {
        int n10 = this.hasNext();
        if (n10 != 0) {
            int n11;
            n10 = this.zzb;
            this.zzb = n11 = n10 + 1;
            return this.zza(n10);
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    public final int nextIndex() {
        return this.zzb;
    }

    public final Object previous() {
        int n10 = this.hasPrevious();
        if (n10 != 0) {
            this.zzb = n10 = this.zzb + -1;
            return this.zza(n10);
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    public final int previousIndex() {
        return this.zzb + -1;
    }

    public abstract Object zza(int var1);
}

