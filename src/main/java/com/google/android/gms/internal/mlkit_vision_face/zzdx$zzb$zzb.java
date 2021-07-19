/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzea;
import com.google.android.gms.internal.mlkit_vision_face.zzeb;
import com.google.android.gms.internal.mlkit_vision_face.zzgf;
import com.google.android.gms.internal.mlkit_vision_face.zzgh;
import com.google.android.gms.internal.mlkit_vision_face.zzgi;

public final class zzdx$zzb$zzb
extends Enum
implements zzgf {
    private static final /* enum */ zzdx$zzb$zzb zza;
    private static final /* enum */ zzdx$zzb$zzb zzb;
    private static final /* enum */ zzdx$zzb$zzb zzc;
    private static final zzgi zzd;
    private static final /* synthetic */ zzdx$zzb$zzb[] zzf;
    private final int zze;

    static {
        zzdx$zzb$zzb zzdx$zzb$zzb;
        zzdx$zzb$zzb zzdx$zzb$zzb2;
        Object object = new zzdx$zzb$zzb("CLASSIFICATION_UNKNOWN", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzdx$zzb$zzb2 = new zzdx$zzb$zzb("CLASSIFICATION_NONE", n10, n10);
        int n11 = 2;
        zzc = zzdx$zzb$zzb = new zzdx$zzb$zzb("CLASSIFICATION_ALL", n11, n11);
        zzdx$zzb$zzb[] zzdx$zzb$zzbArray = new zzdx$zzb$zzb[3];
        zzdx$zzb$zzbArray[0] = object;
        zzdx$zzb$zzbArray[n10] = zzdx$zzb$zzb2;
        zzdx$zzb$zzbArray[n11] = zzdx$zzb$zzb;
        zzf = zzdx$zzb$zzbArray;
        zzd = object = new zzea();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzdx$zzb$zzb() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zze = var3_1;
    }

    public static zzdx$zzb$zzb[] values() {
        return (zzdx$zzb$zzb[])zzf.clone();
    }

    public static zzgh zzb() {
        return zzeb.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzdx$zzb$zzb.class.getName();
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

