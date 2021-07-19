/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzbu;
import com.google.android.gms.internal.mlkit_vision_face.zzbv;
import com.google.android.gms.internal.mlkit_vision_face.zzgf;
import com.google.android.gms.internal.mlkit_vision_face.zzgh;
import com.google.android.gms.internal.mlkit_vision_face.zzgi;

public final class zzbm$zzy$zza$zza
extends Enum
implements zzgf {
    private static final /* enum */ zzbm$zzy$zza$zza zza;
    private static final /* enum */ zzbm$zzy$zza$zza zzb;
    private static final /* enum */ zzbm$zzy$zza$zza zzc;
    private static final /* enum */ zzbm$zzy$zza$zza zzd;
    private static final /* enum */ zzbm$zzy$zza$zza zze;
    private static final zzgi zzf;
    private static final /* synthetic */ zzbm$zzy$zza$zza[] zzh;
    private final int zzg;

    static {
        zzbm$zzy$zza$zza zzbm$zzy$zza$zza;
        zzbm$zzy$zza$zza zzbm$zzy$zza$zza2;
        zzbm$zzy$zza$zza zzbm$zzy$zza$zza3;
        zzbm$zzy$zza$zza zzbm$zzy$zza$zza4;
        Object object = new zzbm$zzy$zza$zza("UNKNOWN_DATA_TYPE", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzbm$zzy$zza$zza4 = new zzbm$zzy$zza$zza("TYPE_FLOAT32", n10, n10);
        int n11 = 2;
        zzc = zzbm$zzy$zza$zza3 = new zzbm$zzy$zza$zza("TYPE_INT32", n11, n11);
        int n12 = 3;
        zzd = zzbm$zzy$zza$zza2 = new zzbm$zzy$zza$zza("TYPE_BYTE", n12, n12);
        int n13 = 4;
        zze = zzbm$zzy$zza$zza = new zzbm$zzy$zza$zza("TYPE_LONG", n13, n13);
        zzbm$zzy$zza$zza[] zzbm$zzy$zza$zzaArray = new zzbm$zzy$zza$zza[5];
        zzbm$zzy$zza$zzaArray[0] = object;
        zzbm$zzy$zza$zzaArray[n10] = zzbm$zzy$zza$zza4;
        zzbm$zzy$zza$zzaArray[n11] = zzbm$zzy$zza$zza3;
        zzbm$zzy$zza$zzaArray[n12] = zzbm$zzy$zza$zza2;
        zzbm$zzy$zza$zzaArray[n13] = zzbm$zzy$zza$zza;
        zzh = zzbm$zzy$zza$zzaArray;
        zzf = object = new zzbv();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzbm$zzy$zza$zza() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzg = var3_1;
    }

    public static zzbm$zzy$zza$zza[] values() {
        return (zzbm$zzy$zza$zza[])zzh.clone();
    }

    public static zzgh zzb() {
        return zzbu.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzbm$zzy$zza$zza.class.getName();
        stringBuilder.append(string2);
        stringBuilder.append('@');
        string2 = Integer.toHexString(System.identityHashCode(this));
        stringBuilder.append(string2);
        stringBuilder.append(" number=");
        int n10 = this.zzg;
        stringBuilder.append(n10);
        stringBuilder.append(" name=");
        string2 = this.name();
        stringBuilder.append(string2);
        stringBuilder.append('>');
        return stringBuilder.toString();
    }

    public final int zza() {
        return this.zzg;
    }
}

