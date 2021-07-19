/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzap;
import com.google.android.gms.internal.mlkit_common.zzaq;
import java.util.Objects;

public final class zzar
extends zzaq {
    private final zzap zza;

    public zzar() {
        zzap zzap2;
        this.zza = zzap2 = new zzap();
    }

    public final void zza(Throwable throwable, Throwable throwable2) {
        if (throwable2 != throwable) {
            Objects.requireNonNull(throwable2, "The suppressed exception cannot be null.");
            this.zza.zza(throwable, true).add(throwable2);
            return;
        }
        throwable = new IllegalArgumentException("Self suppression is not allowed.", throwable2);
        throw throwable;
    }
}

