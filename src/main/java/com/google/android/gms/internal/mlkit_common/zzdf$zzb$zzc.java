/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzdj;
import com.google.android.gms.internal.mlkit_common.zzdk;
import com.google.android.gms.internal.mlkit_common.zzfu;
import com.google.android.gms.internal.mlkit_common.zzfv;
import com.google.android.gms.internal.mlkit_common.zzfx;

public final class zzdf$zzb$zzc
extends Enum
implements zzfv {
    private static final /* enum */ zzdf$zzb$zzc zza;
    private static final /* enum */ zzdf$zzb$zzc zzb;
    private static final /* enum */ zzdf$zzb$zzc zzc;
    private static final /* enum */ zzdf$zzb$zzc zzd;
    private static final zzfu zze;
    private static final /* synthetic */ zzdf$zzb$zzc[] zzg;
    private final int zzf;

    static {
        zzdf$zzb$zzc zzdf$zzb$zzc;
        zzdf$zzb$zzc zzdf$zzb$zzc2;
        zzdf$zzb$zzc zzdf$zzb$zzc3;
        Object object = new zzdf$zzb$zzc("LANDMARK_UNKNOWN", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzdf$zzb$zzc3 = new zzdf$zzb$zzc("LANDMARK_NONE", n10, n10);
        int n11 = 2;
        zzc = zzdf$zzb$zzc2 = new zzdf$zzb$zzc("LANDMARK_ALL", n11, n11);
        int n12 = 3;
        zzd = zzdf$zzb$zzc = new zzdf$zzb$zzc("LANDMARK_CONTOUR", n12, n12);
        zzdf$zzb$zzc[] zzdf$zzb$zzcArray = new zzdf$zzb$zzc[4];
        zzdf$zzb$zzcArray[0] = object;
        zzdf$zzb$zzcArray[n10] = zzdf$zzb$zzc3;
        zzdf$zzb$zzcArray[n11] = zzdf$zzb$zzc2;
        zzdf$zzb$zzcArray[n12] = zzdf$zzb$zzc;
        zzg = zzdf$zzb$zzcArray;
        zze = object = new zzdj();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzdf$zzb$zzc() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzf = var3_1;
    }

    public static zzdf$zzb$zzc[] values() {
        return (zzdf$zzb$zzc[])zzg.clone();
    }

    public static zzfx zzb() {
        return zzdk.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzdf$zzb$zzc.class.getName();
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

