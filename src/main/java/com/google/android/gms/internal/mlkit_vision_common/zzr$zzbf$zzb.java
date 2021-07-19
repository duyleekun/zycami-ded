/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzbv;
import com.google.android.gms.internal.mlkit_vision_common.zzbw;
import com.google.android.gms.internal.mlkit_vision_common.zzel;
import com.google.android.gms.internal.mlkit_vision_common.zzen;
import com.google.android.gms.internal.mlkit_vision_common.zzeo;

public final class zzr$zzbf$zzb
extends Enum
implements zzel {
    private static final /* enum */ zzr$zzbf$zzb zza;
    private static final /* enum */ zzr$zzbf$zzb zzb;
    private static final /* enum */ zzr$zzbf$zzb zzc;
    private static final /* enum */ zzr$zzbf$zzb zzd;
    private static final zzeo zze;
    private static final /* synthetic */ zzr$zzbf$zzb[] zzg;
    private final int zzf;

    static {
        zzr$zzbf$zzb zzr$zzbf$zzb;
        zzr$zzbf$zzb zzr$zzbf$zzb2;
        zzr$zzbf$zzb zzr$zzbf$zzb3;
        Object object = new zzr$zzbf$zzb("UNKNOWN", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzr$zzbf$zzb3 = new zzr$zzbf$zzb("CANONICAL", n10, n10);
        int n11 = 2;
        zzc = zzr$zzbf$zzb2 = new zzr$zzbf$zzb("TFLITE", n11, n11);
        int n12 = 3;
        zzd = zzr$zzbf$zzb = new zzr$zzbf$zzb("TFLITE_SUPPORT", n12, n12);
        zzr$zzbf$zzb[] zzr$zzbf$zzbArray = new zzr$zzbf$zzb[4];
        zzr$zzbf$zzbArray[0] = object;
        zzr$zzbf$zzbArray[n10] = zzr$zzbf$zzb3;
        zzr$zzbf$zzbArray[n11] = zzr$zzbf$zzb2;
        zzr$zzbf$zzbArray[n12] = zzr$zzbf$zzb;
        zzg = zzr$zzbf$zzbArray;
        zze = object = new zzbv();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzr$zzbf$zzb() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzf = var3_1;
    }

    public static zzr$zzbf$zzb[] values() {
        return (zzr$zzbf$zzb[])zzg.clone();
    }

    public static zzen zzb() {
        return zzbw.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzr$zzbf$zzb.class.getName();
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

