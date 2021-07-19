/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzct;
import com.google.android.gms.internal.mlkit_vision_face.zzcu;
import com.google.android.gms.internal.mlkit_vision_face.zzgf;
import com.google.android.gms.internal.mlkit_vision_face.zzgh;
import com.google.android.gms.internal.mlkit_vision_face.zzgi;

public final class zzbm$zzal$zza
extends Enum
implements zzgf {
    private static final /* enum */ zzbm$zzal$zza zza;
    private static final /* enum */ zzbm$zzal$zza zzb;
    private static final /* enum */ zzbm$zzal$zza zzc;
    private static final /* enum */ zzbm$zzal$zza zzd;
    private static final /* enum */ zzbm$zzal$zza zze;
    private static final /* enum */ zzbm$zzal$zza zzf;
    private static final /* enum */ zzbm$zzal$zza zzg;
    private static final zzgi zzh;
    private static final /* synthetic */ zzbm$zzal$zza[] zzj;
    private final int zzi;

    static {
        zzbm$zzal$zza zzbm$zzal$zza;
        zzbm$zzal$zza zzbm$zzal$zza2;
        zzbm$zzal$zza zzbm$zzal$zza3;
        zzbm$zzal$zza zzbm$zzal$zza4;
        zzbm$zzal$zza zzbm$zzal$zza5;
        zzbm$zzal$zza zzbm$zzal$zza6;
        Object object = new zzbm$zzal$zza("TYPE_UNKNOWN", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzbm$zzal$zza6 = new zzbm$zzal$zza("CUSTOM", n10, n10);
        int n11 = 2;
        zzc = zzbm$zzal$zza5 = new zzbm$zzal$zza("AUTOML_IMAGE_LABELING", n11, n11);
        int n12 = 3;
        zzd = zzbm$zzal$zza4 = new zzbm$zzal$zza("BASE_TRANSLATE", n12, n12);
        int n13 = 4;
        zze = zzbm$zzal$zza3 = new zzbm$zzal$zza("CUSTOM_OBJECT_DETECTION", n13, n13);
        int n14 = 5;
        zzf = zzbm$zzal$zza2 = new zzbm$zzal$zza("CUSTOM_IMAGE_LABELING", n14, n14);
        int n15 = 6;
        zzg = zzbm$zzal$zza = new zzbm$zzal$zza("BASE_ENTITY_EXTRACTION", n15, n15);
        zzbm$zzal$zza[] zzbm$zzal$zzaArray = new zzbm$zzal$zza[7];
        zzbm$zzal$zzaArray[0] = object;
        zzbm$zzal$zzaArray[n10] = zzbm$zzal$zza6;
        zzbm$zzal$zzaArray[n11] = zzbm$zzal$zza5;
        zzbm$zzal$zzaArray[n12] = zzbm$zzal$zza4;
        zzbm$zzal$zzaArray[n13] = zzbm$zzal$zza3;
        zzbm$zzal$zzaArray[n14] = zzbm$zzal$zza2;
        zzbm$zzal$zzaArray[n15] = zzbm$zzal$zza;
        zzj = zzbm$zzal$zzaArray;
        zzh = object = new zzcu();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzbm$zzal$zza() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzi = var3_1;
    }

    public static zzbm$zzal$zza[] values() {
        return (zzbm$zzal$zza[])zzj.clone();
    }

    public static zzgh zzb() {
        return zzct.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzbm$zzal$zza.class.getName();
        stringBuilder.append(string2);
        stringBuilder.append('@');
        string2 = Integer.toHexString(System.identityHashCode(this));
        stringBuilder.append(string2);
        stringBuilder.append(" number=");
        int n10 = this.zzi;
        stringBuilder.append(n10);
        stringBuilder.append(" name=");
        string2 = this.name();
        stringBuilder.append(string2);
        stringBuilder.append('>');
        return stringBuilder.toString();
    }

    public final int zza() {
        return this.zzi;
    }
}

