/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzel;
import com.google.android.gms.internal.mlkit_vision_common.zzen;
import com.google.android.gms.internal.mlkit_vision_common.zzeo;
import com.google.android.gms.internal.mlkit_vision_common.zzij;
import com.google.android.gms.internal.mlkit_vision_common.zzik;

public final class zzhv$zzk$zzb
extends Enum
implements zzel {
    private static final /* enum */ zzhv$zzk$zzb zza;
    private static final /* enum */ zzhv$zzk$zzb zzb;
    private static final /* enum */ zzhv$zzk$zzb zzc;
    private static final /* enum */ zzhv$zzk$zzb zzd;
    private static final zzeo zze;
    private static final /* synthetic */ zzhv$zzk$zzb[] zzg;
    private final int zzf;

    static {
        zzhv$zzk$zzb zzhv$zzk$zzb;
        zzhv$zzk$zzb zzhv$zzk$zzb2;
        zzhv$zzk$zzb zzhv$zzk$zzb3;
        Object object = new zzhv$zzk$zzb("UNKNOWN_METRIC", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzhv$zzk$zzb3 = new zzhv$zzk$zzb("MEAN_ABSOLUTE_ERROR", n10, n10);
        int n11 = 2;
        zzc = zzhv$zzk$zzb2 = new zzhv$zzk$zzb("MEAN_SQUARED_ERROR", n11, n11);
        int n12 = 3;
        zzd = zzhv$zzk$zzb = new zzhv$zzk$zzb("ROOT_MEAN_SQUARED_ERROR", n12, n12);
        zzhv$zzk$zzb[] zzhv$zzk$zzbArray = new zzhv$zzk$zzb[4];
        zzhv$zzk$zzbArray[0] = object;
        zzhv$zzk$zzbArray[n10] = zzhv$zzk$zzb3;
        zzhv$zzk$zzbArray[n11] = zzhv$zzk$zzb2;
        zzhv$zzk$zzbArray[n12] = zzhv$zzk$zzb;
        zzg = zzhv$zzk$zzbArray;
        zze = object = new zzij();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzhv$zzk$zzb() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzf = var3_1;
    }

    public static zzhv$zzk$zzb[] values() {
        return (zzhv$zzk$zzb[])zzg.clone();
    }

    public static zzen zzb() {
        return zzik.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzhv$zzk$zzb.class.getName();
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

