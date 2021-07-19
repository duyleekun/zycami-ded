/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzcj;
import com.google.android.gms.internal.mlkit_vision_common.zzck;
import com.google.android.gms.internal.mlkit_vision_common.zzel;
import com.google.android.gms.internal.mlkit_vision_common.zzen;
import com.google.android.gms.internal.mlkit_vision_common.zzeo;

public final class zzcc$zzb$zzd
extends Enum
implements zzel {
    private static final /* enum */ zzcc$zzb$zzd zza;
    private static final /* enum */ zzcc$zzb$zzd zzb;
    private static final /* enum */ zzcc$zzb$zzd zzc;
    private static final /* enum */ zzcc$zzb$zzd zzd;
    private static final zzeo zze;
    private static final /* synthetic */ zzcc$zzb$zzd[] zzg;
    private final int zzf;

    static {
        zzcc$zzb$zzd zzcc$zzb$zzd;
        zzcc$zzb$zzd zzcc$zzb$zzd2;
        zzcc$zzb$zzd zzcc$zzb$zzd3;
        Object object = new zzcc$zzb$zzd("MODE_UNKNOWN", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzcc$zzb$zzd3 = new zzcc$zzb$zzd("MODE_ACCURATE", n10, n10);
        int n11 = 2;
        zzc = zzcc$zzb$zzd2 = new zzcc$zzb$zzd("MODE_FAST", n11, n11);
        int n12 = 3;
        zzd = zzcc$zzb$zzd = new zzcc$zzb$zzd("MODE_SELFIE", n12, n12);
        zzcc$zzb$zzd[] zzcc$zzb$zzdArray = new zzcc$zzb$zzd[4];
        zzcc$zzb$zzdArray[0] = object;
        zzcc$zzb$zzdArray[n10] = zzcc$zzb$zzd3;
        zzcc$zzb$zzdArray[n11] = zzcc$zzb$zzd2;
        zzcc$zzb$zzdArray[n12] = zzcc$zzb$zzd;
        zzg = zzcc$zzb$zzdArray;
        zze = object = new zzcj();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzcc$zzb$zzd() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzf = var3_1;
    }

    public static zzcc$zzb$zzd[] values() {
        return (zzcc$zzb$zzd[])zzg.clone();
    }

    public static zzen zzb() {
        return zzck.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzcc$zzb$zzd.class.getName();
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

