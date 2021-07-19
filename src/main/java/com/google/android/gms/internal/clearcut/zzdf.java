/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzdm;
import com.google.android.gms.internal.clearcut.zzdn;

public final class zzdf
implements zzdn {
    private zzdn[] zzma;

    public zzdf(zzdn ... zzdnArray) {
        this.zzma = zzdnArray;
    }

    public final boolean zza(Class clazz) {
        for (zzdn zzdn2 : this.zzma) {
            boolean bl2 = zzdn2.zza(clazz);
            if (!bl2) continue;
            return true;
        }
        return false;
    }

    public final zzdm zzb(Class object) {
        for (zzdn zzdn2 : this.zzma) {
            boolean bl2 = zzdn2.zza((Class)object);
            if (!bl2) continue;
            return zzdn2.zzb((Class)object);
        }
        String string2 = "No factory is available for message type: ";
        int n10 = ((String)(object = String.valueOf(((Class)object).getName()))).length();
        object = n10 != 0 ? string2.concat((String)object) : new String(string2);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException((String)object);
        throw unsupportedOperationException;
    }
}

