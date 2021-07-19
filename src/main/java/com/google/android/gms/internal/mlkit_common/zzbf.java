/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzbe;
import com.google.android.gms.internal.mlkit_common.zzbh;
import com.google.android.gms.internal.mlkit_common.zzfu;
import com.google.android.gms.internal.mlkit_common.zzfv;
import com.google.android.gms.internal.mlkit_common.zzfx;

public final class zzbf
extends Enum
implements zzfv {
    public static final /* enum */ zzbf zza;
    public static final /* enum */ zzbf zzaa;
    private static final /* enum */ zzbf zzab;
    private static final zzfu zzac;
    private static final /* synthetic */ zzbf[] zzae;
    public static final /* enum */ zzbf zzb;
    public static final /* enum */ zzbf zzc;
    public static final /* enum */ zzbf zzd;
    public static final /* enum */ zzbf zze;
    public static final /* enum */ zzbf zzf;
    public static final /* enum */ zzbf zzg;
    public static final /* enum */ zzbf zzh;
    public static final /* enum */ zzbf zzi;
    public static final /* enum */ zzbf zzj;
    public static final /* enum */ zzbf zzk;
    public static final /* enum */ zzbf zzl;
    public static final /* enum */ zzbf zzm;
    public static final /* enum */ zzbf zzn;
    public static final /* enum */ zzbf zzo;
    public static final /* enum */ zzbf zzp;
    public static final /* enum */ zzbf zzq;
    public static final /* enum */ zzbf zzr;
    public static final /* enum */ zzbf zzs;
    public static final /* enum */ zzbf zzt;
    public static final /* enum */ zzbf zzu;
    public static final /* enum */ zzbf zzv;
    public static final /* enum */ zzbf zzw;
    public static final /* enum */ zzbf zzx;
    public static final /* enum */ zzbf zzy;
    public static final /* enum */ zzbf zzz;
    private final int zzad;

    static {
        zzbf zzbf2;
        zzbf zzbf3;
        zzbf zzbf4;
        zzbf zzbf5;
        zzbf zzbf6;
        zzbf zzbf7;
        zzbf zzbf8;
        zzbf zzbf9;
        zzbf zzbf10;
        zzbf zzbf11;
        zzbf zzbf12;
        zzbf zzbf13;
        Object object = new zzbf("NO_ERROR", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzbf13 = new zzbf("INCOMPATIBLE_INPUT", n10, n10);
        int n11 = 2;
        zzc = zzbf12 = new zzbf("INCOMPATIBLE_OUTPUT", n11, n11);
        int n12 = 3;
        zzd = zzbf11 = new zzbf("INCOMPATIBLE_TFLITE_VERSION", n12, n12);
        int n13 = 4;
        zze = zzbf10 = new zzbf("MISSING_OP", n13, n13);
        int n14 = 5;
        int n15 = 6;
        zzf = zzbf9 = new zzbf("DATA_TYPE_ERROR", n14, n15);
        int n16 = 7;
        zzg = zzbf8 = new zzbf("TFLITE_INTERNAL_ERROR", n15, n16);
        n13 = 8;
        zzh = zzbf7 = new zzbf("TFLITE_UNKNOWN_ERROR", n16, n13);
        n12 = 9;
        zzab = zzbf6 = new zzbf("MEDIAPIPE_ERROR", n13, n12);
        zzi = zzbf5 = new zzbf("TIME_OUT_FETCHING_MODEL_METADATA", n12, n14);
        zzj = zzbf4 = new zzbf("MODEL_NOT_DOWNLOADED", 10, 100);
        zzk = zzbf3 = new zzbf("URI_EXPIRED", 11, 101);
        zzbf[] zzbfArray = new zzbf("NO_NETWORK_CONNECTION", 12, 102);
        zzl = zzbfArray;
        zzbf[] zzbfArray2 = zzbfArray;
        zzm = zzbf2 = new zzbf("METERED_NETWORK", 13, 103);
        zzbf zzbf14 = zzbf2;
        zzbfArray = new zzbf("DOWNLOAD_FAILED", 14, 104);
        zzn = zzbfArray;
        zzbf[] zzbfArray3 = zzbfArray;
        zzo = zzbf2 = new zzbf("MODEL_INFO_DOWNLOAD_UNSUCCESSFUL_HTTP_STATUS", 15, 105);
        zzbf zzbf15 = zzbf2;
        zzbfArray = new zzbf("MODEL_INFO_DOWNLOAD_NO_HASH", 16, 106);
        zzp = zzbfArray;
        zzbf[] zzbfArray4 = zzbfArray;
        zzq = zzbf2 = new zzbf("MODEL_INFO_DOWNLOAD_CONNECTION_FAILED", 17, 107);
        zzbf zzbf16 = zzbf2;
        zzbfArray = new zzbf("NO_VALID_MODEL", 18, 108);
        zzr = zzbfArray;
        zzbf[] zzbfArray5 = zzbfArray;
        zzs = zzbf2 = new zzbf("LOCAL_MODEL_INVALID", 19, 109);
        zzbf zzbf17 = zzbf2;
        zzbfArray = new zzbf("REMOTE_MODEL_INVALID", 20, 110);
        zzt = zzbfArray;
        zzbf[] zzbfArray6 = zzbfArray;
        zzu = zzbf2 = new zzbf("REMOTE_MODEL_LOADER_ERROR", 21, 111);
        zzbf zzbf18 = zzbf2;
        zzbfArray = new zzbf("REMOTE_MODEL_LOADER_LOADS_NO_MODEL", 22, 112);
        zzv = zzbfArray;
        zzbf[] zzbfArray7 = zzbfArray;
        zzw = zzbf2 = new zzbf("SMART_REPLY_LANG_ID_DETECTAION_FAILURE", 23, 113);
        zzbf zzbf19 = zzbf2;
        zzbfArray = new zzbf("MODEL_NOT_REGISTERED", 24, 114);
        zzx = zzbfArray;
        zzbf[] zzbfArray8 = zzbfArray;
        zzy = zzbf2 = new zzbf("MODEL_TYPE_MISUSE", 25, 115);
        zzbf zzbf20 = zzbf2;
        zzbfArray = new zzbf("MODEL_HASH_MISMATCH", 26, 116);
        zzz = zzbfArray;
        zzbf[] zzbfArray9 = zzbfArray;
        zzaa = zzbf2 = new zzbf("UNKNOWN_ERROR", 27, 9999);
        zzbfArray = new zzbf[]{object, zzbf13, zzbf12, zzbf11, zzbf10, zzbf9, zzbf8, zzbf7, zzbf6, zzbf5, zzbf4, zzbf3, zzbfArray2, zzbf14, zzbfArray3, zzbf15, zzbfArray4, zzbf16, zzbfArray5, zzbf17, zzbfArray6, zzbf18, zzbfArray7, zzbf19, zzbfArray8, zzbf20, zzbfArray9, zzbf2};
        zzae = zzbfArray;
        zzac = object = new zzbe();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzbf() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzad = var3_1;
    }

    public static zzbf[] values() {
        return (zzbf[])zzae.clone();
    }

    public static zzfx zzb() {
        return zzbh.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzbf.class.getName();
        stringBuilder.append(string2);
        stringBuilder.append('@');
        string2 = Integer.toHexString(System.identityHashCode(this));
        stringBuilder.append(string2);
        stringBuilder.append(" number=");
        int n10 = this.zzad;
        stringBuilder.append(n10);
        stringBuilder.append(" name=");
        string2 = this.name();
        stringBuilder.append(string2);
        stringBuilder.append('>');
        return stringBuilder.toString();
    }

    public final int zza() {
        return this.zzad;
    }
}

