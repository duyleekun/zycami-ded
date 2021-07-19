/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzby;
import com.google.android.gms.internal.mlkit_common.zzbz;
import com.google.android.gms.internal.mlkit_common.zzfu;
import com.google.android.gms.internal.mlkit_common.zzfv;
import com.google.android.gms.internal.mlkit_common.zzfx;

public final class zzav$zzak$zza
extends Enum
implements zzfv {
    public static final /* enum */ zzav$zzak$zza zza;
    public static final /* enum */ zzav$zzak$zza zzb;
    public static final /* enum */ zzav$zzak$zza zzc;
    public static final /* enum */ zzav$zzak$zza zzd;
    public static final /* enum */ zzav$zzak$zza zze;
    public static final /* enum */ zzav$zzak$zza zzf;
    public static final /* enum */ zzav$zzak$zza zzg;
    public static final /* enum */ zzav$zzak$zza zzh;
    public static final /* enum */ zzav$zzak$zza zzi;
    public static final /* enum */ zzav$zzak$zza zzj;
    public static final /* enum */ zzav$zzak$zza zzk;
    private static final /* enum */ zzav$zzak$zza zzl;
    private static final /* enum */ zzav$zzak$zza zzm;
    private static final zzfu zzn;
    private static final /* synthetic */ zzav$zzak$zza[] zzp;
    private final int zzo;

    static {
        zzav$zzak$zza zzav$zzak$zza;
        zzav$zzak$zza zzav$zzak$zza2;
        zzav$zzak$zza zzav$zzak$zza3;
        zzav$zzak$zza zzav$zzak$zza4;
        zzav$zzak$zza zzav$zzak$zza5;
        zzav$zzak$zza zzav$zzak$zza6;
        zzav$zzak$zza zzav$zzak$zza7;
        zzav$zzak$zza zzav$zzak$zza8;
        zzav$zzak$zza zzav$zzak$zza9;
        zzav$zzak$zza zzav$zzak$zza10;
        zzav$zzak$zza zzav$zzak$zza11;
        zzav$zzak$zza zzav$zzak$zza12;
        Object object = new zzav$zzak$zza("UNKNOWN_STATUS", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzav$zzak$zza12 = new zzav$zzak$zza("EXPLICITLY_REQUESTED", n10, n10);
        int n11 = 2;
        zzl = zzav$zzak$zza11 = new zzav$zzak$zza("IMPLICITLY_REQUESTED", n11, n11);
        int n12 = 3;
        zzc = zzav$zzak$zza10 = new zzav$zzak$zza("MODEL_INFO_RETRIEVAL_SUCCEEDED", n12, n12);
        int n13 = 4;
        zzd = zzav$zzak$zza9 = new zzav$zzak$zza("MODEL_INFO_RETRIEVAL_FAILED", n13, n13);
        int n14 = 5;
        zze = zzav$zzak$zza8 = new zzav$zzak$zza("SCHEDULED", n14, n14);
        int n15 = 6;
        zzf = zzav$zzak$zza7 = new zzav$zzak$zza("DOWNLOADING", n15, n15);
        n15 = 7;
        zzg = zzav$zzak$zza6 = new zzav$zzak$zza("SUCCEEDED", n15, n15);
        n14 = 8;
        zzh = zzav$zzak$zza5 = new zzav$zzak$zza("FAILED", n14, n14);
        n13 = 9;
        zzi = zzav$zzak$zza4 = new zzav$zzak$zza("LIVE", n13, n13);
        n12 = 10;
        zzj = zzav$zzak$zza3 = new zzav$zzak$zza("UPDATE_AVAILABLE", n12, n12);
        n11 = 11;
        zzk = zzav$zzak$zza2 = new zzav$zzak$zza("DOWNLOADED", n11, n11);
        n10 = 12;
        zzm = zzav$zzak$zza = new zzav$zzak$zza("STARTED", n10, n10);
        zzav$zzak$zza[] zzav$zzak$zzaArray = new zzav$zzak$zza[13];
        zzav$zzak$zzaArray[0] = object;
        zzav$zzak$zzaArray[1] = zzav$zzak$zza12;
        zzav$zzak$zzaArray[2] = zzav$zzak$zza11;
        zzav$zzak$zzaArray[3] = zzav$zzak$zza10;
        zzav$zzak$zzaArray[4] = zzav$zzak$zza9;
        zzav$zzak$zzaArray[5] = zzav$zzak$zza8;
        zzav$zzak$zzaArray[6] = zzav$zzak$zza7;
        zzav$zzak$zzaArray[7] = zzav$zzak$zza6;
        zzav$zzak$zzaArray[8] = zzav$zzak$zza5;
        zzav$zzak$zzaArray[9] = zzav$zzak$zza4;
        zzav$zzak$zzaArray[10] = zzav$zzak$zza3;
        zzav$zzak$zzaArray[11] = zzav$zzak$zza2;
        zzav$zzak$zzaArray[n10] = zzav$zzak$zza;
        zzp = zzav$zzak$zzaArray;
        zzn = object = new zzbz();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzav$zzak$zza() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzo = var3_1;
    }

    public static zzav$zzak$zza[] values() {
        return (zzav$zzak$zza[])zzp.clone();
    }

    public static zzfx zzb() {
        return zzby.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzav$zzak$zza.class.getName();
        stringBuilder.append(string2);
        stringBuilder.append('@');
        string2 = Integer.toHexString(System.identityHashCode(this));
        stringBuilder.append(string2);
        stringBuilder.append(" number=");
        int n10 = this.zzo;
        stringBuilder.append(n10);
        stringBuilder.append(" name=");
        string2 = this.name();
        stringBuilder.append(string2);
        stringBuilder.append('>');
        return stringBuilder.toString();
    }

    public final int zza() {
        return this.zzo;
    }
}

