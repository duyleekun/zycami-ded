/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import sun.misc.Unsafe;

public abstract class zziz$zzd {
    public Unsafe zza;

    public zziz$zzd(Unsafe unsafe) {
        this.zza = unsafe;
    }

    public abstract byte zza(Object var1, long var2);

    public abstract void zza(Object var1, long var2, byte var4);

    public abstract void zza(Object var1, long var2, double var4);

    public abstract void zza(Object var1, long var2, float var4);

    public final void zza(Object object, long l10, int n10) {
        this.zza.putInt(object, l10, n10);
    }

    public final void zza(Object object, long l10, long l11) {
        this.zza.putLong(object, l10, l11);
    }

    public abstract void zza(Object var1, long var2, boolean var4);

    public abstract boolean zzb(Object var1, long var2);

    public abstract float zzc(Object var1, long var2);

    public abstract double zzd(Object var1, long var2);

    public final int zze(Object object, long l10) {
        return this.zza.getInt(object, l10);
    }

    public final long zzf(Object object, long l10) {
        return this.zza.getLong(object, l10);
    }
}

