/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzji;
import com.google.android.gms.internal.mlkit_vision_face.zzjj;
import com.google.android.gms.internal.mlkit_vision_face.zzjk;
import com.google.android.gms.internal.mlkit_vision_face.zzjl;
import com.google.android.gms.internal.mlkit_vision_face.zzjm;
import com.google.android.gms.internal.mlkit_vision_face.zzjo;

public class zzjh
extends Enum {
    public static final /* enum */ zzjh zza;
    public static final /* enum */ zzjh zzb;
    public static final /* enum */ zzjh zzc;
    public static final /* enum */ zzjh zzd;
    public static final /* enum */ zzjh zze;
    public static final /* enum */ zzjh zzf;
    public static final /* enum */ zzjh zzg;
    public static final /* enum */ zzjh zzh;
    public static final /* enum */ zzjh zzi;
    public static final /* enum */ zzjh zzj;
    public static final /* enum */ zzjh zzk;
    public static final /* enum */ zzjh zzl;
    public static final /* enum */ zzjh zzm;
    public static final /* enum */ zzjh zzn;
    public static final /* enum */ zzjh zzo;
    public static final /* enum */ zzjh zzp;
    public static final /* enum */ zzjh zzq;
    public static final /* enum */ zzjh zzr;
    private static final /* synthetic */ zzjh[] zzu;
    private final zzjo zzs;
    private final int zzt;

    static {
        zzjh zzjh2;
        zzjh zzjh3;
        zzjh zzjh4;
        zzjh zzjh5;
        zzjh zzjh6;
        zzjh zzjh7;
        zzjh zzjh8;
        Enum enum_ = zzjo.zzd;
        int n10 = 1;
        zza = zzjh8 = new zzjh("DOUBLE", 0, (zzjo)enum_, n10);
        Enum enum_2 = zzjo.zzc;
        int n11 = 5;
        zzb = enum_ = new zzjh("FLOAT", n10, (zzjo)enum_2, n11);
        zzjh[] zzjhArray = zzjo.zzb;
        int n12 = 2;
        zzc = enum_2 = new zzjh("INT64", n12, (zzjo)zzjhArray, 0);
        int n13 = 3;
        zzd = zzjh7 = new zzjh("UINT64", n13, (zzjo)zzjhArray, 0);
        zzjo zzjo2 = zzjo.zza;
        zze = zzjh6 = new zzjh("INT32", 4, zzjo2, 0);
        zzf = zzjh5 = new zzjh("FIXED64", n11, (zzjo)zzjhArray, n10);
        zzg = zzjh4 = new zzjh("FIXED32", 6, zzjo2, n11);
        zzjo zzjo3 = zzjo.zze;
        zzh = zzjh3 = new zzjh("BOOL", 7, zzjo3, 0);
        zzjo3 = zzjo.zzf;
        zzjk zzjk2 = new zzjk(zzjo3, n12);
        zzi = zzjk2;
        zzjo3 = zzjo.zzi;
        zzjh zzjh9 = new zzjj(zzjo3, n13);
        zzj = zzjh9;
        zzjj zzjj2 = zzjh9;
        n11 = 2;
        zzjh zzjh10 = new zzjm(zzjo3, n11);
        zzk = zzjh10;
        zzjo3 = zzjo.zzg;
        zzjm zzjm2 = zzjh10;
        zzjh zzjh11 = new zzjl(zzjo3, n11);
        zzl = zzjh11;
        zzjh9 = new zzjh("UINT32", 12, zzjo2, 0);
        zzm = zzjh9;
        zzjo3 = zzjo.zzh;
        zzjh zzjh12 = zzjh9;
        zzjl zzjl2 = zzjh11;
        zzn = zzjh2 = new zzjh("ENUM", 13, zzjo3, 0);
        zzjh10 = new zzjh("SFIXED32", 14, zzjo2, 5);
        zzo = zzjh10;
        zzjh zzjh13 = zzjh10;
        zzjh9 = new zzjh("SFIXED64", 15, (zzjo)zzjhArray, 1);
        zzp = zzjh9;
        zzjh10 = new zzjh("SINT32", 16, zzjo2, 0);
        zzq = zzjh10;
        int n14 = 17;
        zzjh11 = new zzjh("SINT64", n14, (zzjo)zzjhArray, 0);
        zzr = zzjh11;
        zzjhArray = new zzjh[18];
        zzjhArray[0] = zzjh8;
        zzjhArray[1] = enum_;
        zzjhArray[2] = enum_2;
        zzjhArray[3] = zzjh7;
        zzjhArray[4] = zzjh6;
        zzjhArray[5] = zzjh5;
        zzjhArray[6] = zzjh4;
        zzjhArray[7] = zzjh3;
        zzjhArray[8] = zzjk2;
        zzjhArray[9] = zzjj2;
        zzjhArray[10] = zzjm2;
        zzjhArray[11] = zzjl2;
        zzjhArray[12] = zzjh12;
        zzjhArray[13] = zzjh2;
        zzjhArray[14] = zzjh13;
        zzjhArray[15] = zzjh9;
        zzjhArray[16] = zzjh10;
        zzjhArray[n14] = zzjh11;
        zzu = zzjhArray;
    }

    /*
     * WARNING - void declaration
     */
    private zzjh() {
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
    public /* synthetic */ zzjh(zzjo zzjo2, int n10, zzji zzji2) {
        this((String)var1_-1, n10, (zzjo)((Object)zzji2), (int)var4_3);
        void var4_3;
        void var1_-1;
    }

    public static zzjh[] values() {
        return (zzjh[])zzu.clone();
    }

    public final zzjo zza() {
        return this.zzs;
    }

    public final int zzb() {
        return this.zzt;
    }
}

