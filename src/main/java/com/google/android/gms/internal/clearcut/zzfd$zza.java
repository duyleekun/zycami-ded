/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  libcore.io.Memory
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzfd;
import com.google.android.gms.internal.clearcut.zzfd$zzd;
import libcore.io.Memory;
import sun.misc.Unsafe;

public final class zzfd$zza
extends zzfd$zzd {
    public zzfd$zza(Unsafe unsafe) {
        super(unsafe);
    }

    public final void zza(long l10, byte by2) {
        Memory.pokeByte((int)((int)(l10 & (long)-1)), (byte)by2);
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
        boolean bl3 = zzfd.zzah();
        if (bl3) {
            zzfd.zzd(object, l10, bl2);
            return;
        }
        zzfd.zze(object, l10, bl2);
    }

    public final void zza(byte[] byArray, long l10, long l11, long l12) {
        int n10 = (int)(l11 & (long)-1);
        int n11 = (int)l10;
        int n12 = (int)l12;
        Memory.pokeByteArray((int)n10, (byte[])byArray, (int)n11, (int)n12);
    }

    public final void zze(Object object, long l10, byte by2) {
        boolean bl2 = zzfd.zzah();
        if (bl2) {
            zzfd.zzc(object, l10, by2);
            return;
        }
        zzfd.zzd(object, l10, by2);
    }

    public final boolean zzl(Object object, long l10) {
        boolean bl2 = zzfd.zzah();
        if (bl2) {
            return zzfd.zzv(object, l10);
        }
        return zzfd.zzw(object, l10);
    }

    public final float zzm(Object object, long l10) {
        return Float.intBitsToFloat(this.zzj(object, l10));
    }

    public final double zzn(Object object, long l10) {
        return Double.longBitsToDouble(this.zzk(object, l10));
    }

    public final byte zzx(Object object, long l10) {
        boolean bl2 = zzfd.zzah();
        if (bl2) {
            return zzfd.zzt(object, l10);
        }
        return zzfd.zzu(object, l10);
    }
}

