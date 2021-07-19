/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzcv;
import com.google.android.gms.internal.mlkit_common.zzcw;
import com.google.android.gms.internal.mlkit_common.zzfu;
import com.google.android.gms.internal.mlkit_common.zzfv;
import com.google.android.gms.internal.mlkit_common.zzfx;

public final class zzav$zzbe$zzb
extends Enum
implements zzfv {
    private static final /* enum */ zzav$zzbe$zzb zza;
    private static final /* enum */ zzav$zzbe$zzb zzaa;
    private static final /* enum */ zzav$zzbe$zzb zzab;
    private static final /* enum */ zzav$zzbe$zzb zzac;
    private static final /* enum */ zzav$zzbe$zzb zzad;
    private static final /* enum */ zzav$zzbe$zzb zzae;
    private static final /* enum */ zzav$zzbe$zzb zzaf;
    private static final /* enum */ zzav$zzbe$zzb zzag;
    private static final /* enum */ zzav$zzbe$zzb zzah;
    private static final zzfu zzai;
    private static final /* synthetic */ zzav$zzbe$zzb[] zzak;
    private static final /* enum */ zzav$zzbe$zzb zzb;
    private static final /* enum */ zzav$zzbe$zzb zzc;
    private static final /* enum */ zzav$zzbe$zzb zzd;
    private static final /* enum */ zzav$zzbe$zzb zze;
    private static final /* enum */ zzav$zzbe$zzb zzf;
    private static final /* enum */ zzav$zzbe$zzb zzg;
    private static final /* enum */ zzav$zzbe$zzb zzh;
    private static final /* enum */ zzav$zzbe$zzb zzi;
    private static final /* enum */ zzav$zzbe$zzb zzj;
    private static final /* enum */ zzav$zzbe$zzb zzk;
    private static final /* enum */ zzav$zzbe$zzb zzl;
    private static final /* enum */ zzav$zzbe$zzb zzm;
    private static final /* enum */ zzav$zzbe$zzb zzn;
    private static final /* enum */ zzav$zzbe$zzb zzo;
    private static final /* enum */ zzav$zzbe$zzb zzp;
    private static final /* enum */ zzav$zzbe$zzb zzq;
    private static final /* enum */ zzav$zzbe$zzb zzr;
    private static final /* enum */ zzav$zzbe$zzb zzs;
    private static final /* enum */ zzav$zzbe$zzb zzt;
    private static final /* enum */ zzav$zzbe$zzb zzu;
    private static final /* enum */ zzav$zzbe$zzb zzv;
    private static final /* enum */ zzav$zzbe$zzb zzw;
    private static final /* enum */ zzav$zzbe$zzb zzx;
    private static final /* enum */ zzav$zzbe$zzb zzy;
    private static final /* enum */ zzav$zzbe$zzb zzz;
    private final int zzaj;

    static {
        zzav$zzbe$zzb zzav$zzbe$zzb;
        zzav$zzbe$zzb zzav$zzbe$zzb2;
        zzav$zzbe$zzb zzav$zzbe$zzb3;
        zzav$zzbe$zzb zzav$zzbe$zzb4;
        zzav$zzbe$zzb zzav$zzbe$zzb5;
        zzav$zzbe$zzb zzav$zzbe$zzb6;
        zzav$zzbe$zzb zzav$zzbe$zzb7;
        zzav$zzbe$zzb zzav$zzbe$zzb8;
        zzav$zzbe$zzb zzav$zzbe$zzb9;
        zzav$zzbe$zzb zzav$zzbe$zzb10;
        zzav$zzbe$zzb zzav$zzbe$zzb11;
        zzav$zzbe$zzb zzav$zzbe$zzb12;
        zzav$zzbe$zzb zzav$zzbe$zzb13;
        Object object = new zzav$zzbe$zzb("NO_ERROR", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzav$zzbe$zzb13 = new zzav$zzbe$zzb("METADATA_FILE_UNAVAILABLE", n10, n10);
        int n11 = 2;
        zzc = zzav$zzbe$zzb12 = new zzav$zzbe$zzb("METADATA_ENTRY_NOT_FOUND", n11, n11);
        int n12 = 3;
        zzd = zzav$zzbe$zzb11 = new zzav$zzbe$zzb("METADATA_JSON_INVALID", n12, n12);
        int n13 = 4;
        zze = zzav$zzbe$zzb10 = new zzav$zzbe$zzb("METADATA_HASH_NOT_FOUND", n13, n13);
        int n14 = 5;
        zzf = zzav$zzbe$zzb9 = new zzav$zzbe$zzb("DOWNLOAD_MANAGER_SERVICE_MISSING", n14, n14);
        int n15 = 6;
        zzg = zzav$zzbe$zzb8 = new zzav$zzbe$zzb("DOWNLOAD_MANAGER_HTTP_UNKNOWN_STATUS", n15, n15);
        zzh = zzav$zzbe$zzb7 = new zzav$zzbe$zzb("DOWNLOAD_MANAGER_HTTP_BAD_REQUEST", 7, 400);
        zzi = zzav$zzbe$zzb6 = new zzav$zzbe$zzb("DOWNLOAD_MANAGER_HTTP_UNAUTHORIZED", 8, 401);
        zzj = zzav$zzbe$zzb5 = new zzav$zzbe$zzb("DOWNLOAD_MANAGER_HTTP_FORBIDDEN", 9, 403);
        zzk = zzav$zzbe$zzb4 = new zzav$zzbe$zzb("DOWNLOAD_MANAGER_HTTP_NOT_FOUND", 10, 404);
        zzl = zzav$zzbe$zzb3 = new zzav$zzbe$zzb("DOWNLOAD_MANAGER_HTTP_REQUEST_TIMEOUT", 11, 408);
        zzav$zzbe$zzb[] zzav$zzbe$zzbArray = new zzav$zzbe$zzb("DOWNLOAD_MANAGER_HTTP_ABORTED", 12, 409);
        zzm = zzav$zzbe$zzbArray;
        zzav$zzbe$zzb[] zzav$zzbe$zzbArray2 = zzav$zzbe$zzbArray;
        zzn = zzav$zzbe$zzb2 = new zzav$zzbe$zzb("DOWNLOAD_MANAGER_HTTP_TOO_MANY_REQUESTS", 13, 429);
        zzav$zzbe$zzb zzav$zzbe$zzb14 = zzav$zzbe$zzb2;
        zzav$zzbe$zzbArray = new zzav$zzbe$zzb("DOWNLOAD_MANAGER_HTTP_CANCELLED", 14, 499);
        zzo = zzav$zzbe$zzbArray;
        zzav$zzbe$zzb[] zzav$zzbe$zzbArray3 = zzav$zzbe$zzbArray;
        zzp = zzav$zzbe$zzb2 = new zzav$zzbe$zzb("DOWNLOAD_MANAGER_HTTP_UNIMPLEMENTED", 15, 501);
        zzav$zzbe$zzb zzav$zzbe$zzb15 = zzav$zzbe$zzb2;
        zzav$zzbe$zzbArray = new zzav$zzbe$zzb("DOWNLOAD_MANAGER_HTTP_INTERNAL_SERVICE_ERROR", 16, 500);
        zzq = zzav$zzbe$zzbArray;
        zzav$zzbe$zzb[] zzav$zzbe$zzbArray4 = zzav$zzbe$zzbArray;
        zzr = zzav$zzbe$zzb2 = new zzav$zzbe$zzb("DOWNLOAD_MANAGER_HTTP_SERVICE_UNAVAILABLE", 17, 503);
        zzav$zzbe$zzb zzav$zzbe$zzb16 = zzav$zzbe$zzb2;
        zzav$zzbe$zzbArray = new zzav$zzbe$zzb("DOWNLOAD_MANAGER_HTTP_DEADLINE_EXCEEDED", 18, 504);
        zzs = zzav$zzbe$zzbArray;
        zzav$zzbe$zzb[] zzav$zzbe$zzbArray5 = zzav$zzbe$zzbArray;
        zzt = zzav$zzbe$zzb2 = new zzav$zzbe$zzb("DOWNLOAD_MANAGER_HTTP_NETWORK_AUTHENTICATION_REQUIRED", 19, 511);
        zzav$zzbe$zzb zzav$zzbe$zzb17 = zzav$zzbe$zzb2;
        zzav$zzbe$zzbArray = new zzav$zzbe$zzb("DOWNLOAD_MANAGER_FILE_ERROR", 20, 7);
        zzu = zzav$zzbe$zzbArray;
        zzav$zzbe$zzb[] zzav$zzbe$zzbArray6 = zzav$zzbe$zzbArray;
        zzv = zzav$zzbe$zzb2 = new zzav$zzbe$zzb("DOWNLOAD_MANAGER_UNHANDLED_HTTP_CODE", 21, 8);
        zzav$zzbe$zzbArray = new zzav$zzbe$zzb("DOWNLOAD_MANAGER_HTTP_DATA_ERROR", 22, 9);
        zzw = zzav$zzbe$zzbArray;
        zzav$zzbe$zzb[] zzav$zzbe$zzbArray7 = zzav$zzbe$zzbArray;
        zzx = zzav$zzbe$zzb = new zzav$zzbe$zzb("DOWNLOAD_MANAGER_TOO_MANY_REDIRECTS", 23, 10);
        zzav$zzbe$zzb zzav$zzbe$zzb18 = zzav$zzbe$zzb;
        zzav$zzbe$zzbArray = new zzav$zzbe$zzb("DOWNLOAD_MANAGER_INSUFFICIENT_SPACE", 24, 11);
        zzy = zzav$zzbe$zzbArray;
        zzav$zzbe$zzb[] zzav$zzbe$zzbArray8 = zzav$zzbe$zzbArray;
        zzz = zzav$zzbe$zzb = new zzav$zzbe$zzb("DOWNLOAD_MANAGER_DEVICE_NOT_FOUND", 25, 12);
        zzav$zzbe$zzb zzav$zzbe$zzb19 = zzav$zzbe$zzb;
        zzav$zzbe$zzbArray = new zzav$zzbe$zzb("DOWNLOAD_MANAGER_CANNOT_RESUME", 26, 13);
        zzaa = zzav$zzbe$zzbArray;
        zzav$zzbe$zzb[] zzav$zzbe$zzbArray9 = zzav$zzbe$zzbArray;
        zzab = zzav$zzbe$zzb = new zzav$zzbe$zzb("DOWNLOAD_MANAGER_FILE_ALREADY_EXISTS", 27, 14);
        zzav$zzbe$zzb zzav$zzbe$zzb20 = zzav$zzbe$zzb;
        zzav$zzbe$zzbArray = new zzav$zzbe$zzb("DOWNLOAD_MANAGER_UNKNOWN_ERROR", 28, 15);
        zzac = zzav$zzbe$zzbArray;
        zzav$zzbe$zzb[] zzav$zzbe$zzbArray10 = zzav$zzbe$zzbArray;
        zzad = zzav$zzbe$zzb = new zzav$zzbe$zzb("POST_DOWNLOAD_FILE_NOT_FOUND", 29, 16);
        zzav$zzbe$zzb zzav$zzbe$zzb21 = zzav$zzbe$zzb;
        zzav$zzbe$zzbArray = new zzav$zzbe$zzb("POST_DOWNLOAD_MOVE_FILE_FAILED", 30, 17);
        zzae = zzav$zzbe$zzbArray;
        zzav$zzbe$zzb[] zzav$zzbe$zzbArray11 = zzav$zzbe$zzbArray;
        zzaf = zzav$zzbe$zzb = new zzav$zzbe$zzb("POST_DOWNLOAD_UNZIP_FAILED", 31, 18);
        zzav$zzbe$zzb zzav$zzbe$zzb22 = zzav$zzbe$zzb;
        zzav$zzbe$zzbArray = new zzav$zzbe$zzb("RAPID_RESPONSE_COULD_NOT_BE_WRITTEN", 32, 19);
        zzag = zzav$zzbe$zzbArray;
        zzav$zzbe$zzb[] zzav$zzbe$zzbArray12 = zzav$zzbe$zzbArray;
        zzah = zzav$zzbe$zzb = new zzav$zzbe$zzb("DRIVER_OBJECT_DEALLOCATED", 33, 20);
        zzav$zzbe$zzbArray = new zzav$zzbe$zzb[]{object, zzav$zzbe$zzb13, zzav$zzbe$zzb12, zzav$zzbe$zzb11, zzav$zzbe$zzb10, zzav$zzbe$zzb9, zzav$zzbe$zzb8, zzav$zzbe$zzb7, zzav$zzbe$zzb6, zzav$zzbe$zzb5, zzav$zzbe$zzb4, zzav$zzbe$zzb3, zzav$zzbe$zzbArray2, zzav$zzbe$zzb14, zzav$zzbe$zzbArray3, zzav$zzbe$zzb15, zzav$zzbe$zzbArray4, zzav$zzbe$zzb16, zzav$zzbe$zzbArray5, zzav$zzbe$zzb17, zzav$zzbe$zzbArray6, zzav$zzbe$zzb2, zzav$zzbe$zzbArray7, zzav$zzbe$zzb18, zzav$zzbe$zzbArray8, zzav$zzbe$zzb19, zzav$zzbe$zzbArray9, zzav$zzbe$zzb20, zzav$zzbe$zzbArray10, zzav$zzbe$zzb21, zzav$zzbe$zzbArray11, zzav$zzbe$zzb22, zzav$zzbe$zzbArray12, zzav$zzbe$zzb};
        zzak = zzav$zzbe$zzbArray;
        zzai = object = new zzcv();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzav$zzbe$zzb() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzaj = var3_1;
    }

    public static zzav$zzbe$zzb[] values() {
        return (zzav$zzbe$zzb[])zzak.clone();
    }

    public static zzfx zzb() {
        return zzcw.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzav$zzbe$zzb.class.getName();
        stringBuilder.append(string2);
        stringBuilder.append('@');
        string2 = Integer.toHexString(System.identityHashCode(this));
        stringBuilder.append(string2);
        stringBuilder.append(" number=");
        int n10 = this.zzaj;
        stringBuilder.append(n10);
        stringBuilder.append(" name=");
        string2 = this.name();
        stringBuilder.append(string2);
        stringBuilder.append('>');
        return stringBuilder.toString();
    }

    public final int zza() {
        return this.zzaj;
    }
}

