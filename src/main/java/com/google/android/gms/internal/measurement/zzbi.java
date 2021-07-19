/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzu;
import com.google.android.gms.measurement.internal.zzgm;

public final class zzbi
extends zzu {
    private final zzgm zza;

    public zzbi(zzgm zzgm2) {
        this.zza = zzgm2;
    }

    public final void zzd(String string2, String string3, Bundle bundle, long l10) {
        this.zza.onEvent(string2, string3, bundle, l10);
    }

    public final int zze() {
        return System.identityHashCode(this.zza);
    }
}

