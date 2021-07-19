/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzcx;
import com.google.android.gms.internal.mlkit_vision_face.zzcy;
import com.google.android.gms.internal.mlkit_vision_face.zzgf;
import com.google.android.gms.internal.mlkit_vision_face.zzgh;
import com.google.android.gms.internal.mlkit_vision_face.zzgi;

public final class zzbm$zzan$zza
extends Enum
implements zzgf {
    private static final /* enum */ zzbm$zzan$zza zza;
    private static final /* enum */ zzbm$zzan$zza zzb;
    private static final /* enum */ zzbm$zzan$zza zzc;
    private static final /* enum */ zzbm$zzan$zza zzd;
    private static final /* enum */ zzbm$zzan$zza zze;
    private static final /* enum */ zzbm$zzan$zza zzf;
    private static final /* enum */ zzbm$zzan$zza zzg;
    private static final zzgi zzh;
    private static final /* synthetic */ zzbm$zzan$zza[] zzj;
    private final int zzi;

    static {
        zzbm$zzan$zza zzbm$zzan$zza;
        zzbm$zzan$zza zzbm$zzan$zza2;
        zzbm$zzan$zza zzbm$zzan$zza3;
        zzbm$zzan$zza zzbm$zzan$zza4;
        zzbm$zzan$zza zzbm$zzan$zza5;
        zzbm$zzan$zza zzbm$zzan$zza6;
        Object object = new zzbm$zzan$zza("CATEGORY_UNKNOWN", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzbm$zzan$zza6 = new zzbm$zzan$zza("CATEGORY_HOME_GOOD", n10, n10);
        int n11 = 2;
        zzc = zzbm$zzan$zza5 = new zzbm$zzan$zza("CATEGORY_FASHION_GOOD", n11, n11);
        int n12 = 3;
        zzd = zzbm$zzan$zza4 = new zzbm$zzan$zza("CATEGORY_ANIMAL", n12, n12);
        int n13 = 4;
        zze = zzbm$zzan$zza3 = new zzbm$zzan$zza("CATEGORY_FOOD", n13, n13);
        int n14 = 5;
        zzf = zzbm$zzan$zza2 = new zzbm$zzan$zza("CATEGORY_PLACE", n14, n14);
        int n15 = 6;
        zzg = zzbm$zzan$zza = new zzbm$zzan$zza("CATEGORY_PLANT", n15, n15);
        zzbm$zzan$zza[] zzbm$zzan$zzaArray = new zzbm$zzan$zza[7];
        zzbm$zzan$zzaArray[0] = object;
        zzbm$zzan$zzaArray[n10] = zzbm$zzan$zza6;
        zzbm$zzan$zzaArray[n11] = zzbm$zzan$zza5;
        zzbm$zzan$zzaArray[n12] = zzbm$zzan$zza4;
        zzbm$zzan$zzaArray[n13] = zzbm$zzan$zza3;
        zzbm$zzan$zzaArray[n14] = zzbm$zzan$zza2;
        zzbm$zzan$zzaArray[n15] = zzbm$zzan$zza;
        zzj = zzbm$zzan$zzaArray;
        zzh = object = new zzcy();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzbm$zzan$zza() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzi = var3_1;
    }

    public static zzbm$zzan$zza[] values() {
        return (zzbm$zzan$zza[])zzj.clone();
    }

    public static zzgh zzb() {
        return zzcx.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzbm$zzan$zza.class.getName();
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

