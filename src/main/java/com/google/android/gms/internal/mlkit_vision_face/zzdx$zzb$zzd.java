/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzee;
import com.google.android.gms.internal.mlkit_vision_face.zzef;
import com.google.android.gms.internal.mlkit_vision_face.zzgf;
import com.google.android.gms.internal.mlkit_vision_face.zzgh;
import com.google.android.gms.internal.mlkit_vision_face.zzgi;

public final class zzdx$zzb$zzd
extends Enum
implements zzgf {
    private static final /* enum */ zzdx$zzb$zzd zza;
    private static final /* enum */ zzdx$zzb$zzd zzb;
    private static final /* enum */ zzdx$zzb$zzd zzc;
    private static final /* enum */ zzdx$zzb$zzd zzd;
    private static final zzgi zze;
    private static final /* synthetic */ zzdx$zzb$zzd[] zzg;
    private final int zzf;

    static {
        zzdx$zzb$zzd zzdx$zzb$zzd;
        zzdx$zzb$zzd zzdx$zzb$zzd2;
        zzdx$zzb$zzd zzdx$zzb$zzd3;
        Object object = new zzdx$zzb$zzd("MODE_UNKNOWN", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzdx$zzb$zzd3 = new zzdx$zzb$zzd("MODE_ACCURATE", n10, n10);
        int n11 = 2;
        zzc = zzdx$zzb$zzd2 = new zzdx$zzb$zzd("MODE_FAST", n11, n11);
        int n12 = 3;
        zzd = zzdx$zzb$zzd = new zzdx$zzb$zzd("MODE_SELFIE", n12, n12);
        zzdx$zzb$zzd[] zzdx$zzb$zzdArray = new zzdx$zzb$zzd[4];
        zzdx$zzb$zzdArray[0] = object;
        zzdx$zzb$zzdArray[n10] = zzdx$zzb$zzd3;
        zzdx$zzb$zzdArray[n11] = zzdx$zzb$zzd2;
        zzdx$zzb$zzdArray[n12] = zzdx$zzb$zzd;
        zzg = zzdx$zzb$zzdArray;
        zze = object = new zzee();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzdx$zzb$zzd() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzf = var3_1;
    }

    public static zzdx$zzb$zzd[] values() {
        return (zzdx$zzb$zzd[])zzg.clone();
    }

    public static zzgh zzb() {
        return zzef.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzdx$zzb$zzd.class.getName();
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

