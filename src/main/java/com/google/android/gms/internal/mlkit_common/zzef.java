/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzee;
import com.google.android.gms.internal.mlkit_common.zzeh;
import com.google.android.gms.internal.mlkit_common.zzfu;
import com.google.android.gms.internal.mlkit_common.zzfv;
import com.google.android.gms.internal.mlkit_common.zzfx;

public final class zzef
extends Enum
implements zzfv {
    private static final /* enum */ zzef zza;
    private static final /* enum */ zzef zzb;
    private static final /* enum */ zzef zzc;
    private static final /* enum */ zzef zzd;
    private static final /* enum */ zzef zze;
    private static final /* enum */ zzef zzf;
    private static final /* enum */ zzef zzg;
    private static final /* enum */ zzef zzh;
    private static final /* enum */ zzef zzi;
    private static final /* enum */ zzef zzj;
    private static final /* enum */ zzef zzk;
    private static final /* enum */ zzef zzl;
    private static final /* enum */ zzef zzm;
    private static final /* enum */ zzef zzn;
    private static final /* enum */ zzef zzo;
    private static final /* enum */ zzef zzp;
    private static final zzfu zzq;
    private static final /* synthetic */ zzef[] zzs;
    private final int zzr;

    static {
        zzef zzef2;
        zzef zzef3;
        zzef zzef4;
        zzef zzef5;
        zzef zzef6;
        zzef zzef7;
        zzef zzef8;
        zzef zzef9;
        zzef zzef10;
        zzef zzef11;
        zzef zzef12;
        zzef zzef13;
        zzef zzef14;
        zzef zzef15;
        Object object = new zzef("UNRECOGNIZED", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzef15 = new zzef("CODE_128", n10, n10);
        int n11 = 2;
        zzc = zzef14 = new zzef("CODE_39", n11, n11);
        int n12 = 3;
        zzd = zzef13 = new zzef("CODE_93", n12, n12);
        int n13 = 4;
        zze = zzef12 = new zzef("CODABAR", n13, n13);
        int n14 = 5;
        zzf = zzef11 = new zzef("DATA_MATRIX", n14, n14);
        int n15 = 6;
        zzg = zzef10 = new zzef("EAN_13", n15, n15);
        n15 = 7;
        zzh = zzef9 = new zzef("EAN_8", n15, n15);
        n14 = 8;
        zzi = zzef8 = new zzef("ITF", n14, n14);
        n13 = 9;
        zzj = zzef7 = new zzef("QR_CODE", n13, n13);
        n12 = 10;
        zzk = zzef6 = new zzef("UPC_A", n12, n12);
        n11 = 11;
        zzl = zzef5 = new zzef("UPC_E", n11, n11);
        n10 = 12;
        zzm = zzef4 = new zzef("PDF417", n10, n10);
        int n16 = 13;
        zzef[] zzefArray = new zzef("AZTEC", n16, n16);
        zzn = zzefArray;
        zzef[] zzefArray2 = zzefArray;
        n11 = 14;
        zzo = zzef3 = new zzef("DATABAR", n11, n11);
        n10 = 15;
        n12 = 16;
        zzp = zzef2 = new zzef("TEZ_CODE", n10, n12);
        zzefArray = new zzef[n12];
        zzefArray[0] = object;
        zzefArray[1] = zzef15;
        zzefArray[2] = zzef14;
        zzefArray[3] = zzef13;
        zzefArray[4] = zzef12;
        zzefArray[5] = zzef11;
        zzefArray[6] = zzef10;
        zzefArray[7] = zzef9;
        zzefArray[8] = zzef8;
        zzefArray[9] = zzef7;
        zzefArray[10] = zzef6;
        zzefArray[11] = zzef5;
        zzefArray[12] = zzef4;
        zzefArray[13] = zzefArray2;
        zzefArray[14] = zzef3;
        zzefArray[n10] = zzef2;
        zzs = zzefArray;
        zzq = object = new zzee();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzef() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzr = var3_1;
    }

    public static zzef[] values() {
        return (zzef[])zzs.clone();
    }

    public static zzfx zzb() {
        return zzeh.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzef.class.getName();
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

