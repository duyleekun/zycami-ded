/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzfl;
import com.google.android.gms.measurement.internal.zzge;
import com.google.android.gms.measurement.internal.zzgg;
import com.google.android.gms.measurement.internal.zzkd;

public class zzju
extends zzge
implements zzgg {
    public final zzkd zza;

    public zzju(zzkd zzkd2) {
        zzfl zzfl2 = zzkd2.zzR();
        super(zzfl2);
        Preconditions.checkNotNull(zzkd2);
        this.zza = zzkd2;
    }
}

