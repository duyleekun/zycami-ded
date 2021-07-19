/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzej;
import com.google.android.gms.internal.mlkit_vision_common.zzej$zzf;
import com.google.android.gms.internal.mlkit_vision_common.zzfp;
import com.google.android.gms.internal.mlkit_vision_common.zzfs;

public final class zzeh
implements zzfs {
    private static final zzeh zza;

    static {
        zzeh zzeh2;
        zza = zzeh2 = new zzeh();
    }

    private zzeh() {
    }

    public static zzeh zza() {
        return zza;
    }

    public final boolean zza(Class clazz) {
        return zzej.class.isAssignableFrom(clazz);
    }

    public final zzfp zzb(Class object) {
        String string2;
        Class<zzej> clazz = zzej.class;
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
        clazz = zzej.zza(clazz);
        n10 = zzej$zzf.zzc;
        boolean bl2 = false;
        string2 = null;
        clazz = ((zzej)((Object)clazz)).zza(n10, null, null);
        return (zzfp)((Object)clazz);
    }
}

