/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzdi;
import com.google.android.gms.internal.mlkit_vision_face.zzdj;
import com.google.android.gms.internal.mlkit_vision_face.zzgf;
import com.google.android.gms.internal.mlkit_vision_face.zzgh;
import com.google.android.gms.internal.mlkit_vision_face.zzgi;

public final class zzbm$zzba$zzb
extends Enum
implements zzgf {
    private static final /* enum */ zzbm$zzba$zzb zza;
    private static final /* enum */ zzbm$zzba$zzb zzb;
    private static final /* enum */ zzbm$zzba$zzb zzc;
    private static final zzgi zzd;
    private static final /* synthetic */ zzbm$zzba$zzb[] zzf;
    private final int zze;

    static {
        zzbm$zzba$zzb zzbm$zzba$zzb;
        zzbm$zzba$zzb zzbm$zzba$zzb2;
        Object object = new zzbm$zzba$zzb("INVALID_MODE", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzbm$zzba$zzb2 = new zzbm$zzba$zzb("STREAM", n10, n10);
        int n11 = 2;
        zzc = zzbm$zzba$zzb = new zzbm$zzba$zzb("SINGLE_IMAGE", n11, n11);
        zzbm$zzba$zzb[] zzbm$zzba$zzbArray = new zzbm$zzba$zzb[3];
        zzbm$zzba$zzbArray[0] = object;
        zzbm$zzba$zzbArray[n10] = zzbm$zzba$zzb2;
        zzbm$zzba$zzbArray[n11] = zzbm$zzba$zzb;
        zzf = zzbm$zzba$zzbArray;
        zzd = object = new zzdi();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzbm$zzba$zzb() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zze = var3_1;
    }

    public static zzbm$zzba$zzb[] values() {
        return (zzbm$zzba$zzb[])zzf.clone();
    }

    public static zzgh zzb() {
        return zzdj.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzbm$zzba$zzb.class.getName();
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

