/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzhj;
import com.google.android.gms.internal.mlkit_vision_face.zzhm;

public final class zzhe
implements zzhm {
    private zzhm[] zza;

    public zzhe(zzhm ... zzhmArray) {
        this.zza = zzhmArray;
    }

    public final boolean zza(Class clazz) {
        for (zzhm zzhm2 : this.zza) {
            boolean bl2 = zzhm2.zza(clazz);
            if (!bl2) continue;
            return true;
        }
        return false;
    }

    public final zzhj zzb(Class object) {
        for (zzhm zzhm2 : this.zza) {
            boolean bl2 = zzhm2.zza((Class)object);
            if (!bl2) continue;
            return zzhm2.zzb((Class)object);
        }
        String string2 = "No factory is available for message type: ";
        int n10 = ((String)(object = String.valueOf(((Class)object).getName()))).length();
        object = n10 != 0 ? string2.concat((String)object) : new String(string2);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException((String)object);
        throw unsupportedOperationException;
    }
}

