/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzfy;
import com.google.android.gms.internal.mlkit_common.zzgk;
import com.google.android.gms.internal.mlkit_common.zzgl;
import com.google.android.gms.internal.mlkit_common.zzip;

public final class zzgm
extends zzgl {
    private zzgm() {
        super(null);
    }

    public /* synthetic */ zzgm(zzgk zzgk2) {
        this();
    }

    private static zzfy zzb(Object object, long l10) {
        return (zzfy)zzip.zzf(object, l10);
    }

    public final void zza(Object object, long l10) {
        zzgm.zzb(object, l10).b_();
    }

    public final void zza(Object object, Object object2, long l10) {
        zzfy zzfy2 = zzgm.zzb(object, l10);
        object2 = zzgm.zzb(object2, l10);
        int n10 = zzfy2.size();
        int n11 = object2.size();
        if (n10 > 0 && n11 > 0) {
            boolean bl2 = zzfy2.zza();
            if (!bl2) {
                zzfy2 = zzfy2.zzb(n11 += n10);
            }
            zzfy2.addAll(object2);
        }
        if (n10 > 0) {
            object2 = zzfy2;
        }
        zzip.zza(object, l10, object2);
    }
}

