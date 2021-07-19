/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzfd;
import com.google.android.gms.internal.clearcut.zzfd$zzd;
import sun.misc.Unsafe;

public final class zzfd$zzc
extends zzfd$zzd {
    public zzfd$zzc(Unsafe unsafe) {
        super(unsafe);
    }

    public final void zza(long l10, byte by2) {
        this.zzqa.putByte(l10, by2);
    }

    public final void zza(Object object, long l10, double d10) {
        this.zzqa.putDouble(object, l10, d10);
    }

    public final void zza(Object object, long l10, float f10) {
        this.zzqa.putFloat(object, l10, f10);
    }

    public final void zza(Object object, long l10, boolean bl2) {
        this.zzqa.putBoolean(object, l10, bl2);
    }

    public final void zza(byte[] byArray, long l10, long l11, long l12) {
        Unsafe unsafe = this.zzqa;
        long l13 = zzfd.zzej() + l10;
        unsafe.copyMemory(byArray, l13, null, l11, l12);
    }

    public final void zze(Object object, long l10, byte by2) {
        this.zzqa.putByte(object, l10, by2);
    }

    public final boolean zzl(Object object, long l10) {
        return this.zzqa.getBoolean(object, l10);
    }

    public final float zzm(Object object, long l10) {
        return this.zzqa.getFloat(object, l10);
    }

    public final double zzn(Object object, long l10) {
        return this.zzqa.getDouble(object, l10);
    }

    public final byte zzx(Object object, long l10) {
        return this.zzqa.getByte(object, l10);
    }
}

