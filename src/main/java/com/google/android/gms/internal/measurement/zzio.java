/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zziu;
import com.google.android.gms.internal.measurement.zziv;

public final class zzio
implements zziv {
    private final zziv[] zza;

    public zzio(zziv ... zzivArray) {
        this.zza = zzivArray;
    }

    public final boolean zzb(Class clazz) {
        int n10;
        zziv[] zzivArray = this.zza;
        for (int i10 = 0; i10 < (n10 = 2); ++i10) {
            zziv zziv2 = zzivArray[i10];
            n10 = (int)(zziv2.zzb(clazz) ? 1 : 0);
            if (n10 == 0) continue;
            return true;
        }
        return false;
    }

    public final zziu zzc(Class object) {
        int n10;
        Object object2 = this.zza;
        String string2 = null;
        for (int i10 = 0; i10 < (n10 = 2); ++i10) {
            zziv zziv2 = object2[i10];
            boolean bl2 = zziv2.zzb((Class)object);
            if (!bl2) continue;
            return zziv2.zzc((Class)object);
        }
        object = String.valueOf(((Class)object).getName());
        string2 = "No factory is available for message type: ";
        n10 = ((String)object).length();
        object = n10 != 0 ? string2.concat((String)object) : new String(string2);
        object2 = new UnsupportedOperationException((String)object);
        throw object2;
    }
}

