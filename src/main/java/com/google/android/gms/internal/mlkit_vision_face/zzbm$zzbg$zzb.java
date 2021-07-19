/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzdv;
import com.google.android.gms.internal.mlkit_vision_face.zzdw;
import com.google.android.gms.internal.mlkit_vision_face.zzgf;
import com.google.android.gms.internal.mlkit_vision_face.zzgh;
import com.google.android.gms.internal.mlkit_vision_face.zzgi;

public final class zzbm$zzbg$zzb
extends Enum
implements zzgf {
    private static final /* enum */ zzbm$zzbg$zzb zza;
    private static final /* enum */ zzbm$zzbg$zzb zzb;
    private static final /* enum */ zzbm$zzbg$zzb zzc;
    private static final /* enum */ zzbm$zzbg$zzb zzd;
    private static final /* enum */ zzbm$zzbg$zzb zze;
    private static final /* enum */ zzbm$zzbg$zzb zzf;
    private static final /* enum */ zzbm$zzbg$zzb zzg;
    private static final /* enum */ zzbm$zzbg$zzb zzh;
    private static final /* enum */ zzbm$zzbg$zzb zzi;
    private static final /* enum */ zzbm$zzbg$zzb zzj;
    private static final /* enum */ zzbm$zzbg$zzb zzk;
    private static final /* enum */ zzbm$zzbg$zzb zzl;
    private static final zzgi zzm;
    private static final /* synthetic */ zzbm$zzbg$zzb[] zzo;
    private final int zzn;

    static {
        zzbm$zzbg$zzb zzbm$zzbg$zzb;
        zzbm$zzbg$zzb zzbm$zzbg$zzb2;
        zzbm$zzbg$zzb zzbm$zzbg$zzb3;
        zzbm$zzbg$zzb zzbm$zzbg$zzb4;
        zzbm$zzbg$zzb zzbm$zzbg$zzb5;
        zzbm$zzbg$zzb zzbm$zzbg$zzb6;
        zzbm$zzbg$zzb zzbm$zzbg$zzb7;
        zzbm$zzbg$zzb zzbm$zzbg$zzb8;
        zzbm$zzbg$zzb zzbm$zzbg$zzb9;
        zzbm$zzbg$zzb zzbm$zzbg$zzb10;
        zzbm$zzbg$zzb zzbm$zzbg$zzb11;
        Object object = new zzbm$zzbg$zzb("UNKNOWN_ERROR", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzbm$zzbg$zzb11 = new zzbm$zzbg$zzb("NO_CONNECTION", n10, n10);
        int n11 = 2;
        zzc = zzbm$zzbg$zzb10 = new zzbm$zzbg$zzb("RPC_ERROR", n11, n11);
        int n12 = 3;
        zzd = zzbm$zzbg$zzb9 = new zzbm$zzbg$zzb("RPC_RETURNED_INVALID_RESULT", n12, n12);
        int n13 = 4;
        zze = zzbm$zzbg$zzb8 = new zzbm$zzbg$zzb("RPC_RETURNED_MALFORMED_RESULT", n13, n13);
        int n14 = 5;
        zzf = zzbm$zzbg$zzb7 = new zzbm$zzbg$zzb("RPC_EXPONENTIAL_BACKOFF_FAILED", n14, n14);
        int n15 = 10;
        zzg = zzbm$zzbg$zzb6 = new zzbm$zzbg$zzb("DIRECTORY_CREATION_FAILED", 6, n15);
        n13 = 11;
        zzh = zzbm$zzbg$zzb5 = new zzbm$zzbg$zzb("FILE_WRITE_FAILED_DISK_FULL", 7, n13);
        n11 = 12;
        zzi = zzbm$zzbg$zzb4 = new zzbm$zzbg$zzb("FILE_WRITE_FAILED", 8, n11);
        zzj = zzbm$zzbg$zzb3 = new zzbm$zzbg$zzb("FILE_READ_FAILED", 9, 13);
        zzk = zzbm$zzbg$zzb2 = new zzbm$zzbg$zzb("FILE_READ_RETURNED_INVALID_DATA", n15, 14);
        zzl = zzbm$zzbg$zzb = new zzbm$zzbg$zzb("FILE_READ_RETURNED_MALFORMED_DATA", n13, 15);
        zzbm$zzbg$zzb[] zzbm$zzbg$zzbArray = new zzbm$zzbg$zzb[n11];
        zzbm$zzbg$zzbArray[0] = object;
        zzbm$zzbg$zzbArray[1] = zzbm$zzbg$zzb11;
        zzbm$zzbg$zzbArray[2] = zzbm$zzbg$zzb10;
        zzbm$zzbg$zzbArray[3] = zzbm$zzbg$zzb9;
        zzbm$zzbg$zzbArray[4] = zzbm$zzbg$zzb8;
        zzbm$zzbg$zzbArray[5] = zzbm$zzbg$zzb7;
        zzbm$zzbg$zzbArray[6] = zzbm$zzbg$zzb6;
        zzbm$zzbg$zzbArray[7] = zzbm$zzbg$zzb5;
        zzbm$zzbg$zzbArray[8] = zzbm$zzbg$zzb4;
        zzbm$zzbg$zzbArray[9] = zzbm$zzbg$zzb3;
        zzbm$zzbg$zzbArray[10] = zzbm$zzbg$zzb2;
        zzbm$zzbg$zzbArray[n13] = zzbm$zzbg$zzb;
        zzo = zzbm$zzbg$zzbArray;
        zzm = object = new zzdv();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzbm$zzbg$zzb() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzn = var3_1;
    }

    public static zzbm$zzbg$zzb[] values() {
        return (zzbm$zzbg$zzb[])zzo.clone();
    }

    public static zzgh zzb() {
        return zzdw.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzbm$zzbg$zzb.class.getName();
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

