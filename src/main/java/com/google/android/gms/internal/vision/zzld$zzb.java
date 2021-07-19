/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzld;
import com.google.android.gms.internal.vision.zzld$zzc;
import sun.misc.Unsafe;

public final class zzld$zzb
extends zzld$zzc {
    public zzld$zzb(Unsafe unsafe) {
        super(unsafe);
    }

    public final void zza(Object object, long l10, double d10) {
        long l11 = Double.doubleToLongBits(d10);
        this.zza(object, l10, l11);
    }

    public final void zza(Object object, long l10, float f10) {
        int n10 = Float.floatToIntBits(f10);
        this.zzb(object, l10, n10);
    }

    public final void zza(Object object, long l10, boolean bl2) {
        boolean bl3 = zzld.zzadc;
        if (bl3) {
            zzld.zzd(object, l10, bl2);
            return;
        }
        zzld.zze(object, l10, bl2);
    }

    public final void zze(Object object, long l10, byte by2) {
        boolean bl2 = zzld.zzadc;
        if (bl2) {
            zzld.zzc(object, l10, by2);
            return;
        }
        zzld.zzd(object, l10, by2);
    }

    public final boolean zzm(Object object, long l10) {
        boolean bl2 = zzld.zzadc;
        if (bl2) {
            return zzld.zzw(object, l10);
        }
        return zzld.zzx(object, l10);
    }

    public final float zzn(Object object, long l10) {
        return Float.intBitsToFloat(this.zzk(object, l10));
    }

    public final double zzo(Object object, long l10) {
        return Double.longBitsToDouble(this.zzl(object, l10));
    }

    public final byte zzy(Object object, long l10) {
        boolean bl2 = zzld.zzadc;
        if (bl2) {
            return zzld.zzu(object, l10);
        }
        return zzld.zzv(object, l10);
    }
}

