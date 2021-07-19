/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzbt;
import com.google.android.gms.internal.mlkit_vision_common.zzbu;
import com.google.android.gms.internal.mlkit_vision_common.zzel;
import com.google.android.gms.internal.mlkit_vision_common.zzen;
import com.google.android.gms.internal.mlkit_vision_common.zzeo;

public final class zzr$zzbe$zza
extends Enum
implements zzel {
    private static final /* enum */ zzr$zzbe$zza zza;
    private static final /* enum */ zzr$zzbe$zza zzaa;
    private static final /* enum */ zzr$zzbe$zza zzab;
    private static final /* enum */ zzr$zzbe$zza zzac;
    private static final /* enum */ zzr$zzbe$zza zzad;
    private static final /* enum */ zzr$zzbe$zza zzae;
    private static final /* enum */ zzr$zzbe$zza zzaf;
    private static final /* enum */ zzr$zzbe$zza zzag;
    private static final /* enum */ zzr$zzbe$zza zzah;
    private static final zzeo zzai;
    private static final /* synthetic */ zzr$zzbe$zza[] zzak;
    private static final /* enum */ zzr$zzbe$zza zzb;
    private static final /* enum */ zzr$zzbe$zza zzc;
    private static final /* enum */ zzr$zzbe$zza zzd;
    private static final /* enum */ zzr$zzbe$zza zze;
    private static final /* enum */ zzr$zzbe$zza zzf;
    private static final /* enum */ zzr$zzbe$zza zzg;
    private static final /* enum */ zzr$zzbe$zza zzh;
    private static final /* enum */ zzr$zzbe$zza zzi;
    private static final /* enum */ zzr$zzbe$zza zzj;
    private static final /* enum */ zzr$zzbe$zza zzk;
    private static final /* enum */ zzr$zzbe$zza zzl;
    private static final /* enum */ zzr$zzbe$zza zzm;
    private static final /* enum */ zzr$zzbe$zza zzn;
    private static final /* enum */ zzr$zzbe$zza zzo;
    private static final /* enum */ zzr$zzbe$zza zzp;
    private static final /* enum */ zzr$zzbe$zza zzq;
    private static final /* enum */ zzr$zzbe$zza zzr;
    private static final /* enum */ zzr$zzbe$zza zzs;
    private static final /* enum */ zzr$zzbe$zza zzt;
    private static final /* enum */ zzr$zzbe$zza zzu;
    private static final /* enum */ zzr$zzbe$zza zzv;
    private static final /* enum */ zzr$zzbe$zza zzw;
    private static final /* enum */ zzr$zzbe$zza zzx;
    private static final /* enum */ zzr$zzbe$zza zzy;
    private static final /* enum */ zzr$zzbe$zza zzz;
    private final int zzaj;

    static {
        zzr$zzbe$zza zzr$zzbe$zza;
        zzr$zzbe$zza zzr$zzbe$zza2;
        zzr$zzbe$zza zzr$zzbe$zza3;
        zzr$zzbe$zza zzr$zzbe$zza4;
        zzr$zzbe$zza zzr$zzbe$zza5;
        zzr$zzbe$zza zzr$zzbe$zza6;
        zzr$zzbe$zza zzr$zzbe$zza7;
        zzr$zzbe$zza zzr$zzbe$zza8;
        zzr$zzbe$zza zzr$zzbe$zza9;
        zzr$zzbe$zza zzr$zzbe$zza10;
        zzr$zzbe$zza zzr$zzbe$zza11;
        zzr$zzbe$zza zzr$zzbe$zza12;
        zzr$zzbe$zza zzr$zzbe$zza13;
        Object object = new zzr$zzbe$zza("NO_ERROR", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzr$zzbe$zza13 = new zzr$zzbe$zza("METADATA_FILE_UNAVAILABLE", n10, n10);
        int n11 = 2;
        zzc = zzr$zzbe$zza12 = new zzr$zzbe$zza("METADATA_ENTRY_NOT_FOUND", n11, n11);
        int n12 = 3;
        zzd = zzr$zzbe$zza11 = new zzr$zzbe$zza("METADATA_JSON_INVALID", n12, n12);
        int n13 = 4;
        zze = zzr$zzbe$zza10 = new zzr$zzbe$zza("METADATA_HASH_NOT_FOUND", n13, n13);
        int n14 = 5;
        zzf = zzr$zzbe$zza9 = new zzr$zzbe$zza("DOWNLOAD_MANAGER_SERVICE_MISSING", n14, n14);
        int n15 = 6;
        zzg = zzr$zzbe$zza8 = new zzr$zzbe$zza("DOWNLOAD_MANAGER_HTTP_UNKNOWN_STATUS", n15, n15);
        zzh = zzr$zzbe$zza7 = new zzr$zzbe$zza("DOWNLOAD_MANAGER_HTTP_BAD_REQUEST", 7, 400);
        zzi = zzr$zzbe$zza6 = new zzr$zzbe$zza("DOWNLOAD_MANAGER_HTTP_UNAUTHORIZED", 8, 401);
        zzj = zzr$zzbe$zza5 = new zzr$zzbe$zza("DOWNLOAD_MANAGER_HTTP_FORBIDDEN", 9, 403);
        zzk = zzr$zzbe$zza4 = new zzr$zzbe$zza("DOWNLOAD_MANAGER_HTTP_NOT_FOUND", 10, 404);
        zzl = zzr$zzbe$zza3 = new zzr$zzbe$zza("DOWNLOAD_MANAGER_HTTP_REQUEST_TIMEOUT", 11, 408);
        zzr$zzbe$zza[] zzr$zzbe$zzaArray = new zzr$zzbe$zza("DOWNLOAD_MANAGER_HTTP_ABORTED", 12, 409);
        zzm = zzr$zzbe$zzaArray;
        zzr$zzbe$zza[] zzr$zzbe$zzaArray2 = zzr$zzbe$zzaArray;
        zzn = zzr$zzbe$zza2 = new zzr$zzbe$zza("DOWNLOAD_MANAGER_HTTP_TOO_MANY_REQUESTS", 13, 429);
        zzr$zzbe$zza zzr$zzbe$zza14 = zzr$zzbe$zza2;
        zzr$zzbe$zzaArray = new zzr$zzbe$zza("DOWNLOAD_MANAGER_HTTP_CANCELLED", 14, 499);
        zzo = zzr$zzbe$zzaArray;
        zzr$zzbe$zza[] zzr$zzbe$zzaArray3 = zzr$zzbe$zzaArray;
        zzp = zzr$zzbe$zza2 = new zzr$zzbe$zza("DOWNLOAD_MANAGER_HTTP_UNIMPLEMENTED", 15, 501);
        zzr$zzbe$zza zzr$zzbe$zza15 = zzr$zzbe$zza2;
        zzr$zzbe$zzaArray = new zzr$zzbe$zza("DOWNLOAD_MANAGER_HTTP_INTERNAL_SERVICE_ERROR", 16, 500);
        zzq = zzr$zzbe$zzaArray;
        zzr$zzbe$zza[] zzr$zzbe$zzaArray4 = zzr$zzbe$zzaArray;
        zzr = zzr$zzbe$zza2 = new zzr$zzbe$zza("DOWNLOAD_MANAGER_HTTP_SERVICE_UNAVAILABLE", 17, 503);
        zzr$zzbe$zza zzr$zzbe$zza16 = zzr$zzbe$zza2;
        zzr$zzbe$zzaArray = new zzr$zzbe$zza("DOWNLOAD_MANAGER_HTTP_DEADLINE_EXCEEDED", 18, 504);
        zzs = zzr$zzbe$zzaArray;
        zzr$zzbe$zza[] zzr$zzbe$zzaArray5 = zzr$zzbe$zzaArray;
        zzt = zzr$zzbe$zza2 = new zzr$zzbe$zza("DOWNLOAD_MANAGER_HTTP_NETWORK_AUTHENTICATION_REQUIRED", 19, 511);
        zzr$zzbe$zza zzr$zzbe$zza17 = zzr$zzbe$zza2;
        zzr$zzbe$zzaArray = new zzr$zzbe$zza("DOWNLOAD_MANAGER_FILE_ERROR", 20, 7);
        zzu = zzr$zzbe$zzaArray;
        zzr$zzbe$zza[] zzr$zzbe$zzaArray6 = zzr$zzbe$zzaArray;
        zzv = zzr$zzbe$zza2 = new zzr$zzbe$zza("DOWNLOAD_MANAGER_UNHANDLED_HTTP_CODE", 21, 8);
        zzr$zzbe$zzaArray = new zzr$zzbe$zza("DOWNLOAD_MANAGER_HTTP_DATA_ERROR", 22, 9);
        zzw = zzr$zzbe$zzaArray;
        zzr$zzbe$zza[] zzr$zzbe$zzaArray7 = zzr$zzbe$zzaArray;
        zzx = zzr$zzbe$zza = new zzr$zzbe$zza("DOWNLOAD_MANAGER_TOO_MANY_REDIRECTS", 23, 10);
        zzr$zzbe$zza zzr$zzbe$zza18 = zzr$zzbe$zza;
        zzr$zzbe$zzaArray = new zzr$zzbe$zza("DOWNLOAD_MANAGER_INSUFFICIENT_SPACE", 24, 11);
        zzy = zzr$zzbe$zzaArray;
        zzr$zzbe$zza[] zzr$zzbe$zzaArray8 = zzr$zzbe$zzaArray;
        zzz = zzr$zzbe$zza = new zzr$zzbe$zza("DOWNLOAD_MANAGER_DEVICE_NOT_FOUND", 25, 12);
        zzr$zzbe$zza zzr$zzbe$zza19 = zzr$zzbe$zza;
        zzr$zzbe$zzaArray = new zzr$zzbe$zza("DOWNLOAD_MANAGER_CANNOT_RESUME", 26, 13);
        zzaa = zzr$zzbe$zzaArray;
        zzr$zzbe$zza[] zzr$zzbe$zzaArray9 = zzr$zzbe$zzaArray;
        zzab = zzr$zzbe$zza = new zzr$zzbe$zza("DOWNLOAD_MANAGER_FILE_ALREADY_EXISTS", 27, 14);
        zzr$zzbe$zza zzr$zzbe$zza20 = zzr$zzbe$zza;
        zzr$zzbe$zzaArray = new zzr$zzbe$zza("DOWNLOAD_MANAGER_UNKNOWN_ERROR", 28, 15);
        zzac = zzr$zzbe$zzaArray;
        zzr$zzbe$zza[] zzr$zzbe$zzaArray10 = zzr$zzbe$zzaArray;
        zzad = zzr$zzbe$zza = new zzr$zzbe$zza("POST_DOWNLOAD_FILE_NOT_FOUND", 29, 16);
        zzr$zzbe$zza zzr$zzbe$zza21 = zzr$zzbe$zza;
        zzr$zzbe$zzaArray = new zzr$zzbe$zza("POST_DOWNLOAD_MOVE_FILE_FAILED", 30, 17);
        zzae = zzr$zzbe$zzaArray;
        zzr$zzbe$zza[] zzr$zzbe$zzaArray11 = zzr$zzbe$zzaArray;
        zzaf = zzr$zzbe$zza = new zzr$zzbe$zza("POST_DOWNLOAD_UNZIP_FAILED", 31, 18);
        zzr$zzbe$zza zzr$zzbe$zza22 = zzr$zzbe$zza;
        zzr$zzbe$zzaArray = new zzr$zzbe$zza("RAPID_RESPONSE_COULD_NOT_BE_WRITTEN", 32, 19);
        zzag = zzr$zzbe$zzaArray;
        zzr$zzbe$zza[] zzr$zzbe$zzaArray12 = zzr$zzbe$zzaArray;
        zzah = zzr$zzbe$zza = new zzr$zzbe$zza("DRIVER_OBJECT_DEALLOCATED", 33, 20);
        zzr$zzbe$zzaArray = new zzr$zzbe$zza[]{object, zzr$zzbe$zza13, zzr$zzbe$zza12, zzr$zzbe$zza11, zzr$zzbe$zza10, zzr$zzbe$zza9, zzr$zzbe$zza8, zzr$zzbe$zza7, zzr$zzbe$zza6, zzr$zzbe$zza5, zzr$zzbe$zza4, zzr$zzbe$zza3, zzr$zzbe$zzaArray2, zzr$zzbe$zza14, zzr$zzbe$zzaArray3, zzr$zzbe$zza15, zzr$zzbe$zzaArray4, zzr$zzbe$zza16, zzr$zzbe$zzaArray5, zzr$zzbe$zza17, zzr$zzbe$zzaArray6, zzr$zzbe$zza2, zzr$zzbe$zzaArray7, zzr$zzbe$zza18, zzr$zzbe$zzaArray8, zzr$zzbe$zza19, zzr$zzbe$zzaArray9, zzr$zzbe$zza20, zzr$zzbe$zzaArray10, zzr$zzbe$zza21, zzr$zzbe$zzaArray11, zzr$zzbe$zza22, zzr$zzbe$zzaArray12, zzr$zzbe$zza};
        zzak = zzr$zzbe$zzaArray;
        zzai = object = new zzbu();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzr$zzbe$zza() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzaj = var3_1;
    }

    public static zzr$zzbe$zza[] values() {
        return (zzr$zzbe$zza[])zzak.clone();
    }

    public static zzen zzb() {
        return zzbt.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzr$zzbe$zza.class.getName();
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

