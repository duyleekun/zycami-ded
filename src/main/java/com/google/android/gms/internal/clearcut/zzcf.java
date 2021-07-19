/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcg;
import com.google.android.gms.internal.clearcut.zzcg$zzg;
import com.google.android.gms.internal.clearcut.zzdm;
import com.google.android.gms.internal.clearcut.zzdn;

public final class zzcf
implements zzdn {
    private static final zzcf zzjo;

    static {
        zzcf zzcf2;
        zzjo = zzcf2 = new zzcf();
    }

    private zzcf() {
    }

    public static zzcf zzay() {
        return zzjo;
    }

    public final boolean zza(Class clazz) {
        return zzcg.class.isAssignableFrom(clazz);
    }

    public final zzdm zzb(Class object) {
        String string2;
        Class<zzcg> clazz = zzcg.class;
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
        clazz = zzcg.zzc(clazz);
        n10 = zzcg$zzg.zzkf;
        boolean bl2 = false;
        string2 = null;
        clazz = ((zzcg)((Object)clazz)).zza(n10, null, null);
        return (zzdm)((Object)clazz);
    }
}

