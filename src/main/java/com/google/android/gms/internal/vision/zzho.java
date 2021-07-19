/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzho$zza;
import com.google.android.gms.internal.vision.zzic;
import com.google.android.gms.internal.vision.zzid$zzg;
import com.google.android.gms.internal.vision.zzjn;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class zzho {
    private static volatile boolean zzur = false;
    private static boolean zzus = true;
    private static volatile zzho zzut;
    private static volatile zzho zzuu;
    private static final zzho zzuv;
    private final Map zzuw;

    static {
        zzho zzho2;
        zzuv = zzho2 = new zzho(true);
    }

    public zzho() {
        HashMap hashMap;
        this.zzuw = hashMap = new HashMap();
    }

    private zzho(boolean bl2) {
        Map map;
        this.zzuw = map = Collections.emptyMap();
    }

    public static zzho zzge() {
        zzho zzho2 = new zzho();
        return zzho2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static zzho zzgf() {
        zzho zzho2 = zzut;
        if (zzho2 != null) return zzho2;
        Class<zzho> clazz = zzho.class;
        synchronized (clazz) {
            zzho2 = zzut;
            if (zzho2 != null) return zzho2;
            zzut = zzho2 = zzuv;
            return zzho2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static zzho zzgg() {
        Class<zzho> clazz = zzho.class;
        zzho zzho2 = zzuu;
        if (zzho2 != null) {
            return zzho2;
        }
        synchronized (clazz) {
            zzho2 = zzuu;
            if (zzho2 != null) {
                return zzho2;
            }
            zzuu = zzho2 = zzic.zzc(clazz);
            return zzho2;
        }
    }

    public final zzid$zzg zza(zzjn zzjn2, int n10) {
        Map map = this.zzuw;
        zzho$zza zzho$zza = new zzho$zza(zzjn2, n10);
        return (zzid$zzg)map.get(zzho$zza);
    }

    public final void zza(zzid$zzg zzid$zzg) {
        Map map = this.zzuw;
        zzjn zzjn2 = zzid$zzg.zzyp;
        int n10 = zzid$zzg.zzyr.number;
        zzho$zza zzho$zza = new zzho$zza(zzjn2, n10);
        map.put(zzho$zza, zzid$zzg);
    }
}

