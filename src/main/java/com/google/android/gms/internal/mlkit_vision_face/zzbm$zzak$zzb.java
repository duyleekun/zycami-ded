/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzcr;
import com.google.android.gms.internal.mlkit_vision_face.zzcs;
import com.google.android.gms.internal.mlkit_vision_face.zzgf;
import com.google.android.gms.internal.mlkit_vision_face.zzgh;
import com.google.android.gms.internal.mlkit_vision_face.zzgi;

public final class zzbm$zzak$zzb
extends Enum
implements zzgf {
    private static final /* enum */ zzbm$zzak$zzb zza;
    private static final /* enum */ zzbm$zzak$zzb zzb;
    private static final /* enum */ zzbm$zzak$zzb zzc;
    private static final /* enum */ zzbm$zzak$zzb zzd;
    private static final /* enum */ zzbm$zzak$zzb zze;
    private static final /* enum */ zzbm$zzak$zzb zzf;
    private static final /* enum */ zzbm$zzak$zzb zzg;
    private static final /* enum */ zzbm$zzak$zzb zzh;
    private static final /* enum */ zzbm$zzak$zzb zzi;
    private static final /* enum */ zzbm$zzak$zzb zzj;
    private static final /* enum */ zzbm$zzak$zzb zzk;
    private static final /* enum */ zzbm$zzak$zzb zzl;
    private static final /* enum */ zzbm$zzak$zzb zzm;
    private static final zzgi zzn;
    private static final /* synthetic */ zzbm$zzak$zzb[] zzp;
    private final int zzo;

    static {
        zzbm$zzak$zzb zzbm$zzak$zzb;
        zzbm$zzak$zzb zzbm$zzak$zzb2;
        zzbm$zzak$zzb zzbm$zzak$zzb3;
        zzbm$zzak$zzb zzbm$zzak$zzb4;
        zzbm$zzak$zzb zzbm$zzak$zzb5;
        zzbm$zzak$zzb zzbm$zzak$zzb6;
        zzbm$zzak$zzb zzbm$zzak$zzb7;
        zzbm$zzak$zzb zzbm$zzak$zzb8;
        zzbm$zzak$zzb zzbm$zzak$zzb9;
        zzbm$zzak$zzb zzbm$zzak$zzb10;
        zzbm$zzak$zzb zzbm$zzak$zzb11;
        zzbm$zzak$zzb zzbm$zzak$zzb12;
        Object object = new zzbm$zzak$zzb("UNKNOWN_STATUS", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzbm$zzak$zzb12 = new zzbm$zzak$zzb("EXPLICITLY_REQUESTED", n10, n10);
        int n11 = 2;
        zzc = zzbm$zzak$zzb11 = new zzbm$zzak$zzb("IMPLICITLY_REQUESTED", n11, n11);
        int n12 = 3;
        zzd = zzbm$zzak$zzb10 = new zzbm$zzak$zzb("MODEL_INFO_RETRIEVAL_SUCCEEDED", n12, n12);
        int n13 = 4;
        zze = zzbm$zzak$zzb9 = new zzbm$zzak$zzb("MODEL_INFO_RETRIEVAL_FAILED", n13, n13);
        int n14 = 5;
        zzf = zzbm$zzak$zzb8 = new zzbm$zzak$zzb("SCHEDULED", n14, n14);
        int n15 = 6;
        zzg = zzbm$zzak$zzb7 = new zzbm$zzak$zzb("DOWNLOADING", n15, n15);
        n15 = 7;
        zzh = zzbm$zzak$zzb6 = new zzbm$zzak$zzb("SUCCEEDED", n15, n15);
        n14 = 8;
        zzi = zzbm$zzak$zzb5 = new zzbm$zzak$zzb("FAILED", n14, n14);
        n13 = 9;
        zzj = zzbm$zzak$zzb4 = new zzbm$zzak$zzb("LIVE", n13, n13);
        n12 = 10;
        zzk = zzbm$zzak$zzb3 = new zzbm$zzak$zzb("UPDATE_AVAILABLE", n12, n12);
        n11 = 11;
        zzl = zzbm$zzak$zzb2 = new zzbm$zzak$zzb("DOWNLOADED", n11, n11);
        n10 = 12;
        zzm = zzbm$zzak$zzb = new zzbm$zzak$zzb("STARTED", n10, n10);
        zzbm$zzak$zzb[] zzbm$zzak$zzbArray = new zzbm$zzak$zzb[13];
        zzbm$zzak$zzbArray[0] = object;
        zzbm$zzak$zzbArray[1] = zzbm$zzak$zzb12;
        zzbm$zzak$zzbArray[2] = zzbm$zzak$zzb11;
        zzbm$zzak$zzbArray[3] = zzbm$zzak$zzb10;
        zzbm$zzak$zzbArray[4] = zzbm$zzak$zzb9;
        zzbm$zzak$zzbArray[5] = zzbm$zzak$zzb8;
        zzbm$zzak$zzbArray[6] = zzbm$zzak$zzb7;
        zzbm$zzak$zzbArray[7] = zzbm$zzak$zzb6;
        zzbm$zzak$zzbArray[8] = zzbm$zzak$zzb5;
        zzbm$zzak$zzbArray[9] = zzbm$zzak$zzb4;
        zzbm$zzak$zzbArray[10] = zzbm$zzak$zzb3;
        zzbm$zzak$zzbArray[11] = zzbm$zzak$zzb2;
        zzbm$zzak$zzbArray[n10] = zzbm$zzak$zzb;
        zzp = zzbm$zzak$zzbArray;
        zzn = object = new zzcr();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzbm$zzak$zzb() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzo = var3_1;
    }

    public static zzbm$zzak$zzb[] values() {
        return (zzbm$zzak$zzb[])zzp.clone();
    }

    public static zzgh zzb() {
        return zzcs.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzbm$zzak$zzb.class.getName();
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

