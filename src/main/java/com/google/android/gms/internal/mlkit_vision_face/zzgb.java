/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzgd;
import com.google.android.gms.internal.mlkit_vision_face.zzgd$zzf;
import com.google.android.gms.internal.mlkit_vision_face.zzhj;
import com.google.android.gms.internal.mlkit_vision_face.zzhm;

public final class zzgb
implements zzhm {
    private static final zzgb zza;

    static {
        zzgb zzgb2;
        zza = zzgb2 = new zzgb();
    }

    private zzgb() {
    }

    public static zzgb zza() {
        return zza;
    }

    public final boolean zza(Class clazz) {
        return zzgd.class.isAssignableFrom(clazz);
    }

    public final zzhj zzb(Class object) {
        String string2;
        Class<zzgd> clazz = zzgd.class;
        int n10 = clazz.isAssignableFrom((Class<?>)object);
        if (n10 == 0) {
            String string3 = "Unsupported message type: ";
            int n11 = ((String)(object = String.valueOf(((Class)object).getName()))).length();
            object = n11 != 0 ? string3.concat((String)object) : new String(string3);
            clazz = new IllegalArgumentException((String)object);
            throw clazz;
        }
        try {
            clazz = ((Class)object).asSubclass(clazz);
        }
        catch (Exception exception) {
            string2 = "Unable to get message info for ";
            object = String.valueOf(((Class)object).getName());
            int n12 = ((String)object).length();
            object = n12 != 0 ? string2.concat((String)object) : new String(string2);
            RuntimeException runtimeException = new RuntimeException((String)object, exception);
            throw runtimeException;
        }
        clazz = zzgd.zza(clazz);
        n10 = zzgd$zzf.zzc;
        boolean bl2 = false;
        string2 = null;
        clazz = ((zzgd)((Object)clazz)).zza(n10, null, null);
        return (zzhj)((Object)clazz);
    }
}

