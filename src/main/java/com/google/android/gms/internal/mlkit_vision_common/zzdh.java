/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzdf;
import com.google.android.gms.internal.mlkit_vision_common.zzdo;
import java.util.Comparator;

public final class zzdh
implements Comparator {
    public final /* synthetic */ int compare(Object object, Object object2) {
        int n10;
        object = (zzdf)object;
        object2 = (zzdf)object2;
        zzdo zzdo2 = (zzdo)((zzdf)object).iterator();
        zzdo zzdo3 = (zzdo)((zzdf)object2).iterator();
        while ((n10 = zzdo2.hasNext()) != 0 && (n10 = zzdo3.hasNext()) != 0) {
            n10 = zzdf.zza(zzdo2.zza());
            int n11 = zzdf.zza(zzdo3.zza());
            if ((n10 = Integer.compare(n10, n11)) == 0) continue;
            return n10;
        }
        int n12 = ((zzdf)object).zza();
        int n13 = ((zzdf)object2).zza();
        return Integer.compare(n12, n13);
    }
}

