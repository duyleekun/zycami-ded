/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzu$zza;
import com.google.android.gms.internal.mlkit_common.zzv;
import java.util.logging.Logger;

public final class zzu {
    private static final Logger zza = Logger.getLogger(zzu.class.getName());
    private static final zzv zzb;

    static {
        zzu$zza zzu$zza = new zzu$zza(null);
        zzb = zzu$zza;
    }

    private zzu() {
    }

    public static String zza(String string2) {
        if (string2 == null) {
            string2 = "";
        }
        return string2;
    }
}

