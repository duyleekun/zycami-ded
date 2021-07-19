/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

public abstract class zzfd$zzd {
    public Unsafe zzqa;

    public zzfd$zzd(Unsafe unsafe) {
        this.zzqa = unsafe;
    }

    public final long zza(Field field) {
        return this.zzqa.objectFieldOffset(field);
    }

    public abstract void zza(long var1, byte var3);

    public abstract void zza(Object var1, long var2, double var4);

    public abstract void zza(Object var1, long var2, float var4);

    public final void zza(Object object, long l10, int n10) {
        this.zzqa.putInt(object, l10, n10);
    }

    public final void zza(Object object, long l10, long l11) {
        this.zzqa.putLong(object, l10, l11);
    }

    public abstract void zza(Object var1, long var2, boolean var4);

    public abstract void zza(byte[] var1, long var2, long var4, long var6);

    public abstract void zze(Object var1, long var2, byte var4);

    public final int zzj(Object object, long l10) {
        return this.zzqa.getInt(object, l10);
    }

    public final long zzk(Object object, long l10) {
        return this.zzqa.getLong(object, l10);
    }

    public abstract boolean zzl(Object var1, long var2);

    public abstract float zzm(Object var1, long var2);

    public abstract double zzn(Object var1, long var2);

    public abstract byte zzx(Object var1, long var2);
}

