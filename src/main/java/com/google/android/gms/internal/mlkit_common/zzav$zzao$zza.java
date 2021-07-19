/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzci;
import com.google.android.gms.internal.mlkit_common.zzcj;
import com.google.android.gms.internal.mlkit_common.zzfu;
import com.google.android.gms.internal.mlkit_common.zzfv;
import com.google.android.gms.internal.mlkit_common.zzfx;

public final class zzav$zzao$zza
extends Enum
implements zzfv {
    private static final /* enum */ zzav$zzao$zza zza;
    private static final /* enum */ zzav$zzao$zza zzb;
    private static final /* enum */ zzav$zzao$zza zzc;
    private static final /* enum */ zzav$zzao$zza zzd;
    private static final /* enum */ zzav$zzao$zza zze;
    private static final /* enum */ zzav$zzao$zza zzf;
    private static final /* enum */ zzav$zzao$zza zzg;
    private static final /* enum */ zzav$zzao$zza zzh;
    private static final /* enum */ zzav$zzao$zza zzi;
    private static final /* enum */ zzav$zzao$zza zzj;
    private static final /* enum */ zzav$zzao$zza zzk;
    private static final /* enum */ zzav$zzao$zza zzl;
    private static final /* enum */ zzav$zzao$zza zzm;
    private static final /* enum */ zzav$zzao$zza zzn;
    private static final zzfu zzo;
    private static final /* synthetic */ zzav$zzao$zza[] zzq;
    private final int zzp;

    static {
        zzav$zzao$zza zzav$zzao$zza;
        zzav$zzao$zza zzav$zzao$zza2;
        zzav$zzao$zza zzav$zzao$zza3;
        zzav$zzao$zza zzav$zzao$zza4;
        zzav$zzao$zza zzav$zzao$zza5;
        zzav$zzao$zza zzav$zzao$zza6;
        zzav$zzao$zza zzav$zzao$zza7;
        zzav$zzao$zza zzav$zzao$zza8;
        zzav$zzao$zza zzav$zzao$zza9;
        zzav$zzao$zza zzav$zzao$zza10;
        zzav$zzao$zza zzav$zzao$zza11;
        zzav$zzao$zza zzav$zzao$zza12;
        Object object = new zzav$zzao$zza("FORMAT_UNKNOWN", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzav$zzao$zza12 = new zzav$zzao$zza("FORMAT_CODE_128", n10, n10);
        int n11 = 2;
        zzc = zzav$zzao$zza11 = new zzav$zzao$zza("FORMAT_CODE_39", n11, n11);
        int n12 = 4;
        zzd = zzav$zzao$zza10 = new zzav$zzao$zza("FORMAT_CODE_93", 3, n12);
        int n13 = 8;
        zze = zzav$zzao$zza9 = new zzav$zzao$zza("FORMAT_CODABAR", n12, n13);
        zzf = zzav$zzao$zza8 = new zzav$zzao$zza("FORMAT_DATA_MATRIX", 5, 16);
        zzg = zzav$zzao$zza7 = new zzav$zzao$zza("FORMAT_EAN_13", 6, 32);
        zzh = zzav$zzao$zza6 = new zzav$zzao$zza("FORMAT_EAN_8", 7, 64);
        zzi = zzav$zzao$zza5 = new zzav$zzao$zza("FORMAT_ITF", n13, 128);
        zzj = zzav$zzao$zza4 = new zzav$zzao$zza("FORMAT_QR_CODE", 9, 256);
        zzk = zzav$zzao$zza3 = new zzav$zzao$zza("FORMAT_UPC_A", 10, 512);
        zzl = zzav$zzao$zza2 = new zzav$zzao$zza("FORMAT_UPC_E", 11, 1024);
        zzav$zzao$zza[] zzav$zzao$zzaArray = new zzav$zzao$zza("FORMAT_PDF417", 12, 2048);
        zzm = zzav$zzao$zzaArray;
        n13 = 13;
        zzav$zzao$zza[] zzav$zzao$zzaArray2 = zzav$zzao$zzaArray;
        zzn = zzav$zzao$zza = new zzav$zzao$zza("FORMAT_AZTEC", n13, 4096);
        zzav$zzao$zzaArray = new zzav$zzao$zza[14];
        zzav$zzao$zzaArray[0] = object;
        zzav$zzao$zzaArray[1] = zzav$zzao$zza12;
        zzav$zzao$zzaArray[2] = zzav$zzao$zza11;
        zzav$zzao$zzaArray[3] = zzav$zzao$zza10;
        zzav$zzao$zzaArray[4] = zzav$zzao$zza9;
        zzav$zzao$zzaArray[5] = zzav$zzao$zza8;
        zzav$zzao$zzaArray[6] = zzav$zzao$zza7;
        zzav$zzao$zzaArray[7] = zzav$zzao$zza6;
        zzav$zzao$zzaArray[8] = zzav$zzao$zza5;
        zzav$zzao$zzaArray[9] = zzav$zzao$zza4;
        zzav$zzao$zzaArray[10] = zzav$zzao$zza3;
        zzav$zzao$zzaArray[11] = zzav$zzao$zza2;
        zzav$zzao$zzaArray[12] = zzav$zzao$zzaArray2;
        zzav$zzao$zzaArray[n13] = zzav$zzao$zza;
        zzq = zzav$zzao$zzaArray;
        zzo = object = new zzci();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzav$zzao$zza() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzp = var3_1;
    }

    public static zzav$zzao$zza[] values() {
        return (zzav$zzao$zza[])zzq.clone();
    }

    public static zzfx zzb() {
        return zzcj.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzav$zzao$zza.class.getName();
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

