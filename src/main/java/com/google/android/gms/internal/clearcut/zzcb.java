/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcc;
import com.google.android.gms.internal.clearcut.zzcd;
import com.google.android.gms.internal.clearcut.zzcq;
import java.lang.reflect.Type;

public final class zzcb
extends Enum {
    private static final /* enum */ zzcb zzgy;
    private static final /* enum */ zzcb zzgz;
    private static final /* enum */ zzcb zzha;
    private static final /* enum */ zzcb zzhb;
    private static final /* enum */ zzcb zzhc;
    private static final /* enum */ zzcb zzhd;
    private static final /* enum */ zzcb zzhe;
    private static final /* enum */ zzcb zzhf;
    private static final /* enum */ zzcb zzhg;
    public static final /* enum */ zzcb zzhh;
    private static final /* enum */ zzcb zzhi;
    private static final /* enum */ zzcb zzhj;
    public static final /* enum */ zzcb zzhk;
    private static final /* enum */ zzcb zzhl;
    private static final /* enum */ zzcb zzhm;
    private static final /* enum */ zzcb zzhn;
    private static final /* enum */ zzcb zzho;
    public static final /* enum */ zzcb zzhp;
    public static final /* enum */ zzcb zzhq;
    private static final /* enum */ zzcb zzhr;
    private static final /* enum */ zzcb zzhs;
    private static final /* enum */ zzcb zzht;
    private static final /* enum */ zzcb zzhu;
    private static final /* enum */ zzcb zzhv;
    private static final /* enum */ zzcb zzhw;
    private static final /* enum */ zzcb zzhx;
    private static final /* enum */ zzcb zzhy;
    public static final /* enum */ zzcb zzhz;
    private static final /* enum */ zzcb zzia;
    private static final /* enum */ zzcb zzib;
    public static final /* enum */ zzcb zzic;
    private static final /* enum */ zzcb zzid;
    private static final /* enum */ zzcb zzie;
    private static final /* enum */ zzcb zzif;
    private static final /* enum */ zzcb zzig;
    public static final /* enum */ zzcb zzih;
    private static final /* enum */ zzcb zzii;
    private static final /* enum */ zzcb zzij;
    private static final /* enum */ zzcb zzik;
    private static final /* enum */ zzcb zzil;
    private static final /* enum */ zzcb zzim;
    private static final /* enum */ zzcb zzin;
    private static final /* enum */ zzcb zzio;
    private static final /* enum */ zzcb zzip;
    public static final /* enum */ zzcb zziq;
    private static final /* enum */ zzcb zzir;
    private static final /* enum */ zzcb zzis;
    private static final /* enum */ zzcb zzit;
    public static final /* enum */ zzcb zziu;
    public static final /* enum */ zzcb zziv;
    public static final /* enum */ zzcb zziw;
    private static final zzcb[] zzjb;
    private static final Type[] zzjc;
    private static final /* synthetic */ zzcb[] zzjd;
    private final int id;
    private final zzcq zzix;
    private final zzcd zziy;
    private final Class zziz;
    private final boolean zzja;

    static {
        zzcb[] zzcbArray;
        zzcd zzcd2 = zzcd.zzjg;
        Enum enum_ = zzcq.zzlb;
        zzcb zzcb22 = null;
        zzcb[] zzcbArray2 = zzcbArray;
        zzcb[] zzcbArray3 = zzcd2;
        zzcq zzcq2 = enum_;
        zzcbArray = new zzcb("DOUBLE", 0, 0, zzcd2, (zzcq)enum_);
        zzgy = zzcbArray;
        Object object = zzcq.zzla;
        zzcbArray2 = zzcbArray;
        zzcq2 = object;
        zzcbArray = new zzcb("FLOAT", 1, 1, zzcd2, object);
        zzgz = zzcbArray;
        zzcq zzcq3 = zzcq.zzkz;
        zzcbArray2 = zzcbArray;
        zzcq2 = zzcq3;
        zzcbArray = new zzcb("INT64", 2, 2, zzcd2, zzcq3);
        zzha = zzcbArray;
        zzcbArray2 = zzcbArray;
        zzcbArray = new zzcb("UINT64", 3, 3, zzcd2, zzcq3);
        zzhb = zzcbArray;
        zzcq zzcq4 = zzcq.zzky;
        zzcbArray2 = zzcbArray;
        zzcq2 = zzcq4;
        zzcbArray = new zzcb("INT32", 4, 4, zzcd2, zzcq4);
        zzhc = zzcbArray;
        zzcbArray2 = zzcbArray;
        zzcq2 = zzcq3;
        zzcbArray = new zzcb("FIXED64", 5, 5, zzcd2, zzcq3);
        zzhd = zzcbArray;
        zzcbArray2 = zzcbArray;
        zzcq2 = zzcq4;
        zzcbArray = new zzcb("FIXED32", 6, 6, zzcd2, zzcq4);
        zzhe = zzcbArray;
        Enum enum_2 = zzcq.zzlc;
        zzcbArray2 = zzcbArray;
        zzcq2 = enum_2;
        zzcbArray = new zzcb("BOOL", 7, 7, zzcd2, (zzcq)enum_2);
        zzhf = zzcbArray;
        Enum enum_3 = zzcq.zzld;
        zzcbArray2 = zzcbArray;
        zzcq2 = enum_3;
        zzcbArray = new zzcb("STRING", 8, 8, zzcd2, (zzcq)enum_3);
        zzhg = zzcbArray;
        zzcq zzcq5 = zzcq.zzlg;
        zzcbArray2 = zzcbArray;
        zzcq2 = zzcq5;
        zzcbArray = new zzcb("MESSAGE", 9, 9, zzcd2, zzcq5);
        zzhh = zzcbArray;
        zzcq zzcq6 = zzcq.zzle;
        zzcbArray2 = zzcbArray;
        zzcq2 = zzcq6;
        zzcbArray = new zzcb("BYTES", 10, 10, zzcd2, zzcq6);
        zzhi = zzcbArray;
        zzcbArray2 = zzcbArray;
        zzcq2 = zzcq4;
        zzcbArray = new zzcb("UINT32", 11, 11, zzcd2, zzcq4);
        zzhj = zzcbArray;
        zzcq zzcq7 = zzcq.zzlf;
        zzcbArray2 = zzcbArray;
        zzcq2 = zzcq7;
        zzcbArray = new zzcb("ENUM", 12, 12, zzcd2, zzcq7);
        zzhk = zzcbArray;
        zzcbArray2 = zzcbArray;
        zzcq2 = zzcq4;
        zzcbArray = new zzcb("SFIXED32", 13, 13, zzcd2, zzcq4);
        zzhl = zzcbArray;
        zzcbArray2 = zzcbArray;
        zzcq2 = zzcq3;
        zzcbArray = new zzcb("SFIXED64", 14, 14, zzcd2, zzcq3);
        zzhm = zzcbArray;
        zzcbArray2 = zzcbArray;
        zzcq2 = zzcq4;
        zzcbArray = new zzcb("SINT32", 15, 15, zzcd2, zzcq4);
        zzhn = zzcbArray;
        zzcbArray2 = zzcbArray;
        zzcq2 = zzcq3;
        zzcbArray = new zzcb("SINT64", 16, 16, zzcd2, zzcq3);
        zzho = zzcbArray;
        zzcbArray2 = zzcbArray;
        zzcq2 = zzcq5;
        zzcbArray = new zzcb("GROUP", 17, 17, zzcd2, zzcq5);
        zzhp = zzcbArray;
        zzcd2 = zzcd.zzjh;
        zzcbArray2 = zzcbArray;
        zzcbArray3 = zzcd2;
        zzcq2 = enum_;
        zzcbArray = new zzcb("DOUBLE_LIST", 18, 18, zzcd2, (zzcq)enum_);
        zzhq = zzcbArray;
        zzcbArray2 = zzcbArray;
        zzcq2 = object;
        zzcbArray = new zzcb("FLOAT_LIST", 19, 19, zzcd2, object);
        zzhr = zzcbArray;
        zzcbArray2 = zzcbArray;
        zzcq2 = zzcq3;
        zzcbArray = new zzcb("INT64_LIST", 20, 20, zzcd2, zzcq3);
        zzhs = zzcbArray;
        zzcbArray2 = zzcbArray;
        zzcbArray = new zzcb("UINT64_LIST", 21, 21, zzcd2, zzcq3);
        zzht = zzcbArray;
        zzcbArray2 = zzcbArray;
        zzcq2 = zzcq4;
        zzcbArray = new zzcb("INT32_LIST", 22, 22, zzcd2, zzcq4);
        zzhu = zzcbArray;
        zzcbArray2 = zzcbArray;
        zzcq2 = zzcq3;
        zzcbArray = new zzcb("FIXED64_LIST", 23, 23, zzcd2, zzcq3);
        zzhv = zzcbArray;
        zzcbArray2 = zzcbArray;
        zzcq2 = zzcq4;
        zzcbArray = new zzcb("FIXED32_LIST", 24, 24, zzcd2, zzcq4);
        zzhw = zzcbArray;
        zzcbArray2 = zzcbArray;
        zzcq2 = enum_2;
        zzcbArray = new zzcb("BOOL_LIST", 25, 25, zzcd2, (zzcq)enum_2);
        zzhx = zzcbArray;
        zzcbArray2 = zzcbArray;
        zzcq2 = enum_3;
        zzcbArray = new zzcb("STRING_LIST", 26, 26, zzcd2, (zzcq)enum_3);
        zzhy = zzcbArray;
        zzcbArray2 = zzcbArray;
        zzcq2 = zzcq5;
        zzcbArray = new zzcb("MESSAGE_LIST", 27, 27, zzcd2, zzcq5);
        zzhz = zzcbArray;
        zzcbArray2 = zzcbArray;
        zzcq2 = zzcq6;
        zzcbArray = new zzcb("BYTES_LIST", 28, 28, zzcd2, zzcq6);
        zzia = zzcbArray;
        zzcbArray2 = zzcbArray;
        zzcq2 = zzcq4;
        zzcbArray = new zzcb("UINT32_LIST", 29, 29, zzcd2, zzcq4);
        zzib = zzcbArray;
        zzcbArray2 = zzcbArray;
        zzcq2 = zzcq7;
        zzcbArray = new zzcb("ENUM_LIST", 30, 30, zzcd2, zzcq7);
        zzic = zzcbArray;
        zzcbArray2 = zzcbArray;
        zzcq2 = zzcq4;
        zzcbArray = new zzcb("SFIXED32_LIST", 31, 31, zzcd2, zzcq4);
        zzid = zzcbArray;
        zzcbArray2 = zzcbArray;
        zzcq2 = zzcq3;
        zzcbArray = new zzcb("SFIXED64_LIST", 32, 32, zzcd2, zzcq3);
        zzie = zzcbArray;
        zzcbArray2 = zzcbArray;
        zzcq2 = zzcq4;
        zzcbArray = new zzcb("SINT32_LIST", 33, 33, zzcd2, zzcq4);
        zzif = zzcbArray;
        zzcbArray2 = zzcbArray;
        zzcq2 = zzcq3;
        zzcbArray = new zzcb("SINT64_LIST", 34, 34, zzcd2, zzcq3);
        zzig = zzcbArray;
        enum_3 = zzcd.zzji;
        zzcbArray2 = zzcbArray;
        zzcbArray3 = enum_3;
        zzcq2 = enum_;
        zzcbArray = new zzcb("DOUBLE_LIST_PACKED", 35, 35, (zzcd)enum_3, (zzcq)enum_);
        zzih = zzcbArray;
        zzcbArray2 = zzcbArray;
        zzcq2 = object;
        zzcbArray = new zzcb("FLOAT_LIST_PACKED", 36, 36, (zzcd)enum_3, object);
        zzii = zzcbArray;
        zzcbArray2 = zzcbArray;
        zzcq2 = zzcq3;
        zzcbArray = new zzcb("INT64_LIST_PACKED", 37, 37, (zzcd)enum_3, zzcq3);
        zzij = zzcbArray;
        zzcbArray2 = zzcbArray;
        zzcbArray = new zzcb("UINT64_LIST_PACKED", 38, 38, (zzcd)enum_3, zzcq3);
        zzik = zzcbArray;
        zzcbArray2 = zzcbArray;
        zzcq2 = zzcq4;
        zzcbArray = new zzcb("INT32_LIST_PACKED", 39, 39, (zzcd)enum_3, zzcq4);
        zzil = zzcbArray;
        zzcbArray2 = zzcbArray;
        zzcq2 = zzcq3;
        zzcbArray = new zzcb("FIXED64_LIST_PACKED", 40, 40, (zzcd)enum_3, zzcq3);
        zzim = zzcbArray;
        zzcbArray2 = zzcbArray;
        zzcq2 = zzcq4;
        zzcbArray = new zzcb("FIXED32_LIST_PACKED", 41, 41, (zzcd)enum_3, zzcq4);
        zzin = zzcbArray;
        zzcbArray2 = zzcbArray;
        zzcq2 = enum_2;
        zzcbArray = new zzcb("BOOL_LIST_PACKED", 42, 42, (zzcd)enum_3, (zzcq)enum_2);
        zzio = zzcbArray;
        zzcbArray2 = zzcbArray;
        zzcq2 = zzcq4;
        zzcbArray = new zzcb("UINT32_LIST_PACKED", 43, 43, (zzcd)enum_3, zzcq4);
        zzip = zzcbArray;
        zzcbArray2 = zzcbArray;
        zzcq2 = zzcq7;
        zzcbArray = new zzcb("ENUM_LIST_PACKED", 44, 44, (zzcd)enum_3, zzcq7);
        zziq = zzcbArray;
        zzcbArray2 = zzcbArray;
        zzcq2 = zzcq4;
        zzcbArray = new zzcb("SFIXED32_LIST_PACKED", 45, 45, (zzcd)enum_3, zzcq4);
        zzir = zzcbArray;
        enum_ = zzcq.zzkz;
        zzcbArray2 = zzcbArray;
        zzcq2 = enum_;
        zzcbArray = new zzcb("SFIXED64_LIST_PACKED", 46, 46, (zzcd)enum_3, (zzcq)enum_);
        zzis = zzcbArray;
        zzcq2 = zzcq.zzky;
        zzcbArray2 = zzcbArray;
        zzcbArray = new zzcb("SINT32_LIST_PACKED", 47, 47, (zzcd)enum_3, zzcq2);
        zzit = zzcbArray;
        zzcbArray2 = zzcbArray;
        zzcq2 = enum_;
        zzcbArray = new zzcb("SINT64_LIST_PACKED", 48, 48, (zzcd)enum_3, (zzcq)enum_);
        zziu = zzcbArray;
        zzcbArray2 = zzcbArray;
        zzcbArray3 = zzcd2;
        zzcq2 = zzcq5;
        zzcbArray = new zzcb("GROUP_LIST", 49, 49, zzcd2, zzcq5);
        zziv = zzcbArray;
        enum_2 = zzcd.zzjj;
        enum_3 = zzcq.zzkx;
        object = "MAP";
        int n10 = 50;
        int n11 = 50;
        enum_ = zzcbArray2;
        zzcbArray2 = new zzcb((String)object, n10, n11, (zzcd)enum_2, (zzcq)enum_3);
        zziw = zzcbArray2;
        int n12 = 51;
        zzcbArray2 = new zzcb[n12];
        zzcb[] zzcbArray4 = zzgy;
        zzcbArray2[0] = zzcbArray4;
        zzcbArray4 = zzgz;
        zzcbArray2[1] = zzcbArray4;
        zzcbArray4 = zzha;
        zzcbArray2[2] = zzcbArray4;
        zzcbArray4 = zzhb;
        zzcbArray2[3] = zzcbArray4;
        zzcbArray4 = zzhc;
        zzcbArray2[4] = zzcbArray4;
        zzcbArray4 = zzhd;
        zzcbArray2[5] = zzcbArray4;
        zzcbArray4 = zzhe;
        zzcbArray2[6] = zzcbArray4;
        zzcbArray4 = zzhf;
        zzcbArray2[7] = zzcbArray4;
        zzcbArray4 = zzhg;
        zzcbArray2[8] = zzcbArray4;
        zzcbArray4 = zzhh;
        zzcbArray2[9] = zzcbArray4;
        zzcbArray4 = zzhi;
        zzcbArray2[10] = zzcbArray4;
        zzcbArray4 = zzhj;
        zzcbArray2[11] = zzcbArray4;
        zzcbArray4 = zzhk;
        zzcbArray2[12] = zzcbArray4;
        zzcbArray4 = zzhl;
        zzcbArray2[13] = zzcbArray4;
        zzcbArray4 = zzhm;
        zzcbArray2[14] = zzcbArray4;
        zzcbArray4 = zzhn;
        zzcbArray2[15] = zzcbArray4;
        zzcbArray4 = zzho;
        zzcbArray2[16] = zzcbArray4;
        zzcbArray4 = zzhp;
        zzcbArray2[17] = zzcbArray4;
        zzcbArray4 = zzhq;
        zzcbArray2[18] = zzcbArray4;
        zzcbArray4 = zzhr;
        zzcbArray2[19] = zzcbArray4;
        zzcbArray4 = zzhs;
        zzcbArray2[20] = zzcbArray4;
        zzcbArray4 = zzht;
        zzcbArray2[21] = zzcbArray4;
        zzcbArray4 = zzhu;
        zzcbArray2[22] = zzcbArray4;
        zzcbArray4 = zzhv;
        zzcbArray2[23] = zzcbArray4;
        zzcbArray4 = zzhw;
        zzcbArray2[24] = zzcbArray4;
        zzcbArray4 = zzhx;
        zzcbArray2[25] = zzcbArray4;
        zzcbArray4 = zzhy;
        zzcbArray2[26] = zzcbArray4;
        zzcbArray4 = zzhz;
        zzcbArray2[27] = zzcbArray4;
        zzcbArray4 = zzia;
        zzcbArray2[28] = zzcbArray4;
        zzcbArray4 = zzib;
        zzcbArray2[29] = zzcbArray4;
        zzcbArray4 = zzic;
        zzcbArray2[30] = zzcbArray4;
        zzcbArray4 = zzid;
        zzcbArray2[31] = zzcbArray4;
        zzcbArray4 = zzie;
        zzcbArray2[32] = zzcbArray4;
        zzcbArray4 = zzif;
        zzcbArray2[33] = zzcbArray4;
        zzcbArray4 = zzig;
        zzcbArray2[34] = zzcbArray4;
        zzcbArray4 = zzih;
        zzcbArray2[35] = zzcbArray4;
        zzcbArray4 = zzii;
        zzcbArray2[36] = zzcbArray4;
        zzcbArray4 = zzij;
        zzcbArray2[37] = zzcbArray4;
        zzcbArray4 = zzik;
        zzcbArray2[38] = zzcbArray4;
        zzcbArray4 = zzil;
        zzcbArray2[39] = zzcbArray4;
        zzcbArray4 = zzim;
        zzcbArray2[40] = zzcbArray4;
        zzcbArray4 = zzin;
        zzcbArray2[41] = zzcbArray4;
        zzcbArray4 = zzio;
        zzcbArray2[42] = zzcbArray4;
        zzcbArray4 = zzip;
        zzcbArray2[43] = zzcbArray4;
        zzcbArray4 = zziq;
        zzcbArray2[44] = zzcbArray4;
        zzcbArray4 = zzir;
        zzcbArray2[45] = zzcbArray4;
        zzcbArray4 = zzis;
        zzcbArray2[46] = zzcbArray4;
        zzcbArray4 = zzit;
        zzcbArray2[47] = zzcbArray4;
        zzcbArray4 = zziu;
        zzcbArray2[48] = zzcbArray4;
        zzcbArray4 = zziv;
        zzcbArray2[49] = zzcbArray4;
        zzcbArray4 = zziw;
        int n13 = 50;
        zzcbArray2[n13] = zzcbArray4;
        zzjd = zzcbArray2;
        zzjc = new Type[0];
        zzcbArray2 = zzcb.values();
        zzcbArray4 = new zzcb[zzcbArray2.length];
        zzjb = zzcbArray4;
        for (zzcb zzcb22 : zzcbArray2) {
            zzcbArray3 = zzjb;
            int n14 = zzcb22.id;
            zzcbArray3[n14] = zzcb22;
        }
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzcb(zzcq zzcq2) {
        int n11;
        int n12;
        void var5_4;
        int[] nArray;
        void var2_-1;
        void var1_-1;
        this.id = (int)zzcq2;
        this.zziy = nArray;
        this.zzix = var5_4;
        Object object = zzcc.zzje;
        int n13 = nArray.ordinal();
        int n14 = object[n13];
        n13 = 2;
        int n15 = 1;
        if (n14 != n15 && n14 != n13) {
            n14 = 0;
            object = null;
        } else {
            object = var5_4.zzbq();
        }
        this.zziz = object;
        n14 = 0;
        object = null;
        zzcd zzcd2 = zzcd.zzjg;
        if (nArray != zzcd2 || (n12 = (nArray = zzcc.zzjf)[n11 = var5_4.ordinal()]) == n15 || n12 == n13 || n12 == (n13 = 3)) {
            n15 = 0;
        }
        this.zzja = n15;
    }

    public static zzcb[] values() {
        return (zzcb[])zzjd.clone();
    }

    public final int id() {
        return this.id;
    }
}

