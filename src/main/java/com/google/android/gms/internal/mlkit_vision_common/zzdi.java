/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzdf;
import com.google.android.gms.internal.mlkit_vision_common.zzdk;
import java.util.NoSuchElementException;

public final class zzdi
extends zzdk {
    private int zza = 0;
    private final int zzb;
    private final /* synthetic */ zzdf zzc;

    public zzdi(zzdf zzdf2) {
        int n10;
        this.zzc = zzdf2;
        this.zzb = n10 = zzdf2.zza();
    }

    public final boolean hasNext() {
        int n10 = this.zza;
        int n11 = this.zzb;
        return n10 < n11;
    }

    public final byte zza() {
        int n10 = this.zza;
        int n11 = this.zzb;
        if (n10 < n11) {
            this.zza = n11 = n10 + 1;
            return this.zzc.zzb(n10);
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }
}

