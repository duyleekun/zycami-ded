/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;

public final class zzjr {
    private final Clock zza;
    private long zzb;

    public zzjr(Clock clock) {
        Preconditions.checkNotNull(clock);
        this.zza = clock;
    }

    public final void zza() {
        long l10;
        this.zzb = l10 = this.zza.elapsedRealtime();
    }

    public final void zzb() {
        this.zzb = 0L;
    }

    public final boolean zzc(long l10) {
        l10 = this.zzb;
        long l11 = 0L;
        Object object = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        boolean bl2 = true;
        if (object == false) {
            return bl2;
        }
        Clock clock = this.zza;
        l11 = clock.elapsedRealtime();
        long l12 = this.zzb;
        long l13 = (l11 -= l12) - (l12 = 3600000L);
        object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object >= 0) {
            return bl2;
        }
        return false;
    }
}

