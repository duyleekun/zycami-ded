/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.common;

import com.google.android.gms.internal.common.zzo;
import com.google.android.gms.internal.common.zzp;
import com.google.android.gms.internal.common.zzq;
import java.io.Serializable;

public final class zzn {
    public static zzo zza(zzo zzo2) {
        boolean bl2 = zzo2 instanceof zzp;
        if (!bl2 && !(bl2 = zzo2 instanceof zzq)) {
            bl2 = zzo2 instanceof Serializable;
            if (bl2) {
                zzq zzq2 = new zzq(zzo2);
                return zzq2;
            }
            zzp zzp2 = new zzp(zzo2);
            return zzp2;
        }
        return zzo2;
    }
}

