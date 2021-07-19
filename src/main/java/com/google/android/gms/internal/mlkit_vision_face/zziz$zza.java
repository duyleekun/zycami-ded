/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zziz;
import com.google.android.gms.internal.mlkit_vision_face.zziz$zzd;
import sun.misc.Unsafe;

public final class zziz$zza
extends zziz$zzd {
    public zziz$zza(Unsafe unsafe) {
        super(unsafe);
    }

    public final byte zza(Object object, long l10) {
        boolean bl2 = zziz.zza;
        if (bl2) {
            return zziz.zzg(object, l10);
        }
        return zziz.zzh(object, l10);
    }

    public final void zza(Object object, long l10, byte by2) {
        boolean bl2 = zziz.zza;
        if (bl2) {
            zziz.zza(object, l10, by2);
            return;
        }
        zziz.zzb(object, l10, by2);
    }

    public final void zza(Object object, long l10, double d10) {
        long l11 = Double.doubleToLongBits(d10);
        this.zza(object, l10, l11);
    }

    public final void zza(Object object, long l10, float f10) {
        int n10 = Float.floatToIntBits(f10);
        this.zza(object, l10, n10);
    }

    public final void zza(Object object, long l10, boolean bl2) {
        boolean bl3 = zziz.zza;
        if (bl3) {
            zziz.zzb(object, l10, bl2);
            return;
        }
        zziz.zzc(object, l10, bl2);
    }

    public final boolean zzb(Object object, long l10) {
        boolean bl2 = zziz.zza;
        if (bl2) {
            return zziz.zzi(object, l10);
        }
        return zziz.zzj(object, l10);
    }

    public final float zzc(Object object, long l10) {
        return Float.intBitsToFloat(this.zze(object, l10));
    }

    public final double zzd(Object object, long l10) {
        return Double.longBitsToDouble(this.zzf(object, l10));
    }
}

