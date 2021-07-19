/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.vision;

import com.google.android.gms.vision.MultiProcessor;
import com.google.android.gms.vision.Tracker;
import com.google.android.gms.vision.zze;

public final class MultiProcessor$zza {
    private Tracker zzas;
    private int zzaw = 0;

    private MultiProcessor$zza(MultiProcessor multiProcessor) {
    }

    public /* synthetic */ MultiProcessor$zza(MultiProcessor multiProcessor, zze zze2) {
        this(multiProcessor);
    }

    public static /* synthetic */ int zza(MultiProcessor$zza multiProcessor$zza, int n10) {
        multiProcessor$zza.zzaw = 0;
        return 0;
    }

    public static /* synthetic */ Tracker zza(MultiProcessor$zza multiProcessor$zza) {
        return multiProcessor$zza.zzas;
    }

    public static /* synthetic */ Tracker zza(MultiProcessor$zza multiProcessor$zza, Tracker tracker) {
        multiProcessor$zza.zzas = tracker;
        return tracker;
    }

    public static /* synthetic */ int zzb(MultiProcessor$zza multiProcessor$zza) {
        int n10;
        int n11 = multiProcessor$zza.zzaw;
        multiProcessor$zza.zzaw = n10 = n11 + 1;
        return n11;
    }

    public static /* synthetic */ int zzc(MultiProcessor$zza multiProcessor$zza) {
        return multiProcessor$zza.zzaw;
    }
}

