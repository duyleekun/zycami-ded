/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzdl;
import com.google.android.gms.internal.mlkit_common.zzdm;
import com.google.android.gms.internal.mlkit_common.zzfu;
import com.google.android.gms.internal.mlkit_common.zzfv;
import com.google.android.gms.internal.mlkit_common.zzfx;

public final class zzdf$zzb$zzd
extends Enum
implements zzfv {
    private static final /* enum */ zzdf$zzb$zzd zza;
    private static final /* enum */ zzdf$zzb$zzd zzb;
    private static final /* enum */ zzdf$zzb$zzd zzc;
    private static final /* enum */ zzdf$zzb$zzd zzd;
    private static final zzfu zze;
    private static final /* synthetic */ zzdf$zzb$zzd[] zzg;
    private final int zzf;

    static {
        zzdf$zzb$zzd zzdf$zzb$zzd;
        zzdf$zzb$zzd zzdf$zzb$zzd2;
        zzdf$zzb$zzd zzdf$zzb$zzd3;
        Object object = new zzdf$zzb$zzd("MODE_UNKNOWN", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzdf$zzb$zzd3 = new zzdf$zzb$zzd("MODE_ACCURATE", n10, n10);
        int n11 = 2;
        zzc = zzdf$zzb$zzd2 = new zzdf$zzb$zzd("MODE_FAST", n11, n11);
        int n12 = 3;
        zzd = zzdf$zzb$zzd = new zzdf$zzb$zzd("MODE_SELFIE", n12, n12);
        zzdf$zzb$zzd[] zzdf$zzb$zzdArray = new zzdf$zzb$zzd[4];
        zzdf$zzb$zzdArray[0] = object;
        zzdf$zzb$zzdArray[n10] = zzdf$zzb$zzd3;
        zzdf$zzb$zzdArray[n11] = zzdf$zzb$zzd2;
        zzdf$zzb$zzdArray[n12] = zzdf$zzb$zzd;
        zzg = zzdf$zzb$zzdArray;
        zze = object = new zzdm();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzdf$zzb$zzd() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzf = var3_1;
    }

    public static zzdf$zzb$zzd[] values() {
        return (zzdf$zzb$zzd[])zzg.clone();
    }

    public static zzfx zzb() {
        return zzdl.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzdf$zzb$zzd.class.getName();
        stringBuilder.append(string2);
        stringBuilder.append('@');
        string2 = Integer.toHexString(System.identityHashCode(this));
        stringBuilder.append(string2);
        stringBuilder.append(" number=");
        int n10 = this.zzf;
        stringBuilder.append(n10);
        stringBuilder.append(" name=");
        string2 = this.name();
        stringBuilder.append(string2);
        stringBuilder.append('>');
        return stringBuilder.toString();
    }

    public final int zza() {
        return this.zzf;
    }
}

