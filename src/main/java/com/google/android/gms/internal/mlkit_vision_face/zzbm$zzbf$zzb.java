/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzdq;
import com.google.android.gms.internal.mlkit_vision_face.zzdr;
import com.google.android.gms.internal.mlkit_vision_face.zzgf;
import com.google.android.gms.internal.mlkit_vision_face.zzgh;
import com.google.android.gms.internal.mlkit_vision_face.zzgi;

public final class zzbm$zzbf$zzb
extends Enum
implements zzgf {
    private static final /* enum */ zzbm$zzbf$zzb zza;
    private static final /* enum */ zzbm$zzbf$zzb zzb;
    private static final /* enum */ zzbm$zzbf$zzb zzc;
    private static final /* enum */ zzbm$zzbf$zzb zzd;
    private static final zzgi zze;
    private static final /* synthetic */ zzbm$zzbf$zzb[] zzg;
    private final int zzf;

    static {
        zzbm$zzbf$zzb zzbm$zzbf$zzb;
        zzbm$zzbf$zzb zzbm$zzbf$zzb2;
        zzbm$zzbf$zzb zzbm$zzbf$zzb3;
        Object object = new zzbm$zzbf$zzb("UNKNOWN", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzbm$zzbf$zzb3 = new zzbm$zzbf$zzb("CANONICAL", n10, n10);
        int n11 = 2;
        zzc = zzbm$zzbf$zzb2 = new zzbm$zzbf$zzb("TFLITE", n11, n11);
        int n12 = 3;
        zzd = zzbm$zzbf$zzb = new zzbm$zzbf$zzb("TFLITE_SUPPORT", n12, n12);
        zzbm$zzbf$zzb[] zzbm$zzbf$zzbArray = new zzbm$zzbf$zzb[4];
        zzbm$zzbf$zzbArray[0] = object;
        zzbm$zzbf$zzbArray[n10] = zzbm$zzbf$zzb3;
        zzbm$zzbf$zzbArray[n11] = zzbm$zzbf$zzb2;
        zzbm$zzbf$zzbArray[n12] = zzbm$zzbf$zzb;
        zzg = zzbm$zzbf$zzbArray;
        zze = object = new zzdq();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzbm$zzbf$zzb() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzf = var3_1;
    }

    public static zzbm$zzbf$zzb[] values() {
        return (zzbm$zzbf$zzb[])zzg.clone();
    }

    public static zzgh zzb() {
        return zzdr.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzbm$zzbf$zzb.class.getName();
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

