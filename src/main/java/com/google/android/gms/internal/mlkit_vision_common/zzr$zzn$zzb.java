/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzel;
import com.google.android.gms.internal.mlkit_vision_common.zzen;
import com.google.android.gms.internal.mlkit_vision_common.zzeo;
import com.google.android.gms.internal.mlkit_vision_common.zzx;
import com.google.android.gms.internal.mlkit_vision_common.zzy;

public final class zzr$zzn$zzb
extends Enum
implements zzel {
    private static final /* enum */ zzr$zzn$zzb zza;
    private static final /* enum */ zzr$zzn$zzb zzb;
    private static final /* enum */ zzr$zzn$zzb zzc;
    private static final zzeo zzd;
    private static final /* synthetic */ zzr$zzn$zzb[] zzf;
    private final int zze;

    static {
        zzr$zzn$zzb zzr$zzn$zzb;
        zzr$zzn$zzb zzr$zzn$zzb2;
        Object object = new zzr$zzn$zzb("UNKNOWN_MODEL_TYPE", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzr$zzn$zzb2 = new zzr$zzn$zzb("STABLE_MODEL", n10, n10);
        int n11 = 2;
        zzc = zzr$zzn$zzb = new zzr$zzn$zzb("LATEST_MODEL", n11, n11);
        zzr$zzn$zzb[] zzr$zzn$zzbArray = new zzr$zzn$zzb[3];
        zzr$zzn$zzbArray[0] = object;
        zzr$zzn$zzbArray[n10] = zzr$zzn$zzb2;
        zzr$zzn$zzbArray[n11] = zzr$zzn$zzb;
        zzf = zzr$zzn$zzbArray;
        zzd = object = new zzx();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzr$zzn$zzb() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zze = var3_1;
    }

    public static zzr$zzn$zzb[] values() {
        return (zzr$zzn$zzb[])zzf.clone();
    }

    public static zzen zzb() {
        return zzy.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzr$zzn$zzb.class.getName();
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

