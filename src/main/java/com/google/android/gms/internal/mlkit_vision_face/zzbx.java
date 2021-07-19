/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzby;
import com.google.android.gms.internal.mlkit_vision_face.zzbz;
import com.google.android.gms.internal.mlkit_vision_face.zzgf;
import com.google.android.gms.internal.mlkit_vision_face.zzgh;
import com.google.android.gms.internal.mlkit_vision_face.zzgi;

public final class zzbx
extends Enum
implements zzgf {
    public static final /* enum */ zzbx zza;
    private static final /* enum */ zzbx zzaa;
    private static final /* enum */ zzbx zzab;
    private static final zzgi zzac;
    private static final /* synthetic */ zzbx[] zzae;
    public static final /* enum */ zzbx zzb;
    public static final /* enum */ zzbx zzc;
    private static final /* enum */ zzbx zzd;
    private static final /* enum */ zzbx zze;
    private static final /* enum */ zzbx zzf;
    private static final /* enum */ zzbx zzg;
    private static final /* enum */ zzbx zzh;
    private static final /* enum */ zzbx zzi;
    private static final /* enum */ zzbx zzj;
    private static final /* enum */ zzbx zzk;
    private static final /* enum */ zzbx zzl;
    private static final /* enum */ zzbx zzm;
    private static final /* enum */ zzbx zzn;
    private static final /* enum */ zzbx zzo;
    private static final /* enum */ zzbx zzp;
    private static final /* enum */ zzbx zzq;
    private static final /* enum */ zzbx zzr;
    private static final /* enum */ zzbx zzs;
    private static final /* enum */ zzbx zzt;
    private static final /* enum */ zzbx zzu;
    private static final /* enum */ zzbx zzv;
    private static final /* enum */ zzbx zzw;
    private static final /* enum */ zzbx zzx;
    private static final /* enum */ zzbx zzy;
    private static final /* enum */ zzbx zzz;
    private final int zzad;

    static {
        zzbx zzbx2;
        zzbx zzbx3;
        zzbx zzbx4;
        zzbx zzbx5;
        zzbx zzbx6;
        zzbx zzbx7;
        zzbx zzbx8;
        zzbx zzbx9;
        zzbx zzbx10;
        zzbx zzbx11;
        zzbx zzbx12;
        zzbx zzbx13;
        Object object = new zzbx("NO_ERROR", 0, 0);
        zza = object;
        int n10 = 1;
        zzd = zzbx13 = new zzbx("INCOMPATIBLE_INPUT", n10, n10);
        int n11 = 2;
        zze = zzbx12 = new zzbx("INCOMPATIBLE_OUTPUT", n11, n11);
        int n12 = 3;
        zzf = zzbx11 = new zzbx("INCOMPATIBLE_TFLITE_VERSION", n12, n12);
        int n13 = 4;
        zzg = zzbx10 = new zzbx("MISSING_OP", n13, n13);
        int n14 = 5;
        int n15 = 6;
        zzh = zzbx9 = new zzbx("DATA_TYPE_ERROR", n14, n15);
        int n16 = 7;
        zzi = zzbx8 = new zzbx("TFLITE_INTERNAL_ERROR", n15, n16);
        n13 = 8;
        zzj = zzbx7 = new zzbx("TFLITE_UNKNOWN_ERROR", n16, n13);
        n12 = 9;
        zzk = zzbx6 = new zzbx("MEDIAPIPE_ERROR", n13, n12);
        zzl = zzbx5 = new zzbx("TIME_OUT_FETCHING_MODEL_METADATA", n12, n14);
        zzb = zzbx4 = new zzbx("MODEL_NOT_DOWNLOADED", 10, 100);
        zzm = zzbx3 = new zzbx("URI_EXPIRED", 11, 101);
        zzbx[] zzbxArray = new zzbx("NO_NETWORK_CONNECTION", 12, 102);
        zzn = zzbxArray;
        zzbx[] zzbxArray2 = zzbxArray;
        zzo = zzbx2 = new zzbx("METERED_NETWORK", 13, 103);
        zzbx zzbx14 = zzbx2;
        zzbxArray = new zzbx("DOWNLOAD_FAILED", 14, 104);
        zzp = zzbxArray;
        zzbx[] zzbxArray3 = zzbxArray;
        zzq = zzbx2 = new zzbx("MODEL_INFO_DOWNLOAD_UNSUCCESSFUL_HTTP_STATUS", 15, 105);
        zzbx zzbx15 = zzbx2;
        zzbxArray = new zzbx("MODEL_INFO_DOWNLOAD_NO_HASH", 16, 106);
        zzr = zzbxArray;
        zzbx[] zzbxArray4 = zzbxArray;
        zzs = zzbx2 = new zzbx("MODEL_INFO_DOWNLOAD_CONNECTION_FAILED", 17, 107);
        zzbx zzbx16 = zzbx2;
        zzbxArray = new zzbx("NO_VALID_MODEL", 18, 108);
        zzt = zzbxArray;
        zzbx[] zzbxArray5 = zzbxArray;
        zzu = zzbx2 = new zzbx("LOCAL_MODEL_INVALID", 19, 109);
        zzbx zzbx17 = zzbx2;
        zzbxArray = new zzbx("REMOTE_MODEL_INVALID", 20, 110);
        zzv = zzbxArray;
        zzbx[] zzbxArray6 = zzbxArray;
        zzw = zzbx2 = new zzbx("REMOTE_MODEL_LOADER_ERROR", 21, 111);
        zzbx zzbx18 = zzbx2;
        zzbxArray = new zzbx("REMOTE_MODEL_LOADER_LOADS_NO_MODEL", 22, 112);
        zzx = zzbxArray;
        zzbx[] zzbxArray7 = zzbxArray;
        zzy = zzbx2 = new zzbx("SMART_REPLY_LANG_ID_DETECTAION_FAILURE", 23, 113);
        zzbx zzbx19 = zzbx2;
        zzbxArray = new zzbx("MODEL_NOT_REGISTERED", 24, 114);
        zzz = zzbxArray;
        zzbx[] zzbxArray8 = zzbxArray;
        zzaa = zzbx2 = new zzbx("MODEL_TYPE_MISUSE", 25, 115);
        zzbx zzbx20 = zzbx2;
        zzbxArray = new zzbx("MODEL_HASH_MISMATCH", 26, 116);
        zzab = zzbxArray;
        zzbx[] zzbxArray9 = zzbxArray;
        zzc = zzbx2 = new zzbx("UNKNOWN_ERROR", 27, 9999);
        zzbxArray = new zzbx[]{object, zzbx13, zzbx12, zzbx11, zzbx10, zzbx9, zzbx8, zzbx7, zzbx6, zzbx5, zzbx4, zzbx3, zzbxArray2, zzbx14, zzbxArray3, zzbx15, zzbxArray4, zzbx16, zzbxArray5, zzbx17, zzbxArray6, zzbx18, zzbxArray7, zzbx19, zzbxArray8, zzbx20, zzbxArray9, zzbx2};
        zzae = zzbxArray;
        zzac = object = new zzbz();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzbx() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzad = var3_1;
    }

    public static zzbx[] values() {
        return (zzbx[])zzae.clone();
    }

    public static zzgh zzb() {
        return zzby.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzbx.class.getName();
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

