/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzhs;
import com.google.android.gms.internal.measurement.zziu;
import com.google.android.gms.internal.measurement.zziv;

public final class zzhn
implements zziv {
    private static final zzhn zza;

    static {
        zzhn zzhn2;
        zza = zzhn2 = new zzhn();
    }

    private zzhn() {
    }

    public static zzhn zza() {
        return zza;
    }

    public final boolean zzb(Class clazz) {
        return zzhs.class.isAssignableFrom(clazz);
    }

    public final zziu zzc(Class object) {
        String string2;
        Class<zzhs> clazz = zzhs.class;
        int n10 = clazz.isAssignableFrom((Class<?>)object);
        if (n10 == 0) {
            object = String.valueOf(((Class)object).getName());
            String string3 = "Unsupported message type: ";
            int n11 = ((String)object).length();
            object = n11 != 0 ? string3.concat((String)object) : new String(string3);
            clazz = new IllegalArgumentException((String)object);
            throw clazz;
        }
        try {
            clazz = ((Class)object).asSubclass(clazz);
        }
        catch (Exception exception) {
            object = String.valueOf(((Class)object).getName());
            string2 = "Unable to get message info for ";
            int n12 = ((String)object).length();
            object = n12 != 0 ? string2.concat((String)object) : new String(string2);
            RuntimeException runtimeException = new RuntimeException((String)object, exception);
            throw runtimeException;
        }
        clazz = zzhs.zzbx(clazz);
        n10 = 3;
        boolean bl2 = false;
        string2 = null;
        clazz = ((zzhs)((Object)clazz)).zzl(n10, null, null);
        return (zziu)((Object)clazz);
    }
}

