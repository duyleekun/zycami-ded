/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzez;
import com.google.android.gms.internal.mlkit_vision_face.zzfe;
import java.util.NoSuchElementException;

public final class zzfc
extends zzfe {
    private int zza = 0;
    private final int zzb;
    private final /* synthetic */ zzez zzc;

    public zzfc(zzez zzez2) {
        int n10;
        this.zzc = zzez2;
        this.zzb = n10 = zzez2.zza();
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

