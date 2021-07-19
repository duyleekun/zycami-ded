/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zziu;
import com.google.android.gms.internal.mlkit_common.zziw;
import com.google.android.gms.internal.mlkit_common.zziy;
import com.google.android.gms.internal.mlkit_common.zziz;
import com.google.android.gms.internal.mlkit_common.zzja;
import com.google.android.gms.internal.mlkit_common.zzjb;

public class zzix
extends Enum {
    public static final /* enum */ zzix zza;
    public static final /* enum */ zzix zzb;
    public static final /* enum */ zzix zzc;
    public static final /* enum */ zzix zzd;
    public static final /* enum */ zzix zze;
    public static final /* enum */ zzix zzf;
    public static final /* enum */ zzix zzg;
    public static final /* enum */ zzix zzh;
    public static final /* enum */ zzix zzi;
    public static final /* enum */ zzix zzj;
    public static final /* enum */ zzix zzk;
    public static final /* enum */ zzix zzl;
    public static final /* enum */ zzix zzm;
    public static final /* enum */ zzix zzn;
    public static final /* enum */ zzix zzo;
    public static final /* enum */ zzix zzp;
    public static final /* enum */ zzix zzq;
    public static final /* enum */ zzix zzr;
    private static final /* synthetic */ zzix[] zzu;
    private final zzja zzs;
    private final int zzt;

    static {
        zzix zzix2;
        zzix zzix3;
        zzix zzix4;
        zzix zzix5;
        zzix zzix6;
        zzix zzix7;
        zzix zzix8;
        Enum enum_ = zzja.zzd;
        int n10 = 1;
        zza = zzix8 = new zzix("DOUBLE", 0, (zzja)enum_, n10);
        Enum enum_2 = zzja.zzc;
        int n11 = 5;
        zzb = enum_ = new zzix("FLOAT", n10, (zzja)enum_2, n11);
        zzix[] zzixArray = zzja.zzb;
        int n12 = 2;
        zzc = enum_2 = new zzix("INT64", n12, (zzja)zzixArray, 0);
        int n13 = 3;
        zzd = zzix7 = new zzix("UINT64", n13, (zzja)zzixArray, 0);
        zzja zzja2 = zzja.zza;
        zze = zzix6 = new zzix("INT32", 4, zzja2, 0);
        zzf = zzix5 = new zzix("FIXED64", n11, (zzja)zzixArray, n10);
        zzg = zzix4 = new zzix("FIXED32", 6, zzja2, n11);
        zzja zzja3 = zzja.zze;
        zzh = zzix3 = new zzix("BOOL", 7, zzja3, 0);
        zzja3 = zzja.zzf;
        zziw zziw2 = new zziw(zzja3, n12);
        zzi = zziw2;
        zzja3 = zzja.zzi;
        zzix zzix9 = new zziz(zzja3, n13);
        zzj = zzix9;
        zziz zziz2 = zzix9;
        n11 = 2;
        zzix zzix10 = new zziy(zzja3, n11);
        zzk = zzix10;
        zzja3 = zzja.zzg;
        zziy zziy2 = zzix10;
        zzix zzix11 = new zzjb(zzja3, n11);
        zzl = zzix11;
        zzix9 = new zzix("UINT32", 12, zzja2, 0);
        zzm = zzix9;
        zzja3 = zzja.zzh;
        zzix zzix12 = zzix9;
        zzjb zzjb2 = zzix11;
        zzn = zzix2 = new zzix("ENUM", 13, zzja3, 0);
        zzix10 = new zzix("SFIXED32", 14, zzja2, 5);
        zzo = zzix10;
        zzix zzix13 = zzix10;
        zzix9 = new zzix("SFIXED64", 15, (zzja)zzixArray, 1);
        zzp = zzix9;
        zzix10 = new zzix("SINT32", 16, zzja2, 0);
        zzq = zzix10;
        int n14 = 17;
        zzix11 = new zzix("SINT64", n14, (zzja)zzixArray, 0);
        zzr = zzix11;
        zzixArray = new zzix[18];
        zzixArray[0] = zzix8;
        zzixArray[1] = enum_;
        zzixArray[2] = enum_2;
        zzixArray[3] = zzix7;
        zzixArray[4] = zzix6;
        zzixArray[5] = zzix5;
        zzixArray[6] = zzix4;
        zzixArray[7] = zzix3;
        zzixArray[8] = zziw2;
        zzixArray[9] = zziz2;
        zzixArray[10] = zziy2;
        zzixArray[11] = zzjb2;
        zzixArray[12] = zzix12;
        zzixArray[13] = zzix2;
        zzixArray[14] = zzix13;
        zzixArray[15] = zzix9;
        zzixArray[16] = zzix10;
        zzixArray[n14] = zzix11;
        zzu = zzixArray;
    }

    /*
     * WARNING - void declaration
     */
    private zzix() {
        void var4_2;
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzs = var3_1;
        this.zzt = var4_2;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public /* synthetic */ zzix(zzja zzja2, int n10, zziu zziu2) {
        this((String)var1_-1, n10, (zzja)((Object)zziu2), (int)var4_3);
        void var4_3;
        void var1_-1;
    }

    public static zzix[] values() {
        return (zzix[])zzu.clone();
    }

    public final zzja zza() {
        return this.zzs;
    }

    public final int zzb() {
        return this.zzt;
    }
}

