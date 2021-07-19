/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzdf;
import com.google.android.gms.internal.vision.zzdh;
import com.google.android.gms.internal.vision.zzdj;
import com.google.android.gms.internal.vision.zzdk;
import java.io.Serializable;

public final class zzdi {
    public static zzdf zza(zzdf zzdf2) {
        boolean bl2 = zzdf2 instanceof zzdk;
        if (!bl2 && !(bl2 = zzdf2 instanceof zzdh)) {
            bl2 = zzdf2 instanceof Serializable;
            if (bl2) {
                zzdh zzdh2 = new zzdh(zzdf2);
                return zzdh2;
            }
            zzdk zzdk2 = new zzdk(zzdf2);
            return zzdk2;
        }
        return zzdf2;
    }

    public static zzdf zzd(Object object) {
        zzdj zzdj2 = new zzdj(object);
        return zzdj2;
    }
}

