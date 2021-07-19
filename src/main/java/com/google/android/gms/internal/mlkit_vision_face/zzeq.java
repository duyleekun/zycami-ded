/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzer;
import com.google.android.gms.internal.mlkit_vision_face.zzes;
import com.google.android.gms.internal.mlkit_vision_face.zzgf;
import com.google.android.gms.internal.mlkit_vision_face.zzgh;
import com.google.android.gms.internal.mlkit_vision_face.zzgi;

public final class zzeq
extends Enum
implements zzgf {
    private static final /* enum */ zzeq zza;
    private static final /* enum */ zzeq zzb;
    private static final /* enum */ zzeq zzc;
    private static final /* enum */ zzeq zzd;
    private static final /* enum */ zzeq zze;
    private static final /* enum */ zzeq zzf;
    private static final /* enum */ zzeq zzg;
    private static final /* enum */ zzeq zzh;
    private static final /* enum */ zzeq zzi;
    private static final /* enum */ zzeq zzj;
    private static final /* enum */ zzeq zzk;
    private static final /* enum */ zzeq zzl;
    private static final /* enum */ zzeq zzm;
    private static final /* enum */ zzeq zzn;
    private static final /* enum */ zzeq zzo;
    private static final /* enum */ zzeq zzp;
    private static final zzgi zzq;
    private static final /* synthetic */ zzeq[] zzs;
    private final int zzr;

    static {
        zzeq zzeq2;
        zzeq zzeq3;
        zzeq zzeq4;
        zzeq zzeq5;
        zzeq zzeq6;
        zzeq zzeq7;
        zzeq zzeq8;
        zzeq zzeq9;
        zzeq zzeq10;
        zzeq zzeq11;
        zzeq zzeq12;
        zzeq zzeq13;
        zzeq zzeq14;
        zzeq zzeq15;
        Object object = new zzeq("UNRECOGNIZED", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzeq15 = new zzeq("CODE_128", n10, n10);
        int n11 = 2;
        zzc = zzeq14 = new zzeq("CODE_39", n11, n11);
        int n12 = 3;
        zzd = zzeq13 = new zzeq("CODE_93", n12, n12);
        int n13 = 4;
        zze = zzeq12 = new zzeq("CODABAR", n13, n13);
        int n14 = 5;
        zzf = zzeq11 = new zzeq("DATA_MATRIX", n14, n14);
        int n15 = 6;
        zzg = zzeq10 = new zzeq("EAN_13", n15, n15);
        n15 = 7;
        zzh = zzeq9 = new zzeq("EAN_8", n15, n15);
        n14 = 8;
        zzi = zzeq8 = new zzeq("ITF", n14, n14);
        n13 = 9;
        zzj = zzeq7 = new zzeq("QR_CODE", n13, n13);
        n12 = 10;
        zzk = zzeq6 = new zzeq("UPC_A", n12, n12);
        n11 = 11;
        zzl = zzeq5 = new zzeq("UPC_E", n11, n11);
        n10 = 12;
        zzm = zzeq4 = new zzeq("PDF417", n10, n10);
        int n16 = 13;
        zzeq[] zzeqArray = new zzeq("AZTEC", n16, n16);
        zzn = zzeqArray;
        zzeq[] zzeqArray2 = zzeqArray;
        n11 = 14;
        zzo = zzeq3 = new zzeq("DATABAR", n11, n11);
        n10 = 15;
        n12 = 16;
        zzp = zzeq2 = new zzeq("TEZ_CODE", n10, n12);
        zzeqArray = new zzeq[n12];
        zzeqArray[0] = object;
        zzeqArray[1] = zzeq15;
        zzeqArray[2] = zzeq14;
        zzeqArray[3] = zzeq13;
        zzeqArray[4] = zzeq12;
        zzeqArray[5] = zzeq11;
        zzeqArray[6] = zzeq10;
        zzeqArray[7] = zzeq9;
        zzeqArray[8] = zzeq8;
        zzeqArray[9] = zzeq7;
        zzeqArray[10] = zzeq6;
        zzeqArray[11] = zzeq5;
        zzeqArray[12] = zzeq4;
        zzeqArray[13] = zzeqArray2;
        zzeqArray[14] = zzeq3;
        zzeqArray[n10] = zzeq2;
        zzs = zzeqArray;
        zzq = object = new zzes();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzeq() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzr = var3_1;
    }

    public static zzeq[] values() {
        return (zzeq[])zzs.clone();
    }

    public static zzgh zzb() {
        return zzer.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzeq.class.getName();
        stringBuilder.append(string2);
        stringBuilder.append('@');
        string2 = Integer.toHexString(System.identityHashCode(this));
        stringBuilder.append(string2);
        stringBuilder.append(" number=");
        int n10 = this.zzr;
        stringBuilder.append(n10);
        stringBuilder.append(" name=");
        string2 = this.name();
        stringBuilder.append(string2);
        stringBuilder.append('>');
        return stringBuilder.toString();
    }

    public final int zza() {
        return this.zzr;
    }
}

