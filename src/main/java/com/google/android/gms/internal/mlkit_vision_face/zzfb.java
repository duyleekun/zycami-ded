/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzez;
import com.google.android.gms.internal.mlkit_vision_face.zzfi;
import java.util.Comparator;

public final class zzfb
implements Comparator {
    public final /* synthetic */ int compare(Object object, Object object2) {
        int n10;
        object = (zzez)object;
        object2 = (zzez)object2;
        zzfi zzfi2 = (zzfi)((zzez)object).iterator();
        zzfi zzfi3 = (zzfi)((zzez)object2).iterator();
        while ((n10 = zzfi2.hasNext()) != 0 && (n10 = zzfi3.hasNext()) != 0) {
            n10 = zzez.zza(zzfi2.zza());
            int n11 = zzez.zza(zzfi3.zza());
            if ((n10 = Integer.compare(n10, n11)) == 0) continue;
            return n10;
        }
        int n12 = ((zzez)object).zza();
        int n13 = ((zzez)object2).zza();
        return Integer.compare(n12, n13);
    }
}

