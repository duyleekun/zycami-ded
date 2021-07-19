/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzft;
import com.google.android.gms.internal.measurement.zzfv;

public final class zzfw
extends zzft {
    private final zzfv zza;

    public zzfw() {
        zzfv zzfv2;
        this.zza = zzfv2 = new zzfv();
    }

    public final void zza(Throwable throwable, Throwable throwable2) {
        if (throwable2 != throwable) {
            this.zza.zza(throwable, true).add(throwable2);
            return;
        }
        throwable = new IllegalArgumentException("Self suppression is not allowed.", throwable2);
        throw throwable;
    }
}

