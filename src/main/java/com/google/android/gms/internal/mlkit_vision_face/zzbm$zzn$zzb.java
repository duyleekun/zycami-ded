/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzbs;
import com.google.android.gms.internal.mlkit_vision_face.zzbt;
import com.google.android.gms.internal.mlkit_vision_face.zzgf;
import com.google.android.gms.internal.mlkit_vision_face.zzgh;
import com.google.android.gms.internal.mlkit_vision_face.zzgi;

public final class zzbm$zzn$zzb
extends Enum
implements zzgf {
    private static final /* enum */ zzbm$zzn$zzb zza;
    private static final /* enum */ zzbm$zzn$zzb zzb;
    private static final /* enum */ zzbm$zzn$zzb zzc;
    private static final zzgi zzd;
    private static final /* synthetic */ zzbm$zzn$zzb[] zzf;
    private final int zze;

    static {
        zzbm$zzn$zzb zzbm$zzn$zzb;
        zzbm$zzn$zzb zzbm$zzn$zzb2;
        Object object = new zzbm$zzn$zzb("UNKNOWN_MODEL_TYPE", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzbm$zzn$zzb2 = new zzbm$zzn$zzb("STABLE_MODEL", n10, n10);
        int n11 = 2;
        zzc = zzbm$zzn$zzb = new zzbm$zzn$zzb("LATEST_MODEL", n11, n11);
        zzbm$zzn$zzb[] zzbm$zzn$zzbArray = new zzbm$zzn$zzb[3];
        zzbm$zzn$zzbArray[0] = object;
        zzbm$zzn$zzbArray[n10] = zzbm$zzn$zzb2;
        zzbm$zzn$zzbArray[n11] = zzbm$zzn$zzb;
        zzf = zzbm$zzn$zzbArray;
        zzd = object = new zzbs();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzbm$zzn$zzb() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zze = var3_1;
    }

    public static zzbm$zzn$zzb[] values() {
        return (zzbm$zzn$zzb[])zzf.clone();
    }

    public static zzgh zzb() {
        return zzbt.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzbm$zzn$zzb.class.getName();
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

