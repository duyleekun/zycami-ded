/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzeg;
import com.google.android.gms.measurement.internal.zzei;
import com.google.android.gms.measurement.internal.zzfi;
import com.google.android.gms.measurement.internal.zzfl;
import com.google.android.gms.measurement.internal.zzge;

public final class zzff
implements Thread.UncaughtExceptionHandler {
    public final /* synthetic */ zzfi zza;
    private final String zzb;

    public zzff(zzfi zzfi2, String string2) {
        this.zza = zzfi2;
        Preconditions.checkNotNull(string2);
        this.zzb = string2;
    }

    public final void uncaughtException(Thread object, Throwable throwable) {
        synchronized (this) {
            object = this.zza;
            object = ((zzge)object).zzx;
            object = ((zzfl)object).zzat();
            object = ((zzei)object).zzb();
            String string2 = this.zzb;
            ((zzeg)object).zzb(string2, throwable);
            return;
        }
    }
}

