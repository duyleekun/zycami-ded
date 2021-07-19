/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzad;
import com.google.android.gms.internal.mlkit_vision_common.zzae;
import com.google.android.gms.internal.mlkit_vision_common.zzel;
import com.google.android.gms.internal.mlkit_vision_common.zzen;
import com.google.android.gms.internal.mlkit_vision_common.zzeo;

public final class zzac
extends Enum
implements zzel {
    private static final /* enum */ zzac zza;
    private static final /* enum */ zzac zzaa;
    private static final /* enum */ zzac zzab;
    private static final zzeo zzac;
    private static final /* synthetic */ zzac[] zzae;
    private static final /* enum */ zzac zzb;
    private static final /* enum */ zzac zzc;
    private static final /* enum */ zzac zzd;
    private static final /* enum */ zzac zze;
    private static final /* enum */ zzac zzf;
    private static final /* enum */ zzac zzg;
    private static final /* enum */ zzac zzh;
    private static final /* enum */ zzac zzi;
    private static final /* enum */ zzac zzj;
    private static final /* enum */ zzac zzk;
    private static final /* enum */ zzac zzl;
    private static final /* enum */ zzac zzm;
    private static final /* enum */ zzac zzn;
    private static final /* enum */ zzac zzo;
    private static final /* enum */ zzac zzp;
    private static final /* enum */ zzac zzq;
    private static final /* enum */ zzac zzr;
    private static final /* enum */ zzac zzs;
    private static final /* enum */ zzac zzt;
    private static final /* enum */ zzac zzu;
    private static final /* enum */ zzac zzv;
    private static final /* enum */ zzac zzw;
    private static final /* enum */ zzac zzx;
    private static final /* enum */ zzac zzy;
    private static final /* enum */ zzac zzz;
    private final int zzad;

    static {
        zzac zzac2;
        zzac zzac3;
        zzac zzac4;
        zzac zzac5;
        zzac zzac6;
        zzac zzac7;
        zzac zzac8;
        zzac zzac9;
        zzac zzac10;
        zzac zzac11;
        zzac zzac12;
        zzac zzac13;
        Object object = new zzac("NO_ERROR", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzac13 = new zzac("INCOMPATIBLE_INPUT", n10, n10);
        int n11 = 2;
        zzc = zzac12 = new zzac("INCOMPATIBLE_OUTPUT", n11, n11);
        int n12 = 3;
        zzd = zzac11 = new zzac("INCOMPATIBLE_TFLITE_VERSION", n12, n12);
        int n13 = 4;
        zze = zzac10 = new zzac("MISSING_OP", n13, n13);
        int n14 = 5;
        int n15 = 6;
        zzf = zzac9 = new zzac("DATA_TYPE_ERROR", n14, n15);
        int n16 = 7;
        zzg = zzac8 = new zzac("TFLITE_INTERNAL_ERROR", n15, n16);
        n13 = 8;
        zzh = zzac7 = new zzac("TFLITE_UNKNOWN_ERROR", n16, n13);
        n12 = 9;
        zzi = zzac6 = new zzac("MEDIAPIPE_ERROR", n13, n12);
        zzj = zzac5 = new zzac("TIME_OUT_FETCHING_MODEL_METADATA", n12, n14);
        zzk = zzac4 = new zzac("MODEL_NOT_DOWNLOADED", 10, 100);
        zzl = zzac3 = new zzac("URI_EXPIRED", 11, 101);
        zzac[] zzacArray = new zzac("NO_NETWORK_CONNECTION", 12, 102);
        zzm = zzacArray;
        zzac[] zzacArray2 = zzacArray;
        zzn = zzac2 = new zzac("METERED_NETWORK", 13, 103);
        zzac zzac14 = zzac2;
        zzacArray = new zzac("DOWNLOAD_FAILED", 14, 104);
        zzo = zzacArray;
        zzac[] zzacArray3 = zzacArray;
        zzp = zzac2 = new zzac("MODEL_INFO_DOWNLOAD_UNSUCCESSFUL_HTTP_STATUS", 15, 105);
        zzac zzac15 = zzac2;
        zzacArray = new zzac("MODEL_INFO_DOWNLOAD_NO_HASH", 16, 106);
        zzq = zzacArray;
        zzac[] zzacArray4 = zzacArray;
        zzr = zzac2 = new zzac("MODEL_INFO_DOWNLOAD_CONNECTION_FAILED", 17, 107);
        zzac zzac16 = zzac2;
        zzacArray = new zzac("NO_VALID_MODEL", 18, 108);
        zzs = zzacArray;
        zzac[] zzacArray5 = zzacArray;
        zzt = zzac2 = new zzac("LOCAL_MODEL_INVALID", 19, 109);
        zzac zzac17 = zzac2;
        zzacArray = new zzac("REMOTE_MODEL_INVALID", 20, 110);
        zzu = zzacArray;
        zzac[] zzacArray6 = zzacArray;
        zzv = zzac2 = new zzac("REMOTE_MODEL_LOADER_ERROR", 21, 111);
        zzac zzac18 = zzac2;
        zzacArray = new zzac("REMOTE_MODEL_LOADER_LOADS_NO_MODEL", 22, 112);
        zzw = zzacArray;
        zzac[] zzacArray7 = zzacArray;
        zzx = zzac2 = new zzac("SMART_REPLY_LANG_ID_DETECTAION_FAILURE", 23, 113);
        zzac zzac19 = zzac2;
        zzacArray = new zzac("MODEL_NOT_REGISTERED", 24, 114);
        zzy = zzacArray;
        zzac[] zzacArray8 = zzacArray;
        zzz = zzac2 = new zzac("MODEL_TYPE_MISUSE", 25, 115);
        zzac zzac20 = zzac2;
        zzacArray = new zzac("MODEL_HASH_MISMATCH", 26, 116);
        zzaa = zzacArray;
        zzac[] zzacArray9 = zzacArray;
        zzab = zzac2 = new zzac("UNKNOWN_ERROR", 27, 9999);
        zzacArray = new zzac[]{object, zzac13, zzac12, zzac11, zzac10, zzac9, zzac8, zzac7, zzac6, zzac5, zzac4, zzac3, zzacArray2, zzac14, zzacArray3, zzac15, zzacArray4, zzac16, zzacArray5, zzac17, zzacArray6, zzac18, zzacArray7, zzac19, zzacArray8, zzac20, zzacArray9, zzac2};
        zzae = zzacArray;
        zzac = object = new zzae();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzac() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzad = var3_1;
    }

    public static zzac[] values() {
        return (zzac[])zzae.clone();
    }

    public static zzen zzb() {
        return com.google.android.gms.internal.mlkit_vision_common.zzad.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzac.class.getName();
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

