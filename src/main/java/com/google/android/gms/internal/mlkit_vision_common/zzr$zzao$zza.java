/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzbg;
import com.google.android.gms.internal.mlkit_vision_common.zzbh;
import com.google.android.gms.internal.mlkit_vision_common.zzel;
import com.google.android.gms.internal.mlkit_vision_common.zzen;
import com.google.android.gms.internal.mlkit_vision_common.zzeo;

public final class zzr$zzao$zza
extends Enum
implements zzel {
    private static final /* enum */ zzr$zzao$zza zza;
    private static final /* enum */ zzr$zzao$zza zzb;
    private static final /* enum */ zzr$zzao$zza zzc;
    private static final /* enum */ zzr$zzao$zza zzd;
    private static final /* enum */ zzr$zzao$zza zze;
    private static final /* enum */ zzr$zzao$zza zzf;
    private static final /* enum */ zzr$zzao$zza zzg;
    private static final /* enum */ zzr$zzao$zza zzh;
    private static final /* enum */ zzr$zzao$zza zzi;
    private static final /* enum */ zzr$zzao$zza zzj;
    private static final /* enum */ zzr$zzao$zza zzk;
    private static final /* enum */ zzr$zzao$zza zzl;
    private static final /* enum */ zzr$zzao$zza zzm;
    private static final /* enum */ zzr$zzao$zza zzn;
    private static final zzeo zzo;
    private static final /* synthetic */ zzr$zzao$zza[] zzq;
    private final int zzp;

    static {
        zzr$zzao$zza zzr$zzao$zza;
        zzr$zzao$zza zzr$zzao$zza2;
        zzr$zzao$zza zzr$zzao$zza3;
        zzr$zzao$zza zzr$zzao$zza4;
        zzr$zzao$zza zzr$zzao$zza5;
        zzr$zzao$zza zzr$zzao$zza6;
        zzr$zzao$zza zzr$zzao$zza7;
        zzr$zzao$zza zzr$zzao$zza8;
        zzr$zzao$zza zzr$zzao$zza9;
        zzr$zzao$zza zzr$zzao$zza10;
        zzr$zzao$zza zzr$zzao$zza11;
        zzr$zzao$zza zzr$zzao$zza12;
        Object object = new zzr$zzao$zza("FORMAT_UNKNOWN", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzr$zzao$zza12 = new zzr$zzao$zza("FORMAT_CODE_128", n10, n10);
        int n11 = 2;
        zzc = zzr$zzao$zza11 = new zzr$zzao$zza("FORMAT_CODE_39", n11, n11);
        int n12 = 4;
        zzd = zzr$zzao$zza10 = new zzr$zzao$zza("FORMAT_CODE_93", 3, n12);
        int n13 = 8;
        zze = zzr$zzao$zza9 = new zzr$zzao$zza("FORMAT_CODABAR", n12, n13);
        zzf = zzr$zzao$zza8 = new zzr$zzao$zza("FORMAT_DATA_MATRIX", 5, 16);
        zzg = zzr$zzao$zza7 = new zzr$zzao$zza("FORMAT_EAN_13", 6, 32);
        zzh = zzr$zzao$zza6 = new zzr$zzao$zza("FORMAT_EAN_8", 7, 64);
        zzi = zzr$zzao$zza5 = new zzr$zzao$zza("FORMAT_ITF", n13, 128);
        zzj = zzr$zzao$zza4 = new zzr$zzao$zza("FORMAT_QR_CODE", 9, 256);
        zzk = zzr$zzao$zza3 = new zzr$zzao$zza("FORMAT_UPC_A", 10, 512);
        zzl = zzr$zzao$zza2 = new zzr$zzao$zza("FORMAT_UPC_E", 11, 1024);
        zzr$zzao$zza[] zzr$zzao$zzaArray = new zzr$zzao$zza("FORMAT_PDF417", 12, 2048);
        zzm = zzr$zzao$zzaArray;
        n13 = 13;
        zzr$zzao$zza[] zzr$zzao$zzaArray2 = zzr$zzao$zzaArray;
        zzn = zzr$zzao$zza = new zzr$zzao$zza("FORMAT_AZTEC", n13, 4096);
        zzr$zzao$zzaArray = new zzr$zzao$zza[14];
        zzr$zzao$zzaArray[0] = object;
        zzr$zzao$zzaArray[1] = zzr$zzao$zza12;
        zzr$zzao$zzaArray[2] = zzr$zzao$zza11;
        zzr$zzao$zzaArray[3] = zzr$zzao$zza10;
        zzr$zzao$zzaArray[4] = zzr$zzao$zza9;
        zzr$zzao$zzaArray[5] = zzr$zzao$zza8;
        zzr$zzao$zzaArray[6] = zzr$zzao$zza7;
        zzr$zzao$zzaArray[7] = zzr$zzao$zza6;
        zzr$zzao$zzaArray[8] = zzr$zzao$zza5;
        zzr$zzao$zzaArray[9] = zzr$zzao$zza4;
        zzr$zzao$zzaArray[10] = zzr$zzao$zza3;
        zzr$zzao$zzaArray[11] = zzr$zzao$zza2;
        zzr$zzao$zzaArray[12] = zzr$zzao$zzaArray2;
        zzr$zzao$zzaArray[n13] = zzr$zzao$zza;
        zzq = zzr$zzao$zzaArray;
        zzo = object = new zzbh();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzr$zzao$zza() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzp = var3_1;
    }

    public static zzr$zzao$zza[] values() {
        return (zzr$zzao$zza[])zzq.clone();
    }

    public static zzen zzb() {
        return zzbg.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzr$zzao$zza.class.getName();
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

