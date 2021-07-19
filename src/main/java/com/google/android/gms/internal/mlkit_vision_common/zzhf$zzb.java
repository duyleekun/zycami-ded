/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzhf$zzd;
import sun.misc.Unsafe;

public final class zzhf$zzb
extends zzhf$zzd {
    public zzhf$zzb(Unsafe unsafe) {
        super(unsafe);
    }

    public final byte zza(Object object, long l10) {
        return this.zza.getByte(object, l10);
    }

    public final void zza(Object object, long l10, byte by2) {
        this.zza.putByte(object, l10, by2);
    }

    public final void zza(Object object, long l10, double d10) {
        this.zza.putDouble(object, l10, d10);
    }

    public final void zza(Object object, long l10, float f10) {
        this.zza.putFloat(object, l10, f10);
    }

    public final void zza(Object object, long l10, boolean bl2) {
        this.zza.putBoolean(object, l10, bl2);
    }

    public final boolean zzb(Object object, long l10) {
        return this.zza.getBoolean(object, l10);
    }

    public final float zzc(Object object, long l10) {
        return this.zza.getFloat(object, l10);
    }

    public final double zzd(Object object, long l10) {
        return this.zza.getDouble(object, l10);
    }
}

