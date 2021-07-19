/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzcl;
import com.google.android.gms.internal.mlkit_vision_face.zzcm;
import com.google.android.gms.internal.mlkit_vision_face.zzgf;
import com.google.android.gms.internal.mlkit_vision_face.zzgh;
import com.google.android.gms.internal.mlkit_vision_face.zzgi;

public final class zzbm$zzae$zza
extends Enum
implements zzgf {
    public static final /* enum */ zzbm$zzae$zza zza;
    public static final /* enum */ zzbm$zzae$zza zzb;
    public static final /* enum */ zzbm$zzae$zza zzc;
    public static final /* enum */ zzbm$zzae$zza zzd;
    public static final /* enum */ zzbm$zzae$zza zze;
    public static final /* enum */ zzbm$zzae$zza zzf;
    private static final /* enum */ zzbm$zzae$zza zzg;
    private static final /* enum */ zzbm$zzae$zza zzh;
    private static final /* enum */ zzbm$zzae$zza zzi;
    private static final zzgi zzj;
    private static final /* synthetic */ zzbm$zzae$zza[] zzl;
    private final int zzk;

    static {
        zzbm$zzae$zza zzbm$zzae$zza;
        zzbm$zzae$zza zzbm$zzae$zza2;
        zzbm$zzae$zza zzbm$zzae$zza3;
        zzbm$zzae$zza zzbm$zzae$zza4;
        zzbm$zzae$zza zzbm$zzae$zza5;
        zzbm$zzae$zza zzbm$zzae$zza6;
        zzbm$zzae$zza zzbm$zzae$zza7;
        zzbm$zzae$zza zzbm$zzae$zza8;
        Object object = new zzbm$zzae$zza("UNKNOWN_FORMAT", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzbm$zzae$zza8 = new zzbm$zzae$zza("NV16", n10, n10);
        int n11 = 2;
        zzc = zzbm$zzae$zza7 = new zzbm$zzae$zza("NV21", n11, n11);
        int n12 = 3;
        zzd = zzbm$zzae$zza6 = new zzbm$zzae$zza("YV12", n12, n12);
        int n13 = 4;
        int n14 = 7;
        zze = zzbm$zzae$zza5 = new zzbm$zzae$zza("YUV_420_888", n13, n14);
        int n15 = 5;
        int n16 = 8;
        zzg = zzbm$zzae$zza4 = new zzbm$zzae$zza("JPEG", n15, n16);
        n12 = 6;
        zzf = zzbm$zzae$zza3 = new zzbm$zzae$zza("BITMAP", n12, n13);
        zzh = zzbm$zzae$zza2 = new zzbm$zzae$zza("CM_SAMPLE_BUFFER_REF", n14, n15);
        zzi = zzbm$zzae$zza = new zzbm$zzae$zza("UI_IMAGE", n16, n12);
        zzbm$zzae$zza[] zzbm$zzae$zzaArray = new zzbm$zzae$zza[9];
        zzbm$zzae$zzaArray[0] = object;
        zzbm$zzae$zzaArray[n10] = zzbm$zzae$zza8;
        zzbm$zzae$zzaArray[n11] = zzbm$zzae$zza7;
        zzbm$zzae$zzaArray[3] = zzbm$zzae$zza6;
        zzbm$zzae$zzaArray[4] = zzbm$zzae$zza5;
        zzbm$zzae$zzaArray[n15] = zzbm$zzae$zza4;
        zzbm$zzae$zzaArray[n12] = zzbm$zzae$zza3;
        zzbm$zzae$zzaArray[7] = zzbm$zzae$zza2;
        zzbm$zzae$zzaArray[n16] = zzbm$zzae$zza;
        zzl = zzbm$zzae$zzaArray;
        zzj = object = new zzcm();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzbm$zzae$zza() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzk = var3_1;
    }

    public static zzbm$zzae$zza[] values() {
        return (zzbm$zzae$zza[])zzl.clone();
    }

    public static zzgh zzb() {
        return zzcl.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzbm$zzae$zza.class.getName();
        stringBuilder.append(string2);
        stringBuilder.append('@');
        string2 = Integer.toHexString(System.identityHashCode(this));
        stringBuilder.append(string2);
        stringBuilder.append(" number=");
        int n10 = this.zzk;
        stringBuilder.append(n10);
        stringBuilder.append(" name=");
        string2 = this.name();
        stringBuilder.append(string2);
        stringBuilder.append('>');
        return stringBuilder.toString();
    }

    public final int zza() {
        return this.zzk;
    }
}

