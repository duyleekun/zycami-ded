/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgk;
import com.google.android.gms.internal.measurement.zzgs;
import java.util.NoSuchElementException;

public final class zzgi
extends zzgk {
    public final /* synthetic */ zzgs zza;
    private int zzb = 0;
    private final int zzc;

    public zzgi(zzgs zzgs2) {
        int n10;
        this.zza = zzgs2;
        this.zzc = n10 = zzgs2.zzc();
    }

    public final boolean hasNext() {
        int n10 = this.zzb;
        int n11 = this.zzc;
        return n10 < n11;
    }

    public final byte zza() {
        int n10 = this.zzb;
        int n11 = this.zzc;
        if (n10 < n11) {
            this.zzb = n11 = n10 + 1;
            return this.zza.zzb(n10);
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }
}

