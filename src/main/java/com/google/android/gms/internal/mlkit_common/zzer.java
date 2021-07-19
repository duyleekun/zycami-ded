/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzep;
import com.google.android.gms.internal.mlkit_common.zzeu;
import java.util.Comparator;

public final class zzer
implements Comparator {
    public final /* synthetic */ int compare(Object object, Object object2) {
        int n10;
        object = (zzep)object;
        object2 = (zzep)object2;
        zzeu zzeu2 = (zzeu)((zzep)object).iterator();
        zzeu zzeu3 = (zzeu)((zzep)object2).iterator();
        while ((n10 = zzeu2.hasNext()) != 0 && (n10 = zzeu3.hasNext()) != 0) {
            n10 = zzep.zza(zzeu2.zza());
            int n11 = zzep.zza(zzeu3.zza());
            if ((n10 = Integer.compare(n10, n11)) == 0) continue;
            return n10;
        }
        int n12 = ((zzep)object).zza();
        int n13 = ((zzep)object2).zza();
        return Integer.compare(n12, n13);
    }
}

