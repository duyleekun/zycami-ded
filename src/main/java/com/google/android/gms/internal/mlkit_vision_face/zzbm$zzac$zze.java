/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzcj;
import com.google.android.gms.internal.mlkit_vision_face.zzck;
import com.google.android.gms.internal.mlkit_vision_face.zzgf;
import com.google.android.gms.internal.mlkit_vision_face.zzgh;
import com.google.android.gms.internal.mlkit_vision_face.zzgi;

public final class zzbm$zzac$zze
extends Enum
implements zzgf {
    public static final /* enum */ zzbm$zzac$zze zza;
    public static final /* enum */ zzbm$zzac$zze zzb;
    public static final /* enum */ zzbm$zzac$zze zzc;
    private static final zzgi zzd;
    private static final /* synthetic */ zzbm$zzac$zze[] zzf;
    private final int zze;

    static {
        zzbm$zzac$zze zzbm$zzac$zze;
        zzbm$zzac$zze zzbm$zzac$zze2;
        Object object = new zzbm$zzac$zze("UNKNOWN_PERFORMANCE", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzbm$zzac$zze2 = new zzbm$zzac$zze("FAST", n10, n10);
        int n11 = 2;
        zzc = zzbm$zzac$zze = new zzbm$zzac$zze("ACCURATE", n11, n11);
        zzbm$zzac$zze[] zzbm$zzac$zzeArray = new zzbm$zzac$zze[3];
        zzbm$zzac$zzeArray[0] = object;
        zzbm$zzac$zzeArray[n10] = zzbm$zzac$zze2;
        zzbm$zzac$zzeArray[n11] = zzbm$zzac$zze;
        zzf = zzbm$zzac$zzeArray;
        zzd = object = new zzcj();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzbm$zzac$zze() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zze = var3_1;
    }

    public static zzbm$zzac$zze[] values() {
        return (zzbm$zzac$zze[])zzf.clone();
    }

    public static zzgh zzb() {
        return zzck.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzbm$zzac$zze.class.getName();
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

