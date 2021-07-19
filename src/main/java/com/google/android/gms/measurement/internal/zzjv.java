/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.zzju;
import com.google.android.gms.measurement.internal.zzkd;

public abstract class zzjv
extends zzju {
    private boolean zzb;

    public zzjv(zzkd zzkd2) {
        super(zzkd2);
        this.zza.zzP();
    }

    public final boolean zzW() {
        boolean bl2 = this.zzb;
        return bl2;
    }

    public final void zzX() {
        boolean bl2 = this.zzW();
        if (bl2) {
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Not initialized");
        throw illegalStateException;
    }

    public final void zzY() {
        boolean bl2 = this.zzb;
        if (!bl2) {
            this.zzaz();
            this.zza.zzQ();
            this.zzb = true;
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Can't initialize twice");
        throw illegalStateException;
    }

    public abstract boolean zzaz();
}

