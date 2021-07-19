/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.zze;
import com.google.android.gms.measurement.internal.zzfl;

public abstract class zzf
extends zze {
    private boolean zza;

    public zzf(zzfl zzfl2) {
        super(zzfl2);
        this.zzx.zzJ();
    }

    public final boolean zza() {
        boolean bl2 = this.zza;
        return bl2;
    }

    public final void zzb() {
        boolean bl2 = this.zza();
        if (bl2) {
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Not initialized");
        throw illegalStateException;
    }

    public final void zzc() {
        boolean bl2 = this.zza;
        if (!bl2) {
            bl2 = this.zze();
            if (!bl2) {
                zzfl zzfl2 = this.zzx;
                zzfl2.zzK();
                this.zza = bl2 = true;
            }
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Can't initialize twice");
        throw illegalStateException;
    }

    public final void zzd() {
        boolean bl2 = this.zza;
        if (!bl2) {
            this.zzf();
            this.zzx.zzK();
            this.zza = true;
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Can't initialize twice");
        throw illegalStateException;
    }

    public abstract boolean zze();

    public void zzf() {
    }
}

