/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.zzfl;
import com.google.android.gms.measurement.internal.zzge;

public abstract class zzgf
extends zzge {
    private boolean zza;

    public zzgf(zzfl zzfl2) {
        super(zzfl2);
        this.zzx.zzJ();
    }

    public abstract boolean zza();

    public void zzay() {
    }

    public final boolean zzu() {
        boolean bl2 = this.zza;
        return bl2;
    }

    public final void zzv() {
        boolean bl2 = this.zzu();
        if (bl2) {
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Not initialized");
        throw illegalStateException;
    }

    public final void zzx() {
        boolean bl2 = this.zza;
        if (!bl2) {
            bl2 = this.zza();
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

    public final void zzy() {
        boolean bl2 = this.zza;
        if (!bl2) {
            this.zzay();
            this.zzx.zzK();
            this.zza = true;
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Can't initialize twice");
        throw illegalStateException;
    }
}

