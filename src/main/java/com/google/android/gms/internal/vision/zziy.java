/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzik;
import com.google.android.gms.internal.vision.zziw;
import com.google.android.gms.internal.vision.zzix;
import com.google.android.gms.internal.vision.zzld;
import java.util.List;

public final class zziy
extends zzix {
    private zziy() {
        super(null);
    }

    public /* synthetic */ zziy(zziw zziw2) {
        this();
    }

    private static zzik zzc(Object object, long l10) {
        return (zzik)zzld.zzp(object, l10);
    }

    public final List zza(Object object, long l10) {
        zzik zzik2 = zziy.zzc(object, l10);
        int n10 = zzik2.zzei();
        if (n10 == 0) {
            n10 = zzik2.size();
            n10 = n10 == 0 ? 10 : (n10 <<= 1);
            zzik2 = zzik2.zzan(n10);
            zzld.zza(object, l10, zzik2);
        }
        return zzik2;
    }

    public final void zza(Object object, Object object2, long l10) {
        zzik zzik2 = zziy.zzc(object, l10);
        object2 = zziy.zzc(object2, l10);
        int n10 = zzik2.size();
        int n11 = object2.size();
        if (n10 > 0 && n11 > 0) {
            boolean bl2 = zzik2.zzei();
            if (!bl2) {
                zzik2 = zzik2.zzan(n11 += n10);
            }
            zzik2.addAll(object2);
        }
        if (n10 > 0) {
            object2 = zzik2;
        }
        zzld.zza(object, l10, object2);
    }

    public final void zzb(Object object, long l10) {
        zziy.zzc(object, l10).zzej();
    }
}

