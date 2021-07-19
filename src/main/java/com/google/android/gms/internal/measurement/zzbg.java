/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzbr;

public abstract class zzbg
implements Runnable {
    public final long zzh;
    public final long zzi;
    public final boolean zzj;
    public final /* synthetic */ zzbr zzk;

    public zzbg(zzbr zzbr2, boolean bl2) {
        long l10;
        this.zzk = zzbr2;
        this.zzh = l10 = zzbr2.zza.currentTimeMillis();
        this.zzi = l10 = zzbr2.zza.elapsedRealtime();
        this.zzj = bl2;
    }

    public final void run() {
        zzbr zzbr2 = this.zzk;
        boolean bl2 = zzbr.zzK(zzbr2);
        if (bl2) {
            this.zzb();
            return;
        }
        try {
            this.zza();
            return;
        }
        catch (Exception exception) {
            zzbr zzbr3 = this.zzk;
            boolean bl3 = this.zzj;
            zzbr.zzL(zzbr3, exception, false, bl3);
            this.zzb();
            return;
        }
    }

    public abstract void zza();

    public void zzb() {
    }
}

