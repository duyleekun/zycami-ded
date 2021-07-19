/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 */
package com.google.android.gms.measurement.internal;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzl;
import com.google.android.gms.measurement.internal.zzak;
import com.google.android.gms.measurement.internal.zzeg;
import com.google.android.gms.measurement.internal.zzgg;

public abstract class zzal {
    private static volatile Handler zzb;
    private final zzgg zza;
    private final Runnable zzc;
    private volatile long zzd;

    public zzal(zzgg zzgg2) {
        Preconditions.checkNotNull(zzgg2);
        this.zza = zzgg2;
        zzak zzak2 = new zzak(this, zzgg2);
        this.zzc = zzak2;
    }

    public static /* synthetic */ long zze(zzal zzal2, long l10) {
        zzal2.zzd = l10 = 0L;
        return l10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final Handler zzf() {
        Object object = zzb;
        if (object != null) {
            return zzb;
        }
        object = zzal.class;
        synchronized (object) {
            Handler handler = zzb;
            if (handler != null) return zzb;
            zzgg zzgg2 = this.zza;
            zzgg2 = zzgg2.zzaw();
            zzgg2 = zzgg2.getMainLooper();
            zzb = handler = new zzl((Looper)zzgg2);
            return zzb;
        }
    }

    public abstract void zza();

    public final void zzb(long l10) {
        this.zzd();
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 >= 0) {
            Runnable runnable;
            this.zzd = l11 = this.zza.zzax().currentTimeMillis();
            Object object = this.zzf();
            l12 = (long)object.postDelayed(runnable = this.zzc, l10);
            if (l12 == false) {
                object = this.zza.zzat().zzb();
                Long l13 = l10;
                String string2 = "Failed to schedule delayed post. time";
                ((zzeg)object).zzb(string2, l13);
            }
        }
    }

    public final boolean zzc() {
        long l10 = this.zzd;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        return object != false;
    }

    public final void zzd() {
        this.zzd = 0L;
        Handler handler = this.zzf();
        Runnable runnable = this.zzc;
        handler.removeCallbacks(runnable);
    }
}

