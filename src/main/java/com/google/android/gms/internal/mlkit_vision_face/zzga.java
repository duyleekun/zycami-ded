/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzfz;
import com.google.android.gms.internal.mlkit_vision_face.zzgc;
import com.google.android.gms.internal.mlkit_vision_face.zzgn;
import java.lang.reflect.Type;

public final class zzga
extends Enum {
    public static final /* enum */ zzga zza;
    private static final /* enum */ zzga zzaa;
    private static final /* enum */ zzga zzab;
    private static final /* enum */ zzga zzac;
    private static final /* enum */ zzga zzad;
    private static final /* enum */ zzga zzae;
    private static final /* enum */ zzga zzaf;
    private static final /* enum */ zzga zzag;
    private static final /* enum */ zzga zzah;
    private static final /* enum */ zzga zzai;
    private static final /* enum */ zzga zzaj;
    private static final /* enum */ zzga zzak;
    private static final /* enum */ zzga zzal;
    private static final /* enum */ zzga zzam;
    private static final /* enum */ zzga zzan;
    private static final /* enum */ zzga zzao;
    private static final /* enum */ zzga zzap;
    private static final /* enum */ zzga zzaq;
    private static final /* enum */ zzga zzar;
    private static final /* enum */ zzga zzas;
    private static final /* enum */ zzga zzat;
    private static final /* enum */ zzga zzau;
    private static final /* enum */ zzga zzav;
    private static final /* enum */ zzga zzaw;
    private static final /* enum */ zzga zzax;
    private static final /* enum */ zzga zzay;
    public static final /* enum */ zzga zzb;
    private static final zzga[] zzbe;
    private static final Type[] zzbf;
    private static final /* synthetic */ zzga[] zzbg;
    private static final /* enum */ zzga zzc;
    private static final /* enum */ zzga zzd;
    private static final /* enum */ zzga zze;
    private static final /* enum */ zzga zzf;
    private static final /* enum */ zzga zzg;
    private static final /* enum */ zzga zzh;
    private static final /* enum */ zzga zzi;
    private static final /* enum */ zzga zzj;
    private static final /* enum */ zzga zzk;
    private static final /* enum */ zzga zzl;
    private static final /* enum */ zzga zzm;
    private static final /* enum */ zzga zzn;
    private static final /* enum */ zzga zzo;
    private static final /* enum */ zzga zzp;
    private static final /* enum */ zzga zzq;
    private static final /* enum */ zzga zzr;
    private static final /* enum */ zzga zzs;
    private static final /* enum */ zzga zzt;
    private static final /* enum */ zzga zzu;
    private static final /* enum */ zzga zzv;
    private static final /* enum */ zzga zzw;
    private static final /* enum */ zzga zzx;
    private static final /* enum */ zzga zzy;
    private static final /* enum */ zzga zzz;
    private final zzgn zzaz;
    private final int zzba;
    private final zzgc zzbb;
    private final Class zzbc;
    private final boolean zzbd;

    static {
        zzga[] zzgaArray;
        zzgc zzgc2 = zzgc.zza;
        Enum enum_ = zzgn.zze;
        zzga zzga22 = null;
        zzga[] zzgaArray2 = zzgaArray;
        zzga[] zzgaArray3 = zzgc2;
        zzgn zzgn2 = enum_;
        zzgaArray = new zzga("DOUBLE", 0, 0, zzgc2, (zzgn)enum_);
        zzc = zzgaArray;
        Object object = zzgn.zzd;
        zzgaArray2 = zzgaArray;
        zzgn2 = object;
        zzgaArray = new zzga("FLOAT", 1, 1, zzgc2, object);
        zzd = zzgaArray;
        zzgn zzgn3 = zzgn.zzc;
        zzgaArray2 = zzgaArray;
        zzgn2 = zzgn3;
        zzgaArray = new zzga("INT64", 2, 2, zzgc2, zzgn3);
        zze = zzgaArray;
        zzgaArray2 = zzgaArray;
        zzgaArray = new zzga("UINT64", 3, 3, zzgc2, zzgn3);
        zzf = zzgaArray;
        zzgn zzgn4 = zzgn.zzb;
        zzgaArray2 = zzgaArray;
        zzgn2 = zzgn4;
        zzgaArray = new zzga("INT32", 4, 4, zzgc2, zzgn4);
        zzg = zzgaArray;
        zzgaArray2 = zzgaArray;
        zzgn2 = zzgn3;
        zzgaArray = new zzga("FIXED64", 5, 5, zzgc2, zzgn3);
        zzh = zzgaArray;
        zzgaArray2 = zzgaArray;
        zzgn2 = zzgn4;
        zzgaArray = new zzga("FIXED32", 6, 6, zzgc2, zzgn4);
        zzi = zzgaArray;
        Enum enum_2 = zzgn.zzf;
        zzgaArray2 = zzgaArray;
        zzgn2 = enum_2;
        zzgaArray = new zzga("BOOL", 7, 7, zzgc2, (zzgn)enum_2);
        zzj = zzgaArray;
        Enum enum_3 = zzgn.zzg;
        zzgaArray2 = zzgaArray;
        zzgn2 = enum_3;
        zzgaArray = new zzga("STRING", 8, 8, zzgc2, (zzgn)enum_3);
        zzk = zzgaArray;
        zzgn zzgn5 = zzgn.zzj;
        zzgaArray2 = zzgaArray;
        zzgn2 = zzgn5;
        zzgaArray = new zzga("MESSAGE", 9, 9, zzgc2, zzgn5);
        zzl = zzgaArray;
        zzgn zzgn6 = zzgn.zzh;
        zzgaArray2 = zzgaArray;
        zzgn2 = zzgn6;
        zzgaArray = new zzga("BYTES", 10, 10, zzgc2, zzgn6);
        zzm = zzgaArray;
        zzgaArray2 = zzgaArray;
        zzgn2 = zzgn4;
        zzgaArray = new zzga("UINT32", 11, 11, zzgc2, zzgn4);
        zzn = zzgaArray;
        zzgn zzgn7 = zzgn.zzi;
        zzgaArray2 = zzgaArray;
        zzgn2 = zzgn7;
        zzgaArray = new zzga("ENUM", 12, 12, zzgc2, zzgn7);
        zzo = zzgaArray;
        zzgaArray2 = zzgaArray;
        zzgn2 = zzgn4;
        zzgaArray = new zzga("SFIXED32", 13, 13, zzgc2, zzgn4);
        zzp = zzgaArray;
        zzgaArray2 = zzgaArray;
        zzgn2 = zzgn3;
        zzgaArray = new zzga("SFIXED64", 14, 14, zzgc2, zzgn3);
        zzq = zzgaArray;
        zzgaArray2 = zzgaArray;
        zzgn2 = zzgn4;
        zzgaArray = new zzga("SINT32", 15, 15, zzgc2, zzgn4);
        zzr = zzgaArray;
        zzgaArray2 = zzgaArray;
        zzgn2 = zzgn3;
        zzgaArray = new zzga("SINT64", 16, 16, zzgc2, zzgn3);
        zzs = zzgaArray;
        zzgaArray2 = zzgaArray;
        zzgn2 = zzgn5;
        zzgaArray = new zzga("GROUP", 17, 17, zzgc2, zzgn5);
        zzt = zzgaArray;
        zzgc2 = zzgc.zzb;
        zzgaArray2 = zzgaArray;
        zzgaArray3 = zzgc2;
        zzgn2 = enum_;
        zzgaArray = new zzga("DOUBLE_LIST", 18, 18, zzgc2, (zzgn)enum_);
        zzu = zzgaArray;
        zzgaArray2 = zzgaArray;
        zzgn2 = object;
        zzgaArray = new zzga("FLOAT_LIST", 19, 19, zzgc2, object);
        zzv = zzgaArray;
        zzgaArray2 = zzgaArray;
        zzgn2 = zzgn3;
        zzgaArray = new zzga("INT64_LIST", 20, 20, zzgc2, zzgn3);
        zzw = zzgaArray;
        zzgaArray2 = zzgaArray;
        zzgaArray = new zzga("UINT64_LIST", 21, 21, zzgc2, zzgn3);
        zzx = zzgaArray;
        zzgaArray2 = zzgaArray;
        zzgn2 = zzgn4;
        zzgaArray = new zzga("INT32_LIST", 22, 22, zzgc2, zzgn4);
        zzy = zzgaArray;
        zzgaArray2 = zzgaArray;
        zzgn2 = zzgn3;
        zzgaArray = new zzga("FIXED64_LIST", 23, 23, zzgc2, zzgn3);
        zzz = zzgaArray;
        zzgaArray2 = zzgaArray;
        zzgn2 = zzgn4;
        zzgaArray = new zzga("FIXED32_LIST", 24, 24, zzgc2, zzgn4);
        zzaa = zzgaArray;
        zzgaArray2 = zzgaArray;
        zzgn2 = enum_2;
        zzgaArray = new zzga("BOOL_LIST", 25, 25, zzgc2, (zzgn)enum_2);
        zzab = zzgaArray;
        zzgaArray2 = zzgaArray;
        zzgn2 = enum_3;
        zzgaArray = new zzga("STRING_LIST", 26, 26, zzgc2, (zzgn)enum_3);
        zzac = zzgaArray;
        zzgaArray2 = zzgaArray;
        zzgn2 = zzgn5;
        zzgaArray = new zzga("MESSAGE_LIST", 27, 27, zzgc2, zzgn5);
        zzad = zzgaArray;
        zzgaArray2 = zzgaArray;
        zzgn2 = zzgn6;
        zzgaArray = new zzga("BYTES_LIST", 28, 28, zzgc2, zzgn6);
        zzae = zzgaArray;
        zzgaArray2 = zzgaArray;
        zzgn2 = zzgn4;
        zzgaArray = new zzga("UINT32_LIST", 29, 29, zzgc2, zzgn4);
        zzaf = zzgaArray;
        zzgaArray2 = zzgaArray;
        zzgn2 = zzgn7;
        zzgaArray = new zzga("ENUM_LIST", 30, 30, zzgc2, zzgn7);
        zzag = zzgaArray;
        zzgaArray2 = zzgaArray;
        zzgn2 = zzgn4;
        zzgaArray = new zzga("SFIXED32_LIST", 31, 31, zzgc2, zzgn4);
        zzah = zzgaArray;
        zzgaArray2 = zzgaArray;
        zzgn2 = zzgn3;
        zzgaArray = new zzga("SFIXED64_LIST", 32, 32, zzgc2, zzgn3);
        zzai = zzgaArray;
        zzgaArray2 = zzgaArray;
        zzgn2 = zzgn4;
        zzgaArray = new zzga("SINT32_LIST", 33, 33, zzgc2, zzgn4);
        zzaj = zzgaArray;
        zzgaArray2 = zzgaArray;
        zzgn2 = zzgn3;
        zzgaArray = new zzga("SINT64_LIST", 34, 34, zzgc2, zzgn3);
        zzak = zzgaArray;
        enum_3 = zzgc.zzc;
        zzgaArray2 = zzgaArray;
        zzgaArray3 = enum_3;
        zzgn2 = enum_;
        zzgaArray = new zzga("DOUBLE_LIST_PACKED", 35, 35, (zzgc)enum_3, (zzgn)enum_);
        zza = zzgaArray;
        zzgaArray2 = zzgaArray;
        zzgn2 = object;
        zzgaArray = new zzga("FLOAT_LIST_PACKED", 36, 36, (zzgc)enum_3, object);
        zzal = zzgaArray;
        zzgaArray2 = zzgaArray;
        zzgn2 = zzgn3;
        zzgaArray = new zzga("INT64_LIST_PACKED", 37, 37, (zzgc)enum_3, zzgn3);
        zzam = zzgaArray;
        zzgaArray2 = zzgaArray;
        zzgaArray = new zzga("UINT64_LIST_PACKED", 38, 38, (zzgc)enum_3, zzgn3);
        zzan = zzgaArray;
        zzgaArray2 = zzgaArray;
        zzgn2 = zzgn4;
        zzgaArray = new zzga("INT32_LIST_PACKED", 39, 39, (zzgc)enum_3, zzgn4);
        zzao = zzgaArray;
        zzgaArray2 = zzgaArray;
        zzgn2 = zzgn3;
        zzgaArray = new zzga("FIXED64_LIST_PACKED", 40, 40, (zzgc)enum_3, zzgn3);
        zzap = zzgaArray;
        zzgaArray2 = zzgaArray;
        zzgn2 = zzgn4;
        zzgaArray = new zzga("FIXED32_LIST_PACKED", 41, 41, (zzgc)enum_3, zzgn4);
        zzaq = zzgaArray;
        zzgaArray2 = zzgaArray;
        zzgn2 = enum_2;
        zzgaArray = new zzga("BOOL_LIST_PACKED", 42, 42, (zzgc)enum_3, (zzgn)enum_2);
        zzar = zzgaArray;
        zzgaArray2 = zzgaArray;
        zzgn2 = zzgn4;
        zzgaArray = new zzga("UINT32_LIST_PACKED", 43, 43, (zzgc)enum_3, zzgn4);
        zzas = zzgaArray;
        zzgaArray2 = zzgaArray;
        zzgn2 = zzgn7;
        zzgaArray = new zzga("ENUM_LIST_PACKED", 44, 44, (zzgc)enum_3, zzgn7);
        zzat = zzgaArray;
        zzgaArray2 = zzgaArray;
        zzgn2 = zzgn4;
        zzgaArray = new zzga("SFIXED32_LIST_PACKED", 45, 45, (zzgc)enum_3, zzgn4);
        zzau = zzgaArray;
        enum_ = zzgn.zzc;
        zzgaArray2 = zzgaArray;
        zzgn2 = enum_;
        zzgaArray = new zzga("SFIXED64_LIST_PACKED", 46, 46, (zzgc)enum_3, (zzgn)enum_);
        zzav = zzgaArray;
        zzgn2 = zzgn.zzb;
        zzgaArray2 = zzgaArray;
        zzgaArray = new zzga("SINT32_LIST_PACKED", 47, 47, (zzgc)enum_3, zzgn2);
        zzaw = zzgaArray;
        zzgaArray2 = zzgaArray;
        zzgn2 = enum_;
        zzgaArray = new zzga("SINT64_LIST_PACKED", 48, 48, (zzgc)enum_3, (zzgn)enum_);
        zzb = zzgaArray;
        zzgaArray2 = zzgaArray;
        zzgaArray3 = zzgc2;
        zzgn2 = zzgn5;
        zzgaArray = new zzga("GROUP_LIST", 49, 49, zzgc2, zzgn5);
        zzax = zzgaArray;
        enum_2 = zzgc.zzd;
        enum_3 = zzgn.zza;
        object = "MAP";
        int n10 = 50;
        int n11 = 50;
        enum_ = zzgaArray2;
        zzgaArray2 = new zzga((String)object, n10, n11, (zzgc)enum_2, (zzgn)enum_3);
        zzay = zzgaArray2;
        int n12 = 51;
        zzgaArray2 = new zzga[n12];
        zzga[] zzgaArray4 = zzc;
        zzgaArray2[0] = zzgaArray4;
        zzgaArray4 = zzd;
        zzgaArray2[1] = zzgaArray4;
        zzgaArray4 = zze;
        zzgaArray2[2] = zzgaArray4;
        zzgaArray4 = zzf;
        zzgaArray2[3] = zzgaArray4;
        zzgaArray4 = zzg;
        zzgaArray2[4] = zzgaArray4;
        zzgaArray4 = zzh;
        zzgaArray2[5] = zzgaArray4;
        zzgaArray4 = zzi;
        zzgaArray2[6] = zzgaArray4;
        zzgaArray4 = zzj;
        zzgaArray2[7] = zzgaArray4;
        zzgaArray4 = zzk;
        zzgaArray2[8] = zzgaArray4;
        zzgaArray4 = zzl;
        zzgaArray2[9] = zzgaArray4;
        zzgaArray4 = zzm;
        zzgaArray2[10] = zzgaArray4;
        zzgaArray4 = zzn;
        zzgaArray2[11] = zzgaArray4;
        zzgaArray4 = zzo;
        zzgaArray2[12] = zzgaArray4;
        zzgaArray4 = zzp;
        zzgaArray2[13] = zzgaArray4;
        zzgaArray4 = zzq;
        zzgaArray2[14] = zzgaArray4;
        zzgaArray4 = zzr;
        zzgaArray2[15] = zzgaArray4;
        zzgaArray4 = zzs;
        zzgaArray2[16] = zzgaArray4;
        zzgaArray4 = zzt;
        zzgaArray2[17] = zzgaArray4;
        zzgaArray4 = zzu;
        zzgaArray2[18] = zzgaArray4;
        zzgaArray4 = zzv;
        zzgaArray2[19] = zzgaArray4;
        zzgaArray4 = zzw;
        zzgaArray2[20] = zzgaArray4;
        zzgaArray4 = zzx;
        zzgaArray2[21] = zzgaArray4;
        zzgaArray4 = zzy;
        zzgaArray2[22] = zzgaArray4;
        zzgaArray4 = zzz;
        zzgaArray2[23] = zzgaArray4;
        zzgaArray4 = zzaa;
        zzgaArray2[24] = zzgaArray4;
        zzgaArray4 = zzab;
        zzgaArray2[25] = zzgaArray4;
        zzgaArray4 = zzac;
        zzgaArray2[26] = zzgaArray4;
        zzgaArray4 = zzad;
        zzgaArray2[27] = zzgaArray4;
        zzgaArray4 = zzae;
        zzgaArray2[28] = zzgaArray4;
        zzgaArray4 = zzaf;
        zzgaArray2[29] = zzgaArray4;
        zzgaArray4 = zzag;
        zzgaArray2[30] = zzgaArray4;
        zzgaArray4 = zzah;
        zzgaArray2[31] = zzgaArray4;
        zzgaArray4 = zzai;
        zzgaArray2[32] = zzgaArray4;
        zzgaArray4 = zzaj;
        zzgaArray2[33] = zzgaArray4;
        zzgaArray4 = zzak;
        zzgaArray2[34] = zzgaArray4;
        zzgaArray4 = zza;
        zzgaArray2[35] = zzgaArray4;
        zzgaArray4 = zzal;
        zzgaArray2[36] = zzgaArray4;
        zzgaArray4 = zzam;
        zzgaArray2[37] = zzgaArray4;
        zzgaArray4 = zzan;
        zzgaArray2[38] = zzgaArray4;
        zzgaArray4 = zzao;
        zzgaArray2[39] = zzgaArray4;
        zzgaArray4 = zzap;
        zzgaArray2[40] = zzgaArray4;
        zzgaArray4 = zzaq;
        zzgaArray2[41] = zzgaArray4;
        zzgaArray4 = zzar;
        zzgaArray2[42] = zzgaArray4;
        zzgaArray4 = zzas;
        zzgaArray2[43] = zzgaArray4;
        zzgaArray4 = zzat;
        zzgaArray2[44] = zzgaArray4;
        zzgaArray4 = zzau;
        zzgaArray2[45] = zzgaArray4;
        zzgaArray4 = zzav;
        zzgaArray2[46] = zzgaArray4;
        zzgaArray4 = zzaw;
        zzgaArray2[47] = zzgaArray4;
        zzgaArray4 = zzb;
        zzgaArray2[48] = zzgaArray4;
        zzgaArray4 = zzax;
        zzgaArray2[49] = zzgaArray4;
        zzgaArray4 = zzay;
        int n13 = 50;
        zzgaArray2[n13] = zzgaArray4;
        zzbg = zzgaArray2;
        zzbf = new Type[0];
        zzgaArray2 = zzga.values();
        zzgaArray4 = new zzga[zzgaArray2.length];
        zzbe = zzgaArray4;
        for (zzga zzga22 : zzgaArray2) {
            zzgaArray3 = zzbe;
            int n14 = zzga22.zzba;
            zzgaArray3[n14] = zzga22;
        }
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzga(zzgn zzgn2) {
        int n11;
        int n12;
        void var5_4;
        int[] nArray;
        void var2_-1;
        void var1_-1;
        this.zzba = (int)zzgn2;
        this.zzbb = nArray;
        this.zzaz = var5_4;
        Object object = zzfz.zza;
        int n13 = nArray.ordinal();
        int n14 = object[n13];
        n13 = 2;
        int n15 = 1;
        if (n14 != n15) {
            if (n14 != n13) {
                n14 = 0;
                object = null;
                this.zzbc = null;
            } else {
                object = var5_4.zza();
                this.zzbc = object;
            }
        } else {
            object = var5_4.zza();
            this.zzbc = object;
        }
        n14 = 0;
        object = null;
        zzgc zzgc2 = zzgc.zza;
        if (nArray != zzgc2 || (n12 = (nArray = zzfz.zzb)[n11 = var5_4.ordinal()]) == n15 || n12 == n13 || n12 == (n13 = 3)) {
            n15 = 0;
        }
        this.zzbd = n15;
    }

    public static zzga[] values() {
        return (zzga[])zzbg.clone();
    }

    public final int zza() {
        return this.zzba;
    }
}

