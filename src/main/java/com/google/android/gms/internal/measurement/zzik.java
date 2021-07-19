/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzhz;
import com.google.android.gms.internal.measurement.zzii;
import com.google.android.gms.internal.measurement.zzil;
import com.google.android.gms.internal.measurement.zzkh;

public final class zzik
extends zzil {
    private zzik() {
        super(null);
    }

    public /* synthetic */ zzik(zzii zzii2) {
        super(null);
    }

    public final void zza(Object object, long l10) {
        ((zzhz)zzkh.zzn(object, l10)).zzb();
    }

    public final void zzb(Object object, Object object2, long l10) {
        zzhz zzhz2 = (zzhz)zzkh.zzn(object, l10);
        object2 = (zzhz)zzkh.zzn(object2, l10);
        int n10 = zzhz2.size();
        int n11 = object2.size();
        if (n10 > 0 && n11 > 0) {
            boolean bl2 = zzhz2.zza();
            if (!bl2) {
                zzhz2 = zzhz2.zze(n11 += n10);
            }
            zzhz2.addAll(object2);
        }
        if (n10 > 0) {
            object2 = zzhz2;
        }
        zzkh.zzo(object, l10, object2);
    }
}

