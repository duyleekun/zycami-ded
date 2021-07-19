/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class zzfr {
    private static volatile boolean zza = false;
    private static boolean zzb = true;
    private static volatile zzfr zzc;
    private static final zzfr zzd;
    private final Map zze;

    static {
        zzfr zzfr2;
        zzd = zzfr2 = new zzfr(true);
    }

    public zzfr() {
        HashMap hashMap;
        this.zze = hashMap = new HashMap();
    }

    private zzfr(boolean bl2) {
        Map map;
        this.zze = map = Collections.emptyMap();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static zzfr zza() {
        zzfr zzfr2 = zzc;
        if (zzfr2 != null) return zzfr2;
        Class<zzfr> clazz = zzfr.class;
        synchronized (clazz) {
            zzfr2 = zzc;
            if (zzfr2 != null) return zzfr2;
            zzc = zzfr2 = zzd;
            return zzfr2;
        }
    }
}

