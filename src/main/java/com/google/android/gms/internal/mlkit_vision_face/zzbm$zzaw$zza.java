/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzdg;
import com.google.android.gms.internal.mlkit_vision_face.zzdh;
import com.google.android.gms.internal.mlkit_vision_face.zzgf;
import com.google.android.gms.internal.mlkit_vision_face.zzgh;
import com.google.android.gms.internal.mlkit_vision_face.zzgi;

public final class zzbm$zzaw$zza
extends Enum
implements zzgf {
    private static final /* enum */ zzbm$zzaw$zza zza;
    private static final /* enum */ zzbm$zzaw$zza zzb;
    private static final /* enum */ zzbm$zzaw$zza zzc;
    private static final zzgi zzd;
    private static final /* synthetic */ zzbm$zzaw$zza[] zzf;
    private final int zze;

    static {
        zzbm$zzaw$zza zzbm$zzaw$zza;
        zzbm$zzaw$zza zzbm$zzaw$zza2;
        Object object = new zzbm$zzaw$zza("MODE_UNSPECIFIED", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzbm$zzaw$zza2 = new zzbm$zzaw$zza("STREAM", n10, n10);
        int n11 = 2;
        zzc = zzbm$zzaw$zza = new zzbm$zzaw$zza("SINGLE_IMAGE", n11, n11);
        zzbm$zzaw$zza[] zzbm$zzaw$zzaArray = new zzbm$zzaw$zza[3];
        zzbm$zzaw$zzaArray[0] = object;
        zzbm$zzaw$zzaArray[n10] = zzbm$zzaw$zza2;
        zzbm$zzaw$zzaArray[n11] = zzbm$zzaw$zza;
        zzf = zzbm$zzaw$zzaArray;
        zzd = object = new zzdh();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzbm$zzaw$zza() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zze = var3_1;
    }

    public static zzbm$zzaw$zza[] values() {
        return (zzbm$zzaw$zza[])zzf.clone();
    }

    public static zzgh zzb() {
        return zzdg.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzbm$zzaw$zza.class.getName();
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

