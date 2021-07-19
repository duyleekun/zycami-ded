/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzdb;
import com.google.android.gms.internal.mlkit_vision_face.zzdc;
import com.google.android.gms.internal.mlkit_vision_face.zzgf;
import com.google.android.gms.internal.mlkit_vision_face.zzgh;
import com.google.android.gms.internal.mlkit_vision_face.zzgi;

public final class zzbm$zzao$zza
extends Enum
implements zzgf {
    private static final /* enum */ zzbm$zzao$zza zza;
    private static final /* enum */ zzbm$zzao$zza zzb;
    private static final /* enum */ zzbm$zzao$zza zzc;
    private static final /* enum */ zzbm$zzao$zza zzd;
    private static final /* enum */ zzbm$zzao$zza zze;
    private static final /* enum */ zzbm$zzao$zza zzf;
    private static final /* enum */ zzbm$zzao$zza zzg;
    private static final /* enum */ zzbm$zzao$zza zzh;
    private static final /* enum */ zzbm$zzao$zza zzi;
    private static final /* enum */ zzbm$zzao$zza zzj;
    private static final /* enum */ zzbm$zzao$zza zzk;
    private static final /* enum */ zzbm$zzao$zza zzl;
    private static final /* enum */ zzbm$zzao$zza zzm;
    private static final /* enum */ zzbm$zzao$zza zzn;
    private static final zzgi zzo;
    private static final /* synthetic */ zzbm$zzao$zza[] zzq;
    private final int zzp;

    static {
        zzbm$zzao$zza zzbm$zzao$zza;
        zzbm$zzao$zza zzbm$zzao$zza2;
        zzbm$zzao$zza zzbm$zzao$zza3;
        zzbm$zzao$zza zzbm$zzao$zza4;
        zzbm$zzao$zza zzbm$zzao$zza5;
        zzbm$zzao$zza zzbm$zzao$zza6;
        zzbm$zzao$zza zzbm$zzao$zza7;
        zzbm$zzao$zza zzbm$zzao$zza8;
        zzbm$zzao$zza zzbm$zzao$zza9;
        zzbm$zzao$zza zzbm$zzao$zza10;
        zzbm$zzao$zza zzbm$zzao$zza11;
        zzbm$zzao$zza zzbm$zzao$zza12;
        Object object = new zzbm$zzao$zza("FORMAT_UNKNOWN", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzbm$zzao$zza12 = new zzbm$zzao$zza("FORMAT_CODE_128", n10, n10);
        int n11 = 2;
        zzc = zzbm$zzao$zza11 = new zzbm$zzao$zza("FORMAT_CODE_39", n11, n11);
        int n12 = 4;
        zzd = zzbm$zzao$zza10 = new zzbm$zzao$zza("FORMAT_CODE_93", 3, n12);
        int n13 = 8;
        zze = zzbm$zzao$zza9 = new zzbm$zzao$zza("FORMAT_CODABAR", n12, n13);
        zzf = zzbm$zzao$zza8 = new zzbm$zzao$zza("FORMAT_DATA_MATRIX", 5, 16);
        zzg = zzbm$zzao$zza7 = new zzbm$zzao$zza("FORMAT_EAN_13", 6, 32);
        zzh = zzbm$zzao$zza6 = new zzbm$zzao$zza("FORMAT_EAN_8", 7, 64);
        zzi = zzbm$zzao$zza5 = new zzbm$zzao$zza("FORMAT_ITF", n13, 128);
        zzj = zzbm$zzao$zza4 = new zzbm$zzao$zza("FORMAT_QR_CODE", 9, 256);
        zzk = zzbm$zzao$zza3 = new zzbm$zzao$zza("FORMAT_UPC_A", 10, 512);
        zzl = zzbm$zzao$zza2 = new zzbm$zzao$zza("FORMAT_UPC_E", 11, 1024);
        zzbm$zzao$zza[] zzbm$zzao$zzaArray = new zzbm$zzao$zza("FORMAT_PDF417", 12, 2048);
        zzm = zzbm$zzao$zzaArray;
        n13 = 13;
        zzbm$zzao$zza[] zzbm$zzao$zzaArray2 = zzbm$zzao$zzaArray;
        zzn = zzbm$zzao$zza = new zzbm$zzao$zza("FORMAT_AZTEC", n13, 4096);
        zzbm$zzao$zzaArray = new zzbm$zzao$zza[14];
        zzbm$zzao$zzaArray[0] = object;
        zzbm$zzao$zzaArray[1] = zzbm$zzao$zza12;
        zzbm$zzao$zzaArray[2] = zzbm$zzao$zza11;
        zzbm$zzao$zzaArray[3] = zzbm$zzao$zza10;
        zzbm$zzao$zzaArray[4] = zzbm$zzao$zza9;
        zzbm$zzao$zzaArray[5] = zzbm$zzao$zza8;
        zzbm$zzao$zzaArray[6] = zzbm$zzao$zza7;
        zzbm$zzao$zzaArray[7] = zzbm$zzao$zza6;
        zzbm$zzao$zzaArray[8] = zzbm$zzao$zza5;
        zzbm$zzao$zzaArray[9] = zzbm$zzao$zza4;
        zzbm$zzao$zzaArray[10] = zzbm$zzao$zza3;
        zzbm$zzao$zzaArray[11] = zzbm$zzao$zza2;
        zzbm$zzao$zzaArray[12] = zzbm$zzao$zzaArray2;
        zzbm$zzao$zzaArray[n13] = zzbm$zzao$zza;
        zzq = zzbm$zzao$zzaArray;
        zzo = object = new zzdc();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzbm$zzao$zza() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzp = var3_1;
    }

    public static zzbm$zzao$zza[] values() {
        return (zzbm$zzao$zza[])zzq.clone();
    }

    public static zzgh zzb() {
        return zzdb.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzbm$zzao$zza.class.getName();
        stringBuilder.append(string2);
        stringBuilder.append('@');
        string2 = Integer.toHexString(System.identityHashCode(this));
        stringBuilder.append(string2);
        stringBuilder.append(" number=");
        int n10 = this.zzp;
        stringBuilder.append(n10);
        stringBuilder.append(" name=");
        string2 = this.name();
        stringBuilder.append(string2);
        stringBuilder.append('>');
        return stringBuilder.toString();
    }

    public final int zza() {
        return this.zzp;
    }
}

