/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzcy;

public final class zzcv
extends zzcy {
    public static final zzcv zzly;

    static {
        zzcv zzcv2;
        zzly = zzcv2 = new zzcv();
    }

    private zzcv() {
    }

    public final boolean equals(Object object) {
        return object == this;
    }

    public final Object get() {
        IllegalStateException illegalStateException = new IllegalStateException("Optional.get() cannot be called on an absent value");
        throw illegalStateException;
    }

    public final int hashCode() {
        return 2040732332;
    }

    public final boolean isPresent() {
        return false;
    }

    public final String toString() {
        return "Optional.absent()";
    }
}

