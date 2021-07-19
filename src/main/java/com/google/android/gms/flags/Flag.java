/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.flags;

import com.google.android.gms.flags.Flag$BooleanFlag;
import com.google.android.gms.flags.Flag$IntegerFlag;
import com.google.android.gms.flags.Flag$LongFlag;
import com.google.android.gms.flags.Flag$StringFlag;
import com.google.android.gms.flags.Singletons;
import com.google.android.gms.flags.zza;
import com.google.android.gms.flags.zzc;

public abstract class Flag {
    private final String mKey;
    private final int zze;
    private final Object zzf;

    private Flag(int n10, String string2, Object object) {
        this.zze = n10;
        this.mKey = string2;
        this.zzf = object;
        Singletons.flagRegistry().zza(this);
    }

    public /* synthetic */ Flag(int n10, String string2, Object object, zza zza2) {
        this(n10, string2, object);
    }

    public static Flag$BooleanFlag define(int n10, String string2, Boolean bl2) {
        Flag$BooleanFlag flag$BooleanFlag = new Flag$BooleanFlag(n10, string2, bl2);
        return flag$BooleanFlag;
    }

    public static Flag$IntegerFlag define(int n10, String string2, int n11) {
        Integer n12 = n11;
        Flag$IntegerFlag flag$IntegerFlag = new Flag$IntegerFlag(n10, string2, n12);
        return flag$IntegerFlag;
    }

    public static Flag$LongFlag define(int n10, String string2, long l10) {
        Long l11 = l10;
        Flag$LongFlag flag$LongFlag = new Flag$LongFlag(n10, string2, l11);
        return flag$LongFlag;
    }

    public static Flag$StringFlag define(int n10, String string2, String string3) {
        Flag$StringFlag flag$StringFlag = new Flag$StringFlag(n10, string2, string3);
        return flag$StringFlag;
    }

    public Object get() {
        return Singletons.zzd().zzb(this);
    }

    public final String getKey() {
        return this.mKey;
    }

    public final int getSource() {
        return this.zze;
    }

    public abstract Object zza(zzc var1);

    public final Object zzb() {
        return this.zzf;
    }
}

