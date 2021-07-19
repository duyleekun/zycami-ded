/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzho;
import com.google.android.gms.internal.mlkit_vision_common.zzhp;
import com.google.android.gms.internal.mlkit_vision_common.zzhq;
import com.google.android.gms.internal.mlkit_vision_common.zzhr;
import com.google.android.gms.internal.mlkit_vision_common.zzhs;
import com.google.android.gms.internal.mlkit_vision_common.zzhu;

public class zzhn
extends Enum {
    public static final /* enum */ zzhn zza;
    public static final /* enum */ zzhn zzb;
    public static final /* enum */ zzhn zzc;
    public static final /* enum */ zzhn zzd;
    public static final /* enum */ zzhn zze;
    public static final /* enum */ zzhn zzf;
    public static final /* enum */ zzhn zzg;
    public static final /* enum */ zzhn zzh;
    public static final /* enum */ zzhn zzi;
    public static final /* enum */ zzhn zzj;
    public static final /* enum */ zzhn zzk;
    public static final /* enum */ zzhn zzl;
    public static final /* enum */ zzhn zzm;
    public static final /* enum */ zzhn zzn;
    public static final /* enum */ zzhn zzo;
    public static final /* enum */ zzhn zzp;
    public static final /* enum */ zzhn zzq;
    public static final /* enum */ zzhn zzr;
    private static final /* synthetic */ zzhn[] zzu;
    private final zzhu zzs;
    private final int zzt;

    static {
        zzhn zzhn2;
        zzhn zzhn3;
        zzhn zzhn4;
        zzhn zzhn5;
        zzhn zzhn6;
        zzhn zzhn7;
        zzhn zzhn8;
        Enum enum_ = zzhu.zzd;
        int n10 = 1;
        zza = zzhn8 = new zzhn("DOUBLE", 0, (zzhu)enum_, n10);
        Enum enum_2 = zzhu.zzc;
        int n11 = 5;
        zzb = enum_ = new zzhn("FLOAT", n10, (zzhu)enum_2, n11);
        zzhn[] zzhnArray = zzhu.zzb;
        int n12 = 2;
        zzc = enum_2 = new zzhn("INT64", n12, (zzhu)zzhnArray, 0);
        int n13 = 3;
        zzd = zzhn7 = new zzhn("UINT64", n13, (zzhu)zzhnArray, 0);
        zzhu zzhu2 = zzhu.zza;
        zze = zzhn6 = new zzhn("INT32", 4, zzhu2, 0);
        zzf = zzhn5 = new zzhn("FIXED64", n11, (zzhu)zzhnArray, n10);
        zzg = zzhn4 = new zzhn("FIXED32", 6, zzhu2, n11);
        zzhu zzhu3 = zzhu.zze;
        zzh = zzhn3 = new zzhn("BOOL", 7, zzhu3, 0);
        zzhu3 = zzhu.zzf;
        zzhq zzhq2 = new zzhq(zzhu3, n12);
        zzi = zzhq2;
        zzhu3 = zzhu.zzi;
        zzhn zzhn9 = new zzhp(zzhu3, n13);
        zzj = zzhn9;
        zzhp zzhp2 = zzhn9;
        n11 = 2;
        zzhn zzhn10 = new zzhs(zzhu3, n11);
        zzk = zzhn10;
        zzhu3 = zzhu.zzg;
        zzhs zzhs2 = zzhn10;
        zzhn zzhn11 = new zzhr(zzhu3, n11);
        zzl = zzhn11;
        zzhn9 = new zzhn("UINT32", 12, zzhu2, 0);
        zzm = zzhn9;
        zzhu3 = zzhu.zzh;
        zzhn zzhn12 = zzhn9;
        zzhr zzhr2 = zzhn11;
        zzn = zzhn2 = new zzhn("ENUM", 13, zzhu3, 0);
        zzhn10 = new zzhn("SFIXED32", 14, zzhu2, 5);
        zzo = zzhn10;
        zzhn zzhn13 = zzhn10;
        zzhn9 = new zzhn("SFIXED64", 15, (zzhu)zzhnArray, 1);
        zzp = zzhn9;
        zzhn10 = new zzhn("SINT32", 16, zzhu2, 0);
        zzq = zzhn10;
        int n14 = 17;
        zzhn11 = new zzhn("SINT64", n14, (zzhu)zzhnArray, 0);
        zzr = zzhn11;
        zzhnArray = new zzhn[18];
        zzhnArray[0] = zzhn8;
        zzhnArray[1] = enum_;
        zzhnArray[2] = enum_2;
        zzhnArray[3] = zzhn7;
        zzhnArray[4] = zzhn6;
        zzhnArray[5] = zzhn5;
        zzhnArray[6] = zzhn4;
        zzhnArray[7] = zzhn3;
        zzhnArray[8] = zzhq2;
        zzhnArray[9] = zzhp2;
        zzhnArray[10] = zzhs2;
        zzhnArray[11] = zzhr2;
        zzhnArray[12] = zzhn12;
        zzhnArray[13] = zzhn2;
        zzhnArray[14] = zzhn13;
        zzhnArray[15] = zzhn9;
        zzhnArray[16] = zzhn10;
        zzhnArray[n14] = zzhn11;
        zzu = zzhnArray;
    }

    /*
     * WARNING - void declaration
     */
    private zzhn() {
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
    public /* synthetic */ zzhn(zzhu zzhu2, int n10, zzho zzho2) {
        this((String)var1_-1, n10, (zzhu)((Object)zzho2), (int)var4_3);
        void var4_3;
        void var1_-1;
    }

    public static zzhn[] values() {
        return (zzhn[])zzu.clone();
    }

    public final zzhu zza() {
        return this.zzs;
    }

    public final int zzb() {
        return this.zzt;
    }
}

