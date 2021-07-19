/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgs;
import com.google.android.gms.internal.vision.zzhb;
import java.util.Comparator;

public final class zzgu
implements Comparator {
    public final /* synthetic */ int compare(Object object, Object object2) {
        int n10;
        object = (zzgs)object;
        object2 = (zzgs)object2;
        zzhb zzhb2 = (zzhb)((zzgs)object).iterator();
        zzhb zzhb3 = (zzhb)((zzgs)object2).iterator();
        while ((n10 = zzhb2.hasNext()) != 0 && (n10 = zzhb3.hasNext()) != 0) {
            n10 = zzgs.zzb(zzhb2.nextByte());
            int n11 = zzgs.zzb(zzhb3.nextByte());
            if ((n10 = Integer.compare(n10, n11)) == 0) continue;
            return n10;
        }
        int n12 = ((zzgs)object).size();
        int n13 = ((zzgs)object2).size();
        return Integer.compare(n12, n13);
    }
}

