/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 */
package com.google.android.gms.common.stats;

import android.content.ComponentName;

public final class LoggingConstants {
    public static final String EXTRA_WAKE_LOCK_KEY = "WAKE_LOCK_KEY";
    public static final ComponentName zza;
    private static int zzb;
    private static int zzc;
    private static int zzd;
    private static int zze;
    private static int zzf;
    private static int zzg;
    private static int zzh;
    private static int zzi;

    static {
        int n10;
        ComponentName componentName;
        zza = componentName = new ComponentName("com.google.android.gms", "com.google.android.gms.common.stats.GmsCoreStatsService");
        zzb = 0;
        zzc = n10 = 1;
        zzd = 2;
        zze = 4;
        zzf = 8;
        zzg = 16;
        zzh = 32;
        zzi = n10;
    }

    private LoggingConstants() {
    }
}

