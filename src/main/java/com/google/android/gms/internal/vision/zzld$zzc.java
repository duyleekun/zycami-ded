/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import sun.misc.Unsafe;

public abstract class zzld$zzc {
    public Unsafe zzadd;

    public zzld$zzc(Unsafe unsafe) {
        this.zzadd = unsafe;
    }

    public abstract void zza(Object var1, long var2, double var4);

    public abstract void zza(Object var1, long var2, float var4);

    public final void zza(Object object, long l10, long l11) {
        this.zzadd.putLong(object, l10, l11);
    }

    public abstract void zza(Object var1, long var2, boolean var4);

    public final void zzb(Object object, long l10, int n10) {
        this.zzadd.putInt(object, l10, n10);
    }

    public abstract void zze(Object var1, long var2, byte var4);

    public final int zzk(Object object, long l10) {
        return this.zzadd.getInt(object, l10);
    }

    public final long zzl(Object object, long l10) {
        return this.zzadd.getLong(object, l10);
    }

    public abstract boolean zzm(Object var1, long var2);

    public abstract float zzn(Object var1, long var2);

    public abstract double zzo(Object var1, long var2);

    public abstract byte zzy(Object var1, long var2);
}

