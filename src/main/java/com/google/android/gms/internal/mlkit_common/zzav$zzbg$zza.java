/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzdc;
import com.google.android.gms.internal.mlkit_common.zzdd;
import com.google.android.gms.internal.mlkit_common.zzfu;
import com.google.android.gms.internal.mlkit_common.zzfv;
import com.google.android.gms.internal.mlkit_common.zzfx;

public final class zzav$zzbg$zza
extends Enum
implements zzfv {
    private static final /* enum */ zzav$zzbg$zza zza;
    private static final /* enum */ zzav$zzbg$zza zzb;
    private static final /* enum */ zzav$zzbg$zza zzc;
    private static final /* enum */ zzav$zzbg$zza zzd;
    private static final /* enum */ zzav$zzbg$zza zze;
    private static final /* enum */ zzav$zzbg$zza zzf;
    private static final /* enum */ zzav$zzbg$zza zzg;
    private static final /* enum */ zzav$zzbg$zza zzh;
    private static final /* enum */ zzav$zzbg$zza zzi;
    private static final /* enum */ zzav$zzbg$zza zzj;
    private static final /* enum */ zzav$zzbg$zza zzk;
    private static final /* enum */ zzav$zzbg$zza zzl;
    private static final zzfu zzm;
    private static final /* synthetic */ zzav$zzbg$zza[] zzo;
    private final int zzn;

    static {
        zzav$zzbg$zza zzav$zzbg$zza;
        zzav$zzbg$zza zzav$zzbg$zza2;
        zzav$zzbg$zza zzav$zzbg$zza3;
        zzav$zzbg$zza zzav$zzbg$zza4;
        zzav$zzbg$zza zzav$zzbg$zza5;
        zzav$zzbg$zza zzav$zzbg$zza6;
        zzav$zzbg$zza zzav$zzbg$zza7;
        zzav$zzbg$zza zzav$zzbg$zza8;
        zzav$zzbg$zza zzav$zzbg$zza9;
        zzav$zzbg$zza zzav$zzbg$zza10;
        zzav$zzbg$zza zzav$zzbg$zza11;
        Object object = new zzav$zzbg$zza("UNKNOWN_ERROR", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzav$zzbg$zza11 = new zzav$zzbg$zza("NO_CONNECTION", n10, n10);
        int n11 = 2;
        zzc = zzav$zzbg$zza10 = new zzav$zzbg$zza("RPC_ERROR", n11, n11);
        int n12 = 3;
        zzd = zzav$zzbg$zza9 = new zzav$zzbg$zza("RPC_RETURNED_INVALID_RESULT", n12, n12);
        int n13 = 4;
        zze = zzav$zzbg$zza8 = new zzav$zzbg$zza("RPC_RETURNED_MALFORMED_RESULT", n13, n13);
        int n14 = 5;
        zzf = zzav$zzbg$zza7 = new zzav$zzbg$zza("RPC_EXPONENTIAL_BACKOFF_FAILED", n14, n14);
        int n15 = 10;
        zzg = zzav$zzbg$zza6 = new zzav$zzbg$zza("DIRECTORY_CREATION_FAILED", 6, n15);
        n13 = 11;
        zzh = zzav$zzbg$zza5 = new zzav$zzbg$zza("FILE_WRITE_FAILED_DISK_FULL", 7, n13);
        n11 = 12;
        zzi = zzav$zzbg$zza4 = new zzav$zzbg$zza("FILE_WRITE_FAILED", 8, n11);
        zzj = zzav$zzbg$zza3 = new zzav$zzbg$zza("FILE_READ_FAILED", 9, 13);
        zzk = zzav$zzbg$zza2 = new zzav$zzbg$zza("FILE_READ_RETURNED_INVALID_DATA", n15, 14);
        zzl = zzav$zzbg$zza = new zzav$zzbg$zza("FILE_READ_RETURNED_MALFORMED_DATA", n13, 15);
        zzav$zzbg$zza[] zzav$zzbg$zzaArray = new zzav$zzbg$zza[n11];
        zzav$zzbg$zzaArray[0] = object;
        zzav$zzbg$zzaArray[1] = zzav$zzbg$zza11;
        zzav$zzbg$zzaArray[2] = zzav$zzbg$zza10;
        zzav$zzbg$zzaArray[3] = zzav$zzbg$zza9;
        zzav$zzbg$zzaArray[4] = zzav$zzbg$zza8;
        zzav$zzbg$zzaArray[5] = zzav$zzbg$zza7;
        zzav$zzbg$zzaArray[6] = zzav$zzbg$zza6;
        zzav$zzbg$zzaArray[7] = zzav$zzbg$zza5;
        zzav$zzbg$zzaArray[8] = zzav$zzbg$zza4;
        zzav$zzbg$zzaArray[9] = zzav$zzbg$zza3;
        zzav$zzbg$zzaArray[10] = zzav$zzbg$zza2;
        zzav$zzbg$zzaArray[n13] = zzav$zzbg$zza;
        zzo = zzav$zzbg$zzaArray;
        zzm = object = new zzdd();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzav$zzbg$zza() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzn = var3_1;
    }

    public static zzav$zzbg$zza[] values() {
        return (zzav$zzbg$zza[])zzo.clone();
    }

    public static zzfx zzb() {
        return zzdc.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzav$zzbg$zza.class.getName();
        stringBuilder.append(string2);
        stringBuilder.append('@');
        string2 = Integer.toHexString(System.identityHashCode(this));
        stringBuilder.append(string2);
        stringBuilder.append(" number=");
        int n10 = this.zzn;
        stringBuilder.append(n10);
        stringBuilder.append(" name=");
        string2 = this.name();
        stringBuilder.append(string2);
        stringBuilder.append('>');
        return stringBuilder.toString();
    }

    public final int zza() {
        return this.zzn;
    }
}

