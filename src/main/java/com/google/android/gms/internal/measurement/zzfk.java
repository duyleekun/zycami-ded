/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfm;

public final class zzfk
extends zzfm {
    public static final zzfk zza;

    static {
        zzfk zzfk2;
        zza = zzfk2 = new zzfk();
    }

    private zzfk() {
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

    public final boolean zza() {
        return false;
    }

    public final Object zzb() {
        IllegalStateException illegalStateException = new IllegalStateException("Optional.get() cannot be called on an absent value");
        throw illegalStateException;
    }
}

