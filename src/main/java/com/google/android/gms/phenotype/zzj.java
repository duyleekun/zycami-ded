/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.phenotype;

import com.google.android.gms.phenotype.zzi;
import java.util.Comparator;

public final class zzj
implements Comparator {
    public final /* synthetic */ int compare(Object object, Object object2) {
        object = (zzi)object;
        object2 = (zzi)object2;
        int n10 = ((zzi)object).zzah;
        int n11 = ((zzi)object2).zzah;
        if (n10 == n11) {
            object = ((zzi)object).name;
            object2 = ((zzi)object2).name;
            return ((String)object).compareTo((String)object2);
        }
        return n10 - n11;
    }
}

