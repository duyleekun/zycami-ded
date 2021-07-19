/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzdh;
import com.google.android.gms.internal.mlkit_common.zzdi;
import com.google.android.gms.internal.mlkit_common.zzfu;
import com.google.android.gms.internal.mlkit_common.zzfv;
import com.google.android.gms.internal.mlkit_common.zzfx;

public final class zzdf$zzb$zza
extends Enum
implements zzfv {
    private static final /* enum */ zzdf$zzb$zza zza;
    private static final /* enum */ zzdf$zzb$zza zzb;
    private static final /* enum */ zzdf$zzb$zza zzc;
    private static final zzfu zzd;
    private static final /* synthetic */ zzdf$zzb$zza[] zzf;
    private final int zze;

    static {
        zzdf$zzb$zza zzdf$zzb$zza;
        zzdf$zzb$zza zzdf$zzb$zza2;
        Object object = new zzdf$zzb$zza("CLASSIFICATION_UNKNOWN", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzdf$zzb$zza2 = new zzdf$zzb$zza("CLASSIFICATION_NONE", n10, n10);
        int n11 = 2;
        zzc = zzdf$zzb$zza = new zzdf$zzb$zza("CLASSIFICATION_ALL", n11, n11);
        zzdf$zzb$zza[] zzdf$zzb$zzaArray = new zzdf$zzb$zza[3];
        zzdf$zzb$zzaArray[0] = object;
        zzdf$zzb$zzaArray[n10] = zzdf$zzb$zza2;
        zzdf$zzb$zzaArray[n11] = zzdf$zzb$zza;
        zzf = zzdf$zzb$zzaArray;
        zzd = object = new zzdi();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzdf$zzb$zza() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zze = var3_1;
    }

    public static zzdf$zzb$zza[] values() {
        return (zzdf$zzb$zza[])zzf.clone();
    }

    public static zzfx zzb() {
        return zzdh.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzdf$zzb$zza.class.getName();
        stringBuilder.append(string2);
        stringBuilder.append('@');
        string2 = Integer.toHexString(System.identityHashCode(this));
        stringBuilder.append(string2);
        stringBuilder.append(" number=");
        int n10 = this.zze;
        stringBuilder.append(n10);
        stringBuilder.append(" name=");
        string2 = this.name();
        stringBuilder.append(string2);
        stringBuilder.append('>');
        return stringBuilder.toString();
    }

    public final int zza() {
        return this.zze;
    }
}

