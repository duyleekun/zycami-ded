/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.zzae;
import com.google.android.gms.measurement.internal.zzdv;
import com.google.android.gms.measurement.internal.zzdw;
import com.google.android.gms.measurement.internal.zzea;
import com.google.android.gms.measurement.internal.zzfl;
import com.google.android.gms.measurement.internal.zzge;
import com.google.android.gms.measurement.internal.zzhn;
import java.util.concurrent.atomic.AtomicReference;

public final class zzgz
implements Runnable {
    public final /* synthetic */ AtomicReference zza;
    public final /* synthetic */ zzhn zzb;

    public zzgz(zzhn zzhn2, AtomicReference atomicReference) {
        this.zzb = zzhn2;
        this.zza = atomicReference;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void run() {
        AtomicReference atomicReference = this.zza;
        synchronized (atomicReference) {
            AtomicReference atomicReference2;
            try {
                atomicReference2 = this.zza;
                Object object = this.zzb;
                object = ((zzge)object).zzx;
                object = ((zzfl)object).zzc();
                Object object2 = this.zzb;
                object2 = ((zzge)object2).zzx;
                object2 = ((zzfl)object2).zzA();
                object2 = ((zzea)object2).zzi();
                zzdv zzdv2 = zzdw.zzJ;
                boolean bl2 = ((zzae)object).zzn((String)object2, zzdv2);
                object = bl2;
                atomicReference2.set(object);
                return;
            }
            finally {
                atomicReference2 = this.zza;
                atomicReference2.notify();
            }
        }
    }
}

