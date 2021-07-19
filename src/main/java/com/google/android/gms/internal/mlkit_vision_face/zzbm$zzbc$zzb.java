/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzdm;
import com.google.android.gms.internal.mlkit_vision_face.zzdn;
import com.google.android.gms.internal.mlkit_vision_face.zzgf;
import com.google.android.gms.internal.mlkit_vision_face.zzgh;
import com.google.android.gms.internal.mlkit_vision_face.zzgi;

public final class zzbm$zzbc$zzb
extends Enum
implements zzgf {
    private static final /* enum */ zzbm$zzbc$zzb zza;
    private static final /* enum */ zzbm$zzbc$zzb zzb;
    private static final /* enum */ zzbm$zzbc$zzb zzc;
    private static final /* enum */ zzbm$zzbc$zzb zzd;
    private static final /* enum */ zzbm$zzbc$zzb zze;
    private static final /* enum */ zzbm$zzbc$zzb zzf;
    private static final /* enum */ zzbm$zzbc$zzb zzg;
    private static final zzgi zzh;
    private static final /* synthetic */ zzbm$zzbc$zzb[] zzj;
    private final int zzi;

    static {
        zzbm$zzbc$zzb zzbm$zzbc$zzb;
        zzbm$zzbc$zzb zzbm$zzbc$zzb2;
        zzbm$zzbc$zzb zzbm$zzbc$zzb3;
        zzbm$zzbc$zzb zzbm$zzbc$zzb4;
        zzbm$zzbc$zzb zzbm$zzbc$zzb5;
        zzbm$zzbc$zzb zzbm$zzbc$zzb6;
        Object object = new zzbm$zzbc$zzb("NO_ERROR", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzbm$zzbc$zzb6 = new zzbm$zzbc$zzb("STATUS_SENSITIVE_TOPIC", n10, n10);
        int n11 = 2;
        zzc = zzbm$zzbc$zzb5 = new zzbm$zzbc$zzb("STATUS_QUALITY_THRESHOLDED", n11, n11);
        int n12 = 3;
        zzd = zzbm$zzbc$zzb4 = new zzbm$zzbc$zzb("STATUS_INTERNAL_ERROR", n12, n12);
        int n13 = 4;
        zze = zzbm$zzbc$zzb3 = new zzbm$zzbc$zzb("STATUS_NOT_SUPPORTED_LANGUAGE", n13, 101);
        int n14 = 5;
        zzf = zzbm$zzbc$zzb2 = new zzbm$zzbc$zzb("STATUS_32_BIT_CPU", n14, 1001);
        int n15 = 6;
        zzg = zzbm$zzbc$zzb = new zzbm$zzbc$zzb("STATUS_32_BIT_APP", n15, 1002);
        zzbm$zzbc$zzb[] zzbm$zzbc$zzbArray = new zzbm$zzbc$zzb[7];
        zzbm$zzbc$zzbArray[0] = object;
        zzbm$zzbc$zzbArray[n10] = zzbm$zzbc$zzb6;
        zzbm$zzbc$zzbArray[n11] = zzbm$zzbc$zzb5;
        zzbm$zzbc$zzbArray[n12] = zzbm$zzbc$zzb4;
        zzbm$zzbc$zzbArray[n13] = zzbm$zzbc$zzb3;
        zzbm$zzbc$zzbArray[n14] = zzbm$zzbc$zzb2;
        zzbm$zzbc$zzbArray[n15] = zzbm$zzbc$zzb;
        zzj = zzbm$zzbc$zzbArray;
        zzh = object = new zzdm();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzbm$zzbc$zzb() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzi = var3_1;
    }

    public static zzbm$zzbc$zzb[] values() {
        return (zzbm$zzbc$zzb[])zzj.clone();
    }

    public static zzgh zzb() {
        return zzdn.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzbm$zzbc$zzb.class.getName();
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

