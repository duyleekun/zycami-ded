/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzm;
import com.google.android.gms.internal.mlkit_vision_common.zzp;
import java.util.Objects;

public final class zzq
extends zzm {
    private final zzp zza;

    public zzq() {
        zzp zzp2;
        this.zza = zzp2 = new zzp();
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

