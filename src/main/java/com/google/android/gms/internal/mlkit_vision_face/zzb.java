/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzg;
import com.google.android.gms.internal.mlkit_vision_face.zzj;

public final class zzb
extends zzg {
    public static final zzb zza;

    static {
        zzb zzb2;
        zza = zzb2 = new zzb();
    }

    private zzb() {
    }

    public final boolean equals(Object object) {
        return object == this;
    }

    public final int hashCode() {
        return 2040732332;
    }

    public final String toString() {
        return "Optional.absent()";
    }

    public final Object zza(Object object) {
        return zzj.zza(object, (Object)"use Optional.orNull() instead of Optional.or(null)");
    }

    public final boolean zza() {
        return false;
    }
}

