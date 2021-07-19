/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzca;
import com.google.android.gms.internal.mlkit_vision_common.zzcb;
import com.google.android.gms.internal.mlkit_vision_common.zzel;
import com.google.android.gms.internal.mlkit_vision_common.zzen;
import com.google.android.gms.internal.mlkit_vision_common.zzeo;

public final class zzr$zzbg$zzb
extends Enum
implements zzel {
    private static final /* enum */ zzr$zzbg$zzb zza;
    private static final /* enum */ zzr$zzbg$zzb zzb;
    private static final /* enum */ zzr$zzbg$zzb zzc;
    private static final /* enum */ zzr$zzbg$zzb zzd;
    private static final /* enum */ zzr$zzbg$zzb zze;
    private static final /* enum */ zzr$zzbg$zzb zzf;
    private static final /* enum */ zzr$zzbg$zzb zzg;
    private static final /* enum */ zzr$zzbg$zzb zzh;
    private static final /* enum */ zzr$zzbg$zzb zzi;
    private static final /* enum */ zzr$zzbg$zzb zzj;
    private static final /* enum */ zzr$zzbg$zzb zzk;
    private static final /* enum */ zzr$zzbg$zzb zzl;
    private static final zzeo zzm;
    private static final /* synthetic */ zzr$zzbg$zzb[] zzo;
    private final int zzn;

    static {
        zzr$zzbg$zzb zzr$zzbg$zzb;
        zzr$zzbg$zzb zzr$zzbg$zzb2;
        zzr$zzbg$zzb zzr$zzbg$zzb3;
        zzr$zzbg$zzb zzr$zzbg$zzb4;
        zzr$zzbg$zzb zzr$zzbg$zzb5;
        zzr$zzbg$zzb zzr$zzbg$zzb6;
        zzr$zzbg$zzb zzr$zzbg$zzb7;
        zzr$zzbg$zzb zzr$zzbg$zzb8;
        zzr$zzbg$zzb zzr$zzbg$zzb9;
        zzr$zzbg$zzb zzr$zzbg$zzb10;
        zzr$zzbg$zzb zzr$zzbg$zzb11;
        Object object = new zzr$zzbg$zzb("UNKNOWN_ERROR", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzr$zzbg$zzb11 = new zzr$zzbg$zzb("NO_CONNECTION", n10, n10);
        int n11 = 2;
        zzc = zzr$zzbg$zzb10 = new zzr$zzbg$zzb("RPC_ERROR", n11, n11);
        int n12 = 3;
        zzd = zzr$zzbg$zzb9 = new zzr$zzbg$zzb("RPC_RETURNED_INVALID_RESULT", n12, n12);
        int n13 = 4;
        zze = zzr$zzbg$zzb8 = new zzr$zzbg$zzb("RPC_RETURNED_MALFORMED_RESULT", n13, n13);
        int n14 = 5;
        zzf = zzr$zzbg$zzb7 = new zzr$zzbg$zzb("RPC_EXPONENTIAL_BACKOFF_FAILED", n14, n14);
        int n15 = 10;
        zzg = zzr$zzbg$zzb6 = new zzr$zzbg$zzb("DIRECTORY_CREATION_FAILED", 6, n15);
        n13 = 11;
        zzh = zzr$zzbg$zzb5 = new zzr$zzbg$zzb("FILE_WRITE_FAILED_DISK_FULL", 7, n13);
        n11 = 12;
        zzi = zzr$zzbg$zzb4 = new zzr$zzbg$zzb("FILE_WRITE_FAILED", 8, n11);
        zzj = zzr$zzbg$zzb3 = new zzr$zzbg$zzb("FILE_READ_FAILED", 9, 13);
        zzk = zzr$zzbg$zzb2 = new zzr$zzbg$zzb("FILE_READ_RETURNED_INVALID_DATA", n15, 14);
        zzl = zzr$zzbg$zzb = new zzr$zzbg$zzb("FILE_READ_RETURNED_MALFORMED_DATA", n13, 15);
        zzr$zzbg$zzb[] zzr$zzbg$zzbArray = new zzr$zzbg$zzb[n11];
        zzr$zzbg$zzbArray[0] = object;
        zzr$zzbg$zzbArray[1] = zzr$zzbg$zzb11;
        zzr$zzbg$zzbArray[2] = zzr$zzbg$zzb10;
        zzr$zzbg$zzbArray[3] = zzr$zzbg$zzb9;
        zzr$zzbg$zzbArray[4] = zzr$zzbg$zzb8;
        zzr$zzbg$zzbArray[5] = zzr$zzbg$zzb7;
        zzr$zzbg$zzbArray[6] = zzr$zzbg$zzb6;
        zzr$zzbg$zzbArray[7] = zzr$zzbg$zzb5;
        zzr$zzbg$zzbArray[8] = zzr$zzbg$zzb4;
        zzr$zzbg$zzbArray[9] = zzr$zzbg$zzb3;
        zzr$zzbg$zzbArray[10] = zzr$zzbg$zzb2;
        zzr$zzbg$zzbArray[n13] = zzr$zzbg$zzb;
        zzo = zzr$zzbg$zzbArray;
        zzm = object = new zzca();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzr$zzbg$zzb() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzn = var3_1;
    }

    public static zzr$zzbg$zzb[] values() {
        return (zzr$zzbg$zzb[])zzo.clone();
    }

    public static zzen zzb() {
        return zzcb.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzr$zzbg$zzb.class.getName();
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

