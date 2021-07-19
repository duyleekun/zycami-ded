/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzfq;
import com.google.android.gms.internal.mlkit_common.zzfq$zze;
import com.google.android.gms.internal.mlkit_common.zzgy;
import com.google.android.gms.internal.mlkit_common.zzgz;

public final class zzfr
implements zzgy {
    private static final zzfr zza;

    static {
        zzfr zzfr2;
        zza = zzfr2 = new zzfr();
    }

    private zzfr() {
    }

    public static zzfr zza() {
        return zza;
    }

    public final boolean zza(Class clazz) {
        return zzfq.class.isAssignableFrom(clazz);
    }

    public final zzgz zzb(Class object) {
        String string2;
        Class<zzfq> clazz = zzfq.class;
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
        clazz = zzfq.zza(clazz);
        n10 = zzfq$zze.zzc;
        boolean bl2 = false;
        string2 = null;
        clazz = ((zzfq)((Object)clazz)).zza(n10, null, null);
        return (zzgz)((Object)clazz);
    }
}

