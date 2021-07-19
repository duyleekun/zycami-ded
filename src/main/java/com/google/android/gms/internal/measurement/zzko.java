/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzkp;

public final class zzko
extends Enum {
    public static final /* enum */ zzko zza;
    public static final /* enum */ zzko zzb;
    public static final /* enum */ zzko zzc;
    public static final /* enum */ zzko zzd;
    public static final /* enum */ zzko zze;
    public static final /* enum */ zzko zzf;
    public static final /* enum */ zzko zzg;
    public static final /* enum */ zzko zzh;
    public static final /* enum */ zzko zzi;
    public static final /* enum */ zzko zzj;
    public static final /* enum */ zzko zzk;
    public static final /* enum */ zzko zzl;
    public static final /* enum */ zzko zzm;
    public static final /* enum */ zzko zzn;
    public static final /* enum */ zzko zzo;
    public static final /* enum */ zzko zzp;
    public static final /* enum */ zzko zzq;
    public static final /* enum */ zzko zzr;
    private static final /* synthetic */ zzko[] zzt;
    private final zzkp zzs;

    static {
        zzko zzko2;
        zzko zzko3;
        zzko zzko4;
        zzko zzko5;
        zzko zzko6;
        zzko zzko7;
        zzko zzko8;
        zzko zzko9;
        zzko zzko10;
        zzko zzko11;
        zzko zzko12;
        Enum enum_ = zzkp.zzd;
        int n10 = 1;
        zza = zzko12 = new zzko("DOUBLE", 0, (zzkp)enum_, n10);
        Enum enum_2 = zzkp.zzc;
        int n11 = 5;
        zzb = enum_ = new zzko("FLOAT", n10, (zzkp)enum_2, n11);
        zzko[] zzkoArray = zzkp.zzb;
        int n12 = 2;
        zzc = enum_2 = new zzko("INT64", n12, (zzkp)zzkoArray, 0);
        int n13 = 3;
        zzd = zzko11 = new zzko("UINT64", n13, (zzkp)zzkoArray, 0);
        zzkp zzkp2 = zzkp.zza;
        zze = zzko10 = new zzko("INT32", 4, zzkp2, 0);
        zzf = zzko9 = new zzko("FIXED64", n11, (zzkp)zzkoArray, n10);
        zzg = zzko8 = new zzko("FIXED32", 6, zzkp2, n11);
        zzkp zzkp3 = zzkp.zze;
        zzh = zzko7 = new zzko("BOOL", 7, zzkp3, 0);
        zzkp3 = zzkp.zzf;
        zzi = zzko6 = new zzko("STRING", 8, zzkp3, n12);
        zzkp3 = zzkp.zzi;
        zzj = zzko5 = new zzko("GROUP", 9, zzkp3, n13);
        zzko zzko13 = zzko5;
        n11 = 2;
        zzk = zzko4 = new zzko("MESSAGE", 10, zzkp3, n11);
        zzkp3 = zzkp.zzg;
        zzko zzko14 = zzko4;
        zzl = zzko3 = new zzko("BYTES", 11, zzkp3, n11);
        zzm = zzko5 = new zzko("UINT32", 12, zzkp2, 0);
        zzkp3 = zzkp.zzh;
        zzko zzko15 = zzko5;
        zzko zzko16 = zzko3;
        zzn = zzko2 = new zzko("ENUM", 13, zzkp3, 0);
        zzo = zzko4 = new zzko("SFIXED32", 14, zzkp2, 5);
        zzko zzko17 = zzko4;
        zzp = zzko5 = new zzko("SFIXED64", 15, (zzkp)zzkoArray, 1);
        zzq = zzko4 = new zzko("SINT32", 16, zzkp2, 0);
        int n14 = 17;
        zzr = zzko3 = new zzko("SINT64", n14, (zzkp)zzkoArray, 0);
        zzkoArray = new zzko[18];
        zzkoArray[0] = zzko12;
        zzkoArray[1] = enum_;
        zzkoArray[2] = enum_2;
        zzkoArray[3] = zzko11;
        zzkoArray[4] = zzko10;
        zzkoArray[5] = zzko9;
        zzkoArray[6] = zzko8;
        zzkoArray[7] = zzko7;
        zzkoArray[8] = zzko6;
        zzkoArray[9] = zzko13;
        zzkoArray[10] = zzko14;
        zzkoArray[11] = zzko16;
        zzkoArray[12] = zzko15;
        zzkoArray[13] = zzko2;
        zzkoArray[14] = zzko17;
        zzkoArray[15] = zzko5;
        zzkoArray[16] = zzko4;
        zzkoArray[n14] = zzko3;
        zzt = zzkoArray;
    }

    /*
     * WARNING - void declaration
     */
    private zzko() {
        void var3_2;
        void var1_-1;
        this.zzs = var3_2;
    }

    public static zzko[] values() {
        return (zzko[])zzt.clone();
    }

    public final zzkp zza() {
        return this.zzs;
    }
}

