/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzkg;
import com.google.android.gms.internal.measurement.zzkh;
import sun.misc.Unsafe;

public final class zzke
extends zzkg {
    public zzke(Unsafe unsafe) {
        super(unsafe);
    }

    public final byte zza(Object object, long l10) {
        boolean bl2 = zzkh.zzb;
        if (bl2) {
            return zzkh.zzu(object, l10);
        }
        return zzkh.zzv(object, l10);
    }

    public final void zzb(Object object, long l10, byte by2) {
        boolean bl2 = zzkh.zzb;
        if (bl2) {
            zzkh.zzw(object, l10, by2);
            return;
        }
        zzkh.zzx(object, l10, by2);
    }

    public final boolean zzc(Object object, long l10) {
        boolean bl2 = zzkh.zzb;
        if (bl2) {
            return zzkh.zzy(object, l10);
        }
        return zzkh.zzz(object, l10);
    }

    public final void zzd(Object object, long l10, boolean bl2) {
        boolean bl3 = zzkh.zzb;
        if (bl3) {
            zzkh.zzA(object, l10, bl2);
            return;
        }
        zzkh.zzB(object, l10, bl2);
    }

    public final float zze(Object object, long l10) {
        return Float.intBitsToFloat(this.zzn(object, l10));
    }

    public final void zzf(Object object, long l10, float f10) {
        int n10 = Float.floatToIntBits(f10);
        this.zzo(object, l10, n10);
    }

    public final double zzg(Object object, long l10) {
        return Double.longBitsToDouble(this.zzp(object, l10));
    }

    public final void zzh(Object object, long l10, double d10) {
        long l11 = Double.doubleToLongBits(d10);
        this.zzq(object, l10, l11);
    }
}

