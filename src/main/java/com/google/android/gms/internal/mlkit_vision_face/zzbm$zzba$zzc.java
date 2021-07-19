/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzdk;
import com.google.android.gms.internal.mlkit_vision_face.zzdl;
import com.google.android.gms.internal.mlkit_vision_face.zzgf;
import com.google.android.gms.internal.mlkit_vision_face.zzgh;
import com.google.android.gms.internal.mlkit_vision_face.zzgi;

public final class zzbm$zzba$zzc
extends Enum
implements zzgf {
    private static final /* enum */ zzbm$zzba$zzc zza;
    private static final /* enum */ zzbm$zzba$zzc zzb;
    private static final /* enum */ zzbm$zzba$zzc zzc;
    private static final zzgi zzd;
    private static final /* synthetic */ zzbm$zzba$zzc[] zzf;
    private final int zze;

    static {
        zzbm$zzba$zzc zzbm$zzba$zzc;
        zzbm$zzba$zzc zzbm$zzba$zzc2;
        Object object = new zzbm$zzba$zzc("UNKNOWN_PERFORMANCE", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzbm$zzba$zzc2 = new zzbm$zzba$zzc("FAST", n10, n10);
        int n11 = 2;
        zzc = zzbm$zzba$zzc = new zzbm$zzba$zzc("ACCURATE", n11, n11);
        zzbm$zzba$zzc[] zzbm$zzba$zzcArray = new zzbm$zzba$zzc[3];
        zzbm$zzba$zzcArray[0] = object;
        zzbm$zzba$zzcArray[n10] = zzbm$zzba$zzc2;
        zzbm$zzba$zzcArray[n11] = zzbm$zzba$zzc;
        zzf = zzbm$zzba$zzcArray;
        zzd = object = new zzdl();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzbm$zzba$zzc() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zze = var3_1;
    }

    public static zzbm$zzba$zzc[] values() {
        return (zzbm$zzba$zzc[])zzf.clone();
    }

    public static zzgh zzb() {
        return zzdk.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzbm$zzba$zzc.class.getName();
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

