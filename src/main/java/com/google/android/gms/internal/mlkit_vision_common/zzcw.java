/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzcx;
import com.google.android.gms.internal.mlkit_vision_common.zzcy;
import com.google.android.gms.internal.mlkit_vision_common.zzel;
import com.google.android.gms.internal.mlkit_vision_common.zzen;
import com.google.android.gms.internal.mlkit_vision_common.zzeo;

public final class zzcw
extends Enum
implements zzel {
    private static final /* enum */ zzcw zza;
    private static final /* enum */ zzcw zzb;
    private static final /* enum */ zzcw zzc;
    private static final /* enum */ zzcw zzd;
    private static final /* enum */ zzcw zze;
    private static final /* enum */ zzcw zzf;
    private static final /* enum */ zzcw zzg;
    private static final /* enum */ zzcw zzh;
    private static final /* enum */ zzcw zzi;
    private static final /* enum */ zzcw zzj;
    private static final /* enum */ zzcw zzk;
    private static final /* enum */ zzcw zzl;
    private static final /* enum */ zzcw zzm;
    private static final /* enum */ zzcw zzn;
    private static final /* enum */ zzcw zzo;
    private static final /* enum */ zzcw zzp;
    private static final zzeo zzq;
    private static final /* synthetic */ zzcw[] zzs;
    private final int zzr;

    static {
        zzcw zzcw2;
        zzcw zzcw3;
        zzcw zzcw4;
        zzcw zzcw5;
        zzcw zzcw6;
        zzcw zzcw7;
        zzcw zzcw8;
        zzcw zzcw9;
        zzcw zzcw10;
        zzcw zzcw11;
        zzcw zzcw12;
        zzcw zzcw13;
        zzcw zzcw14;
        zzcw zzcw15;
        Object object = new zzcw("UNRECOGNIZED", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzcw15 = new zzcw("CODE_128", n10, n10);
        int n11 = 2;
        zzc = zzcw14 = new zzcw("CODE_39", n11, n11);
        int n12 = 3;
        zzd = zzcw13 = new zzcw("CODE_93", n12, n12);
        int n13 = 4;
        zze = zzcw12 = new zzcw("CODABAR", n13, n13);
        int n14 = 5;
        zzf = zzcw11 = new zzcw("DATA_MATRIX", n14, n14);
        int n15 = 6;
        zzg = zzcw10 = new zzcw("EAN_13", n15, n15);
        n15 = 7;
        zzh = zzcw9 = new zzcw("EAN_8", n15, n15);
        n14 = 8;
        zzi = zzcw8 = new zzcw("ITF", n14, n14);
        n13 = 9;
        zzj = zzcw7 = new zzcw("QR_CODE", n13, n13);
        n12 = 10;
        zzk = zzcw6 = new zzcw("UPC_A", n12, n12);
        n11 = 11;
        zzl = zzcw5 = new zzcw("UPC_E", n11, n11);
        n10 = 12;
        zzm = zzcw4 = new zzcw("PDF417", n10, n10);
        int n16 = 13;
        zzcw[] zzcwArray = new zzcw("AZTEC", n16, n16);
        zzn = zzcwArray;
        zzcw[] zzcwArray2 = zzcwArray;
        n11 = 14;
        zzo = zzcw3 = new zzcw("DATABAR", n11, n11);
        n10 = 15;
        n12 = 16;
        zzp = zzcw2 = new zzcw("TEZ_CODE", n10, n12);
        zzcwArray = new zzcw[n12];
        zzcwArray[0] = object;
        zzcwArray[1] = zzcw15;
        zzcwArray[2] = zzcw14;
        zzcwArray[3] = zzcw13;
        zzcwArray[4] = zzcw12;
        zzcwArray[5] = zzcw11;
        zzcwArray[6] = zzcw10;
        zzcwArray[7] = zzcw9;
        zzcwArray[8] = zzcw8;
        zzcwArray[9] = zzcw7;
        zzcwArray[10] = zzcw6;
        zzcwArray[11] = zzcw5;
        zzcwArray[12] = zzcw4;
        zzcwArray[13] = zzcwArray2;
        zzcwArray[14] = zzcw3;
        zzcwArray[n10] = zzcw2;
        zzs = zzcwArray;
        zzq = object = new zzcy();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzcw() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzr = var3_1;
    }

    public static zzcw[] values() {
        return (zzcw[])zzs.clone();
    }

    public static zzen zzb() {
        return zzcx.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzcw.class.getName();
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

