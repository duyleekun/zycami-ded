/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzgy;
import com.google.android.gms.internal.mlkit_common.zzgz;

public final class zzgq
implements zzgy {
    private zzgy[] zza;

    public zzgq(zzgy ... zzgyArray) {
        this.zza = zzgyArray;
    }

    public final boolean zza(Class clazz) {
        for (zzgy zzgy2 : this.zza) {
            boolean bl2 = zzgy2.zza(clazz);
            if (!bl2) continue;
            return true;
        }
        return false;
    }

    public final zzgz zzb(Class object) {
        for (zzgy zzgy2 : this.zza) {
            boolean bl2 = zzgy2.zza((Class)object);
            if (!bl2) continue;
            return zzgy2.zzb((Class)object);
        }
        String string2 = "No factory is available for message type: ";
        int n10 = ((String)(object = String.valueOf(((Class)object).getName()))).length();
        object = n10 != 0 ? string2.concat((String)object) : new String(string2);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException((String)object);
        throw unsupportedOperationException;
    }
}

