/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.vision.clearcut;

import com.google.android.gms.internal.vision.zzfl$zzo;
import com.google.android.gms.vision.clearcut.DynamiteClearcutLogger;
import com.google.android.gms.vision.clearcut.VisionClearcutLogger;

public final class zza
implements Runnable {
    private final /* synthetic */ int zzby;
    private final /* synthetic */ zzfl$zzo zzbz;
    private final /* synthetic */ DynamiteClearcutLogger zzca;

    public zza(DynamiteClearcutLogger dynamiteClearcutLogger, int n10, zzfl$zzo zzfl$zzo) {
        this.zzca = dynamiteClearcutLogger;
        this.zzby = n10;
        this.zzbz = zzfl$zzo;
    }

    public final void run() {
        VisionClearcutLogger visionClearcutLogger = DynamiteClearcutLogger.zza(this.zzca);
        int n10 = this.zzby;
        zzfl$zzo zzfl$zzo = this.zzbz;
        visionClearcutLogger.zzb(n10, zzfl$zzo);
    }
}

