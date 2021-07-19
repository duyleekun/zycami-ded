/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzch;
import com.google.android.gms.internal.mlkit_vision_face.zzci;
import com.google.android.gms.internal.mlkit_vision_face.zzgf;
import com.google.android.gms.internal.mlkit_vision_face.zzgh;
import com.google.android.gms.internal.mlkit_vision_face.zzgi;

public final class zzbm$zzac$zzd
extends Enum
implements zzgf {
    public static final /* enum */ zzbm$zzac$zzd zza;
    public static final /* enum */ zzbm$zzac$zzd zzb;
    public static final /* enum */ zzbm$zzac$zzd zzc;
    private static final zzgi zzd;
    private static final /* synthetic */ zzbm$zzac$zzd[] zzf;
    private final int zze;

    static {
        zzbm$zzac$zzd zzbm$zzac$zzd;
        zzbm$zzac$zzd zzbm$zzac$zzd2;
        Object object = new zzbm$zzac$zzd("UNKNOWN_LANDMARKS", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzbm$zzac$zzd2 = new zzbm$zzac$zzd("NO_LANDMARKS", n10, n10);
        int n11 = 2;
        zzc = zzbm$zzac$zzd = new zzbm$zzac$zzd("ALL_LANDMARKS", n11, n11);
        zzbm$zzac$zzd[] zzbm$zzac$zzdArray = new zzbm$zzac$zzd[3];
        zzbm$zzac$zzdArray[0] = object;
        zzbm$zzac$zzdArray[n10] = zzbm$zzac$zzd2;
        zzbm$zzac$zzdArray[n11] = zzbm$zzac$zzd;
        zzf = zzbm$zzac$zzdArray;
        zzd = object = new zzci();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzbm$zzac$zzd() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zze = var3_1;
    }

    public static zzbm$zzac$zzd[] values() {
        return (zzbm$zzac$zzd[])zzf.clone();
    }

    public static zzgh zzb() {
        return zzch.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzbm$zzac$zzd.class.getName();
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

