/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class zzfh {
    private static volatile boolean zza = false;
    private static boolean zzb = true;
    private static volatile zzfh zzc;
    private static final zzfh zzd;
    private final Map zze;

    static {
        zzfh zzfh2;
        zzd = zzfh2 = new zzfh(true);
    }

    public zzfh() {
        HashMap hashMap;
        this.zze = hashMap = new HashMap();
    }

    private zzfh(boolean bl2) {
        Map map;
        this.zze = map = Collections.emptyMap();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static zzfh zza() {
        zzfh zzfh2 = zzc;
        if (zzfh2 != null) return zzfh2;
        Class<zzfh> clazz = zzfh.class;
        synchronized (clazz) {
            zzfh2 = zzc;
            if (zzfh2 != null) return zzfh2;
            zzc = zzfh2 = zzd;
            return zzfh2;
        }
    }
}

