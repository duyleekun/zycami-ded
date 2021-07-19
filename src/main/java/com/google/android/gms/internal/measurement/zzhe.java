/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzhd;
import com.google.android.gms.internal.measurement.zzhm;
import com.google.android.gms.internal.measurement.zzhq;
import com.google.android.gms.internal.measurement.zzix;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zzhe {
    public static final zzhe zza;
    private static volatile boolean zzb = false;
    private static volatile zzhe zzc;
    private static volatile zzhe zzd;
    private final Map zze;

    static {
        zzhe zzhe2;
        zza = zzhe2 = new zzhe(true);
    }

    public zzhe() {
        HashMap hashMap;
        this.zze = hashMap = new HashMap();
    }

    public zzhe(boolean bl2) {
        Map map;
        this.zze = map = Collections.emptyMap();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static zzhe zza() {
        zzhe zzhe2 = zzc;
        if (zzhe2 != null) return zzhe2;
        Class<zzhe> clazz = zzhe.class;
        synchronized (clazz) {
            zzhe2 = zzc;
            if (zzhe2 != null) return zzhe2;
            zzc = zzhe2 = zza;
            return zzhe2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static zzhe zzb() {
        Class<zzhe> clazz = zzhe.class;
        zzhe zzhe2 = zzd;
        if (zzhe2 != null) {
            return zzhe2;
        }
        synchronized (clazz) {
            zzhe2 = zzd;
            if (zzhe2 != null) {
                return zzhe2;
            }
            zzd = zzhe2 = zzhm.zzb(clazz);
            return zzhe2;
        }
    }

    public final zzhq zzc(zzix zzix2, int n10) {
        Map map = this.zze;
        zzhd zzhd2 = new zzhd(zzix2, n10);
        return (zzhq)map.get(zzhd2);
    }
}

