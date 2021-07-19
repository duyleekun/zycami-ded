/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.android.gms.vision.clearcut;

import android.content.Context;
import com.google.android.gms.internal.vision.zze;
import com.google.android.gms.internal.vision.zzf;
import com.google.android.gms.internal.vision.zzfl$zzo;
import com.google.android.gms.internal.vision.zzi;
import com.google.android.gms.vision.L;
import com.google.android.gms.vision.clearcut.VisionClearcutLogger;
import com.google.android.gms.vision.clearcut.zza;
import com.google.android.gms.vision.clearcut.zzb;
import java.util.concurrent.ExecutorService;

public class DynamiteClearcutLogger {
    private static final ExecutorService zzbv;
    private zzb zzbw;
    private VisionClearcutLogger zzbx;

    static {
        zzf zzf2 = zze.zzb();
        int n10 = zzi.zzu;
        zzbv = zzf2.zza(2, n10);
    }

    public DynamiteClearcutLogger(Context context) {
        Object object = new zzb(0.03333333333333333);
        this.zzbw = object;
        this.zzbx = object = new VisionClearcutLogger(context);
    }

    public static /* synthetic */ VisionClearcutLogger zza(DynamiteClearcutLogger dynamiteClearcutLogger) {
        return dynamiteClearcutLogger.zzbx;
    }

    public final void zza(int n10, zzfl.zzo zzo2) {
        Object object;
        int n11 = 3;
        if (n10 == n11 && (n11 = (int)(((zzb)(object = this.zzbw)).tryAcquire() ? 1 : 0)) == 0) {
            Object[] objectArray = new Object[]{};
            L.v("Skipping image analysis log due to rate limiting", objectArray);
            return;
        }
        object = zzbv;
        zza zza2 = new zza(this, n10, zzo2);
        object.execute(zza2);
    }
}

