/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzec;
import com.google.android.gms.internal.mlkit_vision_face.zzed;
import com.google.android.gms.internal.mlkit_vision_face.zzgf;
import com.google.android.gms.internal.mlkit_vision_face.zzgh;
import com.google.android.gms.internal.mlkit_vision_face.zzgi;

public final class zzdx$zzb$zzc
extends Enum
implements zzgf {
    private static final /* enum */ zzdx$zzb$zzc zza;
    private static final /* enum */ zzdx$zzb$zzc zzb;
    private static final /* enum */ zzdx$zzb$zzc zzc;
    private static final /* enum */ zzdx$zzb$zzc zzd;
    private static final zzgi zze;
    private static final /* synthetic */ zzdx$zzb$zzc[] zzg;
    private final int zzf;

    static {
        zzdx$zzb$zzc zzdx$zzb$zzc;
        zzdx$zzb$zzc zzdx$zzb$zzc2;
        zzdx$zzb$zzc zzdx$zzb$zzc3;
        Object object = new zzdx$zzb$zzc("LANDMARK_UNKNOWN", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzdx$zzb$zzc3 = new zzdx$zzb$zzc("LANDMARK_NONE", n10, n10);
        int n11 = 2;
        zzc = zzdx$zzb$zzc2 = new zzdx$zzb$zzc("LANDMARK_ALL", n11, n11);
        int n12 = 3;
        zzd = zzdx$zzb$zzc = new zzdx$zzb$zzc("LANDMARK_CONTOUR", n12, n12);
        zzdx$zzb$zzc[] zzdx$zzb$zzcArray = new zzdx$zzb$zzc[4];
        zzdx$zzb$zzcArray[0] = object;
        zzdx$zzb$zzcArray[n10] = zzdx$zzb$zzc3;
        zzdx$zzb$zzcArray[n11] = zzdx$zzb$zzc2;
        zzdx$zzb$zzcArray[n12] = zzdx$zzb$zzc;
        zzg = zzdx$zzb$zzcArray;
        zze = object = new zzed();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzdx$zzb$zzc() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzf = var3_1;
    }

    public static zzdx$zzb$zzc[] values() {
        return (zzdx$zzb$zzc[])zzg.clone();
    }

    public static zzgh zzb() {
        return zzec.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzdx$zzb$zzc.class.getName();
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

