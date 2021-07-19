/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class zzdx {
    private static volatile boolean zza = false;
    private static boolean zzb = true;
    private static volatile zzdx zzc;
    private static final zzdx zzd;
    private final Map zze;

    static {
        zzdx zzdx2;
        zzd = zzdx2 = new zzdx(true);
    }

    public zzdx() {
        HashMap hashMap;
        this.zze = hashMap = new HashMap();
    }

    private zzdx(boolean bl2) {
        Map map;
        this.zze = map = Collections.emptyMap();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static zzdx zza() {
        zzdx zzdx2 = zzc;
        if (zzdx2 != null) return zzdx2;
        Class<zzdx> clazz = zzdx.class;
        synchronized (clazz) {
            zzdx2 = zzc;
            if (zzdx2 != null) return zzdx2;
            zzc = zzdx2 = zzd;
            return zzdx2;
        }
    }
}

