/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.zzes;
import com.google.android.gms.measurement.internal.zzeu;
import com.google.android.gms.measurement.internal.zzfl;
import com.google.android.gms.measurement.internal.zzge;
import com.google.android.gms.measurement.internal.zzhn;

public final class zzgp
implements Runnable {
    private final zzhn zza;

    public zzgp(zzhn zzhn2) {
        this.zza = zzhn2;
    }

    public final void run() {
        zzhn zzhn2 = this.zza;
        ((zzge)zzhn2).zzg();
        Object object = zzhn2.zzx.zzd().zzr;
        boolean n10 = ((zzes)object).zza();
        if (!n10) {
            object = zzhn2.zzx.zzd().zzs;
            long l10 = ((zzeu)object).zza();
            Object object2 = zzhn2.zzx.zzd().zzs;
            long l11 = 1L + l10;
            ((zzeu)object2).zzb(l11);
            object2 = zzhn2.zzx;
            ((zzfl)object2).zzc();
            long l12 = 5;
            long l13 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
            if (l13 >= 0) {
                zzhn2.zzx.zzat().zze().zza("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
                zzhn2.zzx.zzd().zzr.zzb(true);
                return;
            }
            zzhn2.zzx.zzM();
            return;
        }
        zzhn2.zzx.zzat().zzj().zza("Deferred Deep Link already retrieved. Not fetching again.");
    }
}

