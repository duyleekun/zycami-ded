/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzdo;
import com.google.android.gms.internal.mlkit_vision_face.zzdp;
import com.google.android.gms.internal.mlkit_vision_face.zzgf;
import com.google.android.gms.internal.mlkit_vision_face.zzgh;
import com.google.android.gms.internal.mlkit_vision_face.zzgi;

public final class zzbm$zzbe$zza
extends Enum
implements zzgf {
    private static final /* enum */ zzbm$zzbe$zza zza;
    private static final /* enum */ zzbm$zzbe$zza zzaa;
    private static final /* enum */ zzbm$zzbe$zza zzab;
    private static final /* enum */ zzbm$zzbe$zza zzac;
    private static final /* enum */ zzbm$zzbe$zza zzad;
    private static final /* enum */ zzbm$zzbe$zza zzae;
    private static final /* enum */ zzbm$zzbe$zza zzaf;
    private static final /* enum */ zzbm$zzbe$zza zzag;
    private static final /* enum */ zzbm$zzbe$zza zzah;
    private static final zzgi zzai;
    private static final /* synthetic */ zzbm$zzbe$zza[] zzak;
    private static final /* enum */ zzbm$zzbe$zza zzb;
    private static final /* enum */ zzbm$zzbe$zza zzc;
    private static final /* enum */ zzbm$zzbe$zza zzd;
    private static final /* enum */ zzbm$zzbe$zza zze;
    private static final /* enum */ zzbm$zzbe$zza zzf;
    private static final /* enum */ zzbm$zzbe$zza zzg;
    private static final /* enum */ zzbm$zzbe$zza zzh;
    private static final /* enum */ zzbm$zzbe$zza zzi;
    private static final /* enum */ zzbm$zzbe$zza zzj;
    private static final /* enum */ zzbm$zzbe$zza zzk;
    private static final /* enum */ zzbm$zzbe$zza zzl;
    private static final /* enum */ zzbm$zzbe$zza zzm;
    private static final /* enum */ zzbm$zzbe$zza zzn;
    private static final /* enum */ zzbm$zzbe$zza zzo;
    private static final /* enum */ zzbm$zzbe$zza zzp;
    private static final /* enum */ zzbm$zzbe$zza zzq;
    private static final /* enum */ zzbm$zzbe$zza zzr;
    private static final /* enum */ zzbm$zzbe$zza zzs;
    private static final /* enum */ zzbm$zzbe$zza zzt;
    private static final /* enum */ zzbm$zzbe$zza zzu;
    private static final /* enum */ zzbm$zzbe$zza zzv;
    private static final /* enum */ zzbm$zzbe$zza zzw;
    private static final /* enum */ zzbm$zzbe$zza zzx;
    private static final /* enum */ zzbm$zzbe$zza zzy;
    private static final /* enum */ zzbm$zzbe$zza zzz;
    private final int zzaj;

    static {
        zzbm$zzbe$zza zzbm$zzbe$zza;
        zzbm$zzbe$zza zzbm$zzbe$zza2;
        zzbm$zzbe$zza zzbm$zzbe$zza3;
        zzbm$zzbe$zza zzbm$zzbe$zza4;
        zzbm$zzbe$zza zzbm$zzbe$zza5;
        zzbm$zzbe$zza zzbm$zzbe$zza6;
        zzbm$zzbe$zza zzbm$zzbe$zza7;
        zzbm$zzbe$zza zzbm$zzbe$zza8;
        zzbm$zzbe$zza zzbm$zzbe$zza9;
        zzbm$zzbe$zza zzbm$zzbe$zza10;
        zzbm$zzbe$zza zzbm$zzbe$zza11;
        zzbm$zzbe$zza zzbm$zzbe$zza12;
        zzbm$zzbe$zza zzbm$zzbe$zza13;
        Object object = new zzbm$zzbe$zza("NO_ERROR", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzbm$zzbe$zza13 = new zzbm$zzbe$zza("METADATA_FILE_UNAVAILABLE", n10, n10);
        int n11 = 2;
        zzc = zzbm$zzbe$zza12 = new zzbm$zzbe$zza("METADATA_ENTRY_NOT_FOUND", n11, n11);
        int n12 = 3;
        zzd = zzbm$zzbe$zza11 = new zzbm$zzbe$zza("METADATA_JSON_INVALID", n12, n12);
        int n13 = 4;
        zze = zzbm$zzbe$zza10 = new zzbm$zzbe$zza("METADATA_HASH_NOT_FOUND", n13, n13);
        int n14 = 5;
        zzf = zzbm$zzbe$zza9 = new zzbm$zzbe$zza("DOWNLOAD_MANAGER_SERVICE_MISSING", n14, n14);
        int n15 = 6;
        zzg = zzbm$zzbe$zza8 = new zzbm$zzbe$zza("DOWNLOAD_MANAGER_HTTP_UNKNOWN_STATUS", n15, n15);
        zzh = zzbm$zzbe$zza7 = new zzbm$zzbe$zza("DOWNLOAD_MANAGER_HTTP_BAD_REQUEST", 7, 400);
        zzi = zzbm$zzbe$zza6 = new zzbm$zzbe$zza("DOWNLOAD_MANAGER_HTTP_UNAUTHORIZED", 8, 401);
        zzj = zzbm$zzbe$zza5 = new zzbm$zzbe$zza("DOWNLOAD_MANAGER_HTTP_FORBIDDEN", 9, 403);
        zzk = zzbm$zzbe$zza4 = new zzbm$zzbe$zza("DOWNLOAD_MANAGER_HTTP_NOT_FOUND", 10, 404);
        zzl = zzbm$zzbe$zza3 = new zzbm$zzbe$zza("DOWNLOAD_MANAGER_HTTP_REQUEST_TIMEOUT", 11, 408);
        zzbm$zzbe$zza[] zzbm$zzbe$zzaArray = new zzbm$zzbe$zza("DOWNLOAD_MANAGER_HTTP_ABORTED", 12, 409);
        zzm = zzbm$zzbe$zzaArray;
        zzbm$zzbe$zza[] zzbm$zzbe$zzaArray2 = zzbm$zzbe$zzaArray;
        zzn = zzbm$zzbe$zza2 = new zzbm$zzbe$zza("DOWNLOAD_MANAGER_HTTP_TOO_MANY_REQUESTS", 13, 429);
        zzbm$zzbe$zza zzbm$zzbe$zza14 = zzbm$zzbe$zza2;
        zzbm$zzbe$zzaArray = new zzbm$zzbe$zza("DOWNLOAD_MANAGER_HTTP_CANCELLED", 14, 499);
        zzo = zzbm$zzbe$zzaArray;
        zzbm$zzbe$zza[] zzbm$zzbe$zzaArray3 = zzbm$zzbe$zzaArray;
        zzp = zzbm$zzbe$zza2 = new zzbm$zzbe$zza("DOWNLOAD_MANAGER_HTTP_UNIMPLEMENTED", 15, 501);
        zzbm$zzbe$zza zzbm$zzbe$zza15 = zzbm$zzbe$zza2;
        zzbm$zzbe$zzaArray = new zzbm$zzbe$zza("DOWNLOAD_MANAGER_HTTP_INTERNAL_SERVICE_ERROR", 16, 500);
        zzq = zzbm$zzbe$zzaArray;
        zzbm$zzbe$zza[] zzbm$zzbe$zzaArray4 = zzbm$zzbe$zzaArray;
        zzr = zzbm$zzbe$zza2 = new zzbm$zzbe$zza("DOWNLOAD_MANAGER_HTTP_SERVICE_UNAVAILABLE", 17, 503);
        zzbm$zzbe$zza zzbm$zzbe$zza16 = zzbm$zzbe$zza2;
        zzbm$zzbe$zzaArray = new zzbm$zzbe$zza("DOWNLOAD_MANAGER_HTTP_DEADLINE_EXCEEDED", 18, 504);
        zzs = zzbm$zzbe$zzaArray;
        zzbm$zzbe$zza[] zzbm$zzbe$zzaArray5 = zzbm$zzbe$zzaArray;
        zzt = zzbm$zzbe$zza2 = new zzbm$zzbe$zza("DOWNLOAD_MANAGER_HTTP_NETWORK_AUTHENTICATION_REQUIRED", 19, 511);
        zzbm$zzbe$zza zzbm$zzbe$zza17 = zzbm$zzbe$zza2;
        zzbm$zzbe$zzaArray = new zzbm$zzbe$zza("DOWNLOAD_MANAGER_FILE_ERROR", 20, 7);
        zzu = zzbm$zzbe$zzaArray;
        zzbm$zzbe$zza[] zzbm$zzbe$zzaArray6 = zzbm$zzbe$zzaArray;
        zzv = zzbm$zzbe$zza2 = new zzbm$zzbe$zza("DOWNLOAD_MANAGER_UNHANDLED_HTTP_CODE", 21, 8);
        zzbm$zzbe$zzaArray = new zzbm$zzbe$zza("DOWNLOAD_MANAGER_HTTP_DATA_ERROR", 22, 9);
        zzw = zzbm$zzbe$zzaArray;
        zzbm$zzbe$zza[] zzbm$zzbe$zzaArray7 = zzbm$zzbe$zzaArray;
        zzx = zzbm$zzbe$zza = new zzbm$zzbe$zza("DOWNLOAD_MANAGER_TOO_MANY_REDIRECTS", 23, 10);
        zzbm$zzbe$zza zzbm$zzbe$zza18 = zzbm$zzbe$zza;
        zzbm$zzbe$zzaArray = new zzbm$zzbe$zza("DOWNLOAD_MANAGER_INSUFFICIENT_SPACE", 24, 11);
        zzy = zzbm$zzbe$zzaArray;
        zzbm$zzbe$zza[] zzbm$zzbe$zzaArray8 = zzbm$zzbe$zzaArray;
        zzz = zzbm$zzbe$zza = new zzbm$zzbe$zza("DOWNLOAD_MANAGER_DEVICE_NOT_FOUND", 25, 12);
        zzbm$zzbe$zza zzbm$zzbe$zza19 = zzbm$zzbe$zza;
        zzbm$zzbe$zzaArray = new zzbm$zzbe$zza("DOWNLOAD_MANAGER_CANNOT_RESUME", 26, 13);
        zzaa = zzbm$zzbe$zzaArray;
        zzbm$zzbe$zza[] zzbm$zzbe$zzaArray9 = zzbm$zzbe$zzaArray;
        zzab = zzbm$zzbe$zza = new zzbm$zzbe$zza("DOWNLOAD_MANAGER_FILE_ALREADY_EXISTS", 27, 14);
        zzbm$zzbe$zza zzbm$zzbe$zza20 = zzbm$zzbe$zza;
        zzbm$zzbe$zzaArray = new zzbm$zzbe$zza("DOWNLOAD_MANAGER_UNKNOWN_ERROR", 28, 15);
        zzac = zzbm$zzbe$zzaArray;
        zzbm$zzbe$zza[] zzbm$zzbe$zzaArray10 = zzbm$zzbe$zzaArray;
        zzad = zzbm$zzbe$zza = new zzbm$zzbe$zza("POST_DOWNLOAD_FILE_NOT_FOUND", 29, 16);
        zzbm$zzbe$zza zzbm$zzbe$zza21 = zzbm$zzbe$zza;
        zzbm$zzbe$zzaArray = new zzbm$zzbe$zza("POST_DOWNLOAD_MOVE_FILE_FAILED", 30, 17);
        zzae = zzbm$zzbe$zzaArray;
        zzbm$zzbe$zza[] zzbm$zzbe$zzaArray11 = zzbm$zzbe$zzaArray;
        zzaf = zzbm$zzbe$zza = new zzbm$zzbe$zza("POST_DOWNLOAD_UNZIP_FAILED", 31, 18);
        zzbm$zzbe$zza zzbm$zzbe$zza22 = zzbm$zzbe$zza;
        zzbm$zzbe$zzaArray = new zzbm$zzbe$zza("RAPID_RESPONSE_COULD_NOT_BE_WRITTEN", 32, 19);
        zzag = zzbm$zzbe$zzaArray;
        zzbm$zzbe$zza[] zzbm$zzbe$zzaArray12 = zzbm$zzbe$zzaArray;
        zzah = zzbm$zzbe$zza = new zzbm$zzbe$zza("DRIVER_OBJECT_DEALLOCATED", 33, 20);
        zzbm$zzbe$zzaArray = new zzbm$zzbe$zza[]{object, zzbm$zzbe$zza13, zzbm$zzbe$zza12, zzbm$zzbe$zza11, zzbm$zzbe$zza10, zzbm$zzbe$zza9, zzbm$zzbe$zza8, zzbm$zzbe$zza7, zzbm$zzbe$zza6, zzbm$zzbe$zza5, zzbm$zzbe$zza4, zzbm$zzbe$zza3, zzbm$zzbe$zzaArray2, zzbm$zzbe$zza14, zzbm$zzbe$zzaArray3, zzbm$zzbe$zza15, zzbm$zzbe$zzaArray4, zzbm$zzbe$zza16, zzbm$zzbe$zzaArray5, zzbm$zzbe$zza17, zzbm$zzbe$zzaArray6, zzbm$zzbe$zza2, zzbm$zzbe$zzaArray7, zzbm$zzbe$zza18, zzbm$zzbe$zzaArray8, zzbm$zzbe$zza19, zzbm$zzbe$zzaArray9, zzbm$zzbe$zza20, zzbm$zzbe$zzaArray10, zzbm$zzbe$zza21, zzbm$zzbe$zzaArray11, zzbm$zzbe$zza22, zzbm$zzbe$zzaArray12, zzbm$zzbe$zza};
        zzak = zzbm$zzbe$zzaArray;
        zzai = object = new zzdp();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzbm$zzbe$zza() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzaj = var3_1;
    }

    public static zzbm$zzbe$zza[] values() {
        return (zzbm$zzbe$zza[])zzak.clone();
    }

    public static zzgh zzb() {
        return zzdo.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzbm$zzbe$zza.class.getName();
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

