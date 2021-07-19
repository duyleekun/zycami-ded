/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzes;
import com.google.android.gms.internal.mlkit_vision_common.zzfb;
import com.google.android.gms.internal.mlkit_vision_common.zzfe;
import com.google.android.gms.internal.mlkit_vision_common.zzhf;

public final class zzfg
extends zzfb {
    private zzfg() {
        super(null);
    }

    public /* synthetic */ zzfg(zzfe zzfe2) {
        this();
    }

    private static zzes zzb(Object object, long l10) {
        return (zzes)zzhf.zzf(object, l10);
    }

    public final void zza(Object object, long l10) {
        zzfg.zzb(object, l10).zzb();
    }

    public final void zza(Object object, Object object2, long l10) {
        zzes zzes2 = zzfg.zzb(object, l10);
        object2 = zzfg.zzb(object2, l10);
        int n10 = zzes2.size();
        int n11 = object2.size();
        if (n10 > 0 && n11 > 0) {
            boolean bl2 = zzes2.zza();
            if (!bl2) {
                zzes2 = zzes2.zzb(n11 += n10);
            }
            zzes2.addAll(object2);
        }
        if (n10 > 0) {
            object2 = zzes2;
        }
        zzhf.zza(object, l10, object2);
    }
}

