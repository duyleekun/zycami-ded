/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

public final class zzki {
    public final String zza;
    public final String zzb;
    public final String zzc;
    public final long zzd;
    public final Object zze;

    public zzki(String string2, String string3, String string4, long l10, Object object) {
        Preconditions.checkNotEmpty(string2);
        Preconditions.checkNotEmpty(string4);
        Preconditions.checkNotNull(object);
        this.zza = string2;
        this.zzb = string3;
        this.zzc = string4;
        this.zzd = l10;
        this.zze = object;
    }
}

