/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzld$zzc;
import sun.misc.Unsafe;

public final class zzld$zzd
extends zzld$zzc {
    public zzld$zzd(Unsafe unsafe) {
        super(unsafe);
    }

    public final void zza(Object object, long l10, double d10) {
        this.zzadd.putDouble(object, l10, d10);
    }

    public final void zza(Object object, long l10, float f10) {
        this.zzadd.putFloat(object, l10, f10);
    }

    public final void zza(Object object, long l10, boolean bl2) {
        this.zzadd.putBoolean(object, l10, bl2);
    }

    public final void zze(Object object, long l10, byte by2) {
        this.zzadd.putByte(object, l10, by2);
    }

    public final boolean zzm(Object object, long l10) {
        return this.zzadd.getBoolean(object, l10);
    }

    public final float zzn(Object object, long l10) {
        return this.zzadd.getFloat(object, l10);
    }

    public final double zzo(Object object, long l10) {
        return this.zzadd.getDouble(object, l10);
    }

    public final byte zzy(Object object, long l10) {
        return this.zzadd.getByte(object, l10);
    }
}

