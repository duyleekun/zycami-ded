/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzbr;
import com.google.android.gms.internal.mlkit_vision_common.zzbs;
import com.google.android.gms.internal.mlkit_vision_common.zzel;
import com.google.android.gms.internal.mlkit_vision_common.zzen;
import com.google.android.gms.internal.mlkit_vision_common.zzeo;

public final class zzr$zzbc$zzb
extends Enum
implements zzel {
    private static final /* enum */ zzr$zzbc$zzb zza;
    private static final /* enum */ zzr$zzbc$zzb zzb;
    private static final /* enum */ zzr$zzbc$zzb zzc;
    private static final /* enum */ zzr$zzbc$zzb zzd;
    private static final /* enum */ zzr$zzbc$zzb zze;
    private static final /* enum */ zzr$zzbc$zzb zzf;
    private static final /* enum */ zzr$zzbc$zzb zzg;
    private static final zzeo zzh;
    private static final /* synthetic */ zzr$zzbc$zzb[] zzj;
    private final int zzi;

    static {
        zzr$zzbc$zzb zzr$zzbc$zzb;
        zzr$zzbc$zzb zzr$zzbc$zzb2;
        zzr$zzbc$zzb zzr$zzbc$zzb3;
        zzr$zzbc$zzb zzr$zzbc$zzb4;
        zzr$zzbc$zzb zzr$zzbc$zzb5;
        zzr$zzbc$zzb zzr$zzbc$zzb6;
        Object object = new zzr$zzbc$zzb("NO_ERROR", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzr$zzbc$zzb6 = new zzr$zzbc$zzb("STATUS_SENSITIVE_TOPIC", n10, n10);
        int n11 = 2;
        zzc = zzr$zzbc$zzb5 = new zzr$zzbc$zzb("STATUS_QUALITY_THRESHOLDED", n11, n11);
        int n12 = 3;
        zzd = zzr$zzbc$zzb4 = new zzr$zzbc$zzb("STATUS_INTERNAL_ERROR", n12, n12);
        int n13 = 4;
        zze = zzr$zzbc$zzb3 = new zzr$zzbc$zzb("STATUS_NOT_SUPPORTED_LANGUAGE", n13, 101);
        int n14 = 5;
        zzf = zzr$zzbc$zzb2 = new zzr$zzbc$zzb("STATUS_32_BIT_CPU", n14, 1001);
        int n15 = 6;
        zzg = zzr$zzbc$zzb = new zzr$zzbc$zzb("STATUS_32_BIT_APP", n15, 1002);
        zzr$zzbc$zzb[] zzr$zzbc$zzbArray = new zzr$zzbc$zzb[7];
        zzr$zzbc$zzbArray[0] = object;
        zzr$zzbc$zzbArray[n10] = zzr$zzbc$zzb6;
        zzr$zzbc$zzbArray[n11] = zzr$zzbc$zzb5;
        zzr$zzbc$zzbArray[n12] = zzr$zzbc$zzb4;
        zzr$zzbc$zzbArray[n13] = zzr$zzbc$zzb3;
        zzr$zzbc$zzbArray[n14] = zzr$zzbc$zzb2;
        zzr$zzbc$zzbArray[n15] = zzr$zzbc$zzb;
        zzj = zzr$zzbc$zzbArray;
        zzh = object = new zzbr();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzr$zzbc$zzb() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzi = var3_1;
    }

    public static zzr$zzbc$zzb[] values() {
        return (zzr$zzbc$zzb[])zzj.clone();
    }

    public static zzen zzb() {
        return zzbs.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzr$zzbc$zzb.class.getName();
        stringBuilder.append(string2);
        stringBuilder.append('@');
        string2 = Integer.toHexString(System.identityHashCode(this));
        stringBuilder.append(string2);
        stringBuilder.append(" number=");
        int n10 = this.zzi;
        stringBuilder.append(n10);
        stringBuilder.append(" name=");
        string2 = this.name();
        stringBuilder.append(string2);
        stringBuilder.append('>');
        return stringBuilder.toString();
    }

    public final int zza() {
        return this.zzi;
    }
}

