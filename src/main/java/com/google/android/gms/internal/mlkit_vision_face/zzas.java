/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzaq;
import com.google.android.gms.internal.mlkit_vision_face.zzj;
import java.util.List;

public final class zzas
extends zzaq {
    private final transient int zza;
    private final transient int zzb;
    private final /* synthetic */ zzaq zzc;

    public zzas(zzaq zzaq2, int n10, int n11) {
        this.zzc = zzaq2;
        this.zza = n10;
        this.zzb = n11;
    }

    public final Object get(int n10) {
        int n11 = this.zzb;
        zzj.zza(n10, n11);
        zzaq zzaq2 = this.zzc;
        int n12 = this.zza;
        return zzaq2.get(n10 += n12);
    }

    public final int size() {
        return this.zzb;
    }

    public final /* synthetic */ List subList(int n10, int n11) {
        return ((zzaq)this).zza(n10, n11);
    }

    public final zzaq zza(int n10, int n11) {
        int n12 = this.zzb;
        zzj.zza(n10, n11, n12);
        zzaq zzaq2 = this.zzc;
        int n13 = this.zza;
        return (zzaq)zzaq2.subList(n10 += n13, n11 += n13);
    }

    public final Object[] zzb() {
        return this.zzc.zzb();
    }

    public final int zzc() {
        int n10 = this.zzc.zzc();
        int n11 = this.zza;
        return n10 + n11;
    }

    public final int zzd() {
        int n10 = this.zzc.zzc();
        int n11 = this.zza;
        n10 += n11;
        n11 = this.zzb;
        return n10 + n11;
    }
}

