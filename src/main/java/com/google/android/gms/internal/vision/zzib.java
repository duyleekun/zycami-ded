/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzid;
import com.google.android.gms.internal.vision.zzid$zzf;
import com.google.android.gms.internal.vision.zzjk;
import com.google.android.gms.internal.vision.zzjl;

public final class zzib
implements zzjk {
    private static final zzib zzxu;

    static {
        zzib zzib2;
        zzxu = zzib2 = new zzib();
    }

    private zzib() {
    }

    public static zzib zzgq() {
        return zzxu;
    }

    public final boolean zza(Class clazz) {
        return zzid.class.isAssignableFrom(clazz);
    }

    public final zzjl zzb(Class object) {
        String string2;
        Class<zzid> clazz = zzid.class;
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
        clazz = zzid.zzd(clazz);
        n10 = zzid$zzf.zzyj;
        boolean bl2 = false;
        string2 = null;
        clazz = ((zzid)((Object)clazz)).zza(n10, null, null);
        return (zzjl)((Object)clazz);
    }
}

