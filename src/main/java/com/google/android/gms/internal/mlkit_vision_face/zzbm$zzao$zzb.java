/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzdd;
import com.google.android.gms.internal.mlkit_vision_face.zzde;
import com.google.android.gms.internal.mlkit_vision_face.zzgf;
import com.google.android.gms.internal.mlkit_vision_face.zzgh;
import com.google.android.gms.internal.mlkit_vision_face.zzgi;

public final class zzbm$zzao$zzb
extends Enum
implements zzgf {
    private static final /* enum */ zzbm$zzao$zzb zza;
    private static final /* enum */ zzbm$zzao$zzb zzb;
    private static final /* enum */ zzbm$zzao$zzb zzc;
    private static final /* enum */ zzbm$zzao$zzb zzd;
    private static final /* enum */ zzbm$zzao$zzb zze;
    private static final /* enum */ zzbm$zzao$zzb zzf;
    private static final /* enum */ zzbm$zzao$zzb zzg;
    private static final /* enum */ zzbm$zzao$zzb zzh;
    private static final /* enum */ zzbm$zzao$zzb zzi;
    private static final /* enum */ zzbm$zzao$zzb zzj;
    private static final /* enum */ zzbm$zzao$zzb zzk;
    private static final /* enum */ zzbm$zzao$zzb zzl;
    private static final /* enum */ zzbm$zzao$zzb zzm;
    private static final zzgi zzn;
    private static final /* synthetic */ zzbm$zzao$zzb[] zzp;
    private final int zzo;

    static {
        zzbm$zzao$zzb zzbm$zzao$zzb;
        zzbm$zzao$zzb zzbm$zzao$zzb2;
        zzbm$zzao$zzb zzbm$zzao$zzb3;
        zzbm$zzao$zzb zzbm$zzao$zzb4;
        zzbm$zzao$zzb zzbm$zzao$zzb5;
        zzbm$zzao$zzb zzbm$zzao$zzb6;
        zzbm$zzao$zzb zzbm$zzao$zzb7;
        zzbm$zzao$zzb zzbm$zzao$zzb8;
        zzbm$zzao$zzb zzbm$zzao$zzb9;
        zzbm$zzao$zzb zzbm$zzao$zzb10;
        zzbm$zzao$zzb zzbm$zzao$zzb11;
        zzbm$zzao$zzb zzbm$zzao$zzb12;
        Object object = new zzbm$zzao$zzb("TYPE_UNKNOWN", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzbm$zzao$zzb12 = new zzbm$zzao$zzb("TYPE_CONTACT_INFO", n10, n10);
        int n11 = 2;
        zzc = zzbm$zzao$zzb11 = new zzbm$zzao$zzb("TYPE_EMAIL", n11, n11);
        int n12 = 3;
        zzd = zzbm$zzao$zzb10 = new zzbm$zzao$zzb("TYPE_ISBN", n12, n12);
        int n13 = 4;
        zze = zzbm$zzao$zzb9 = new zzbm$zzao$zzb("TYPE_PHONE", n13, n13);
        int n14 = 5;
        zzf = zzbm$zzao$zzb8 = new zzbm$zzao$zzb("TYPE_PRODUCT", n14, n14);
        int n15 = 6;
        zzg = zzbm$zzao$zzb7 = new zzbm$zzao$zzb("TYPE_SMS", n15, n15);
        n15 = 7;
        zzh = zzbm$zzao$zzb6 = new zzbm$zzao$zzb("TYPE_TEXT", n15, n15);
        n14 = 8;
        zzi = zzbm$zzao$zzb5 = new zzbm$zzao$zzb("TYPE_URL", n14, n14);
        n13 = 9;
        zzj = zzbm$zzao$zzb4 = new zzbm$zzao$zzb("TYPE_WIFI", n13, n13);
        n12 = 10;
        zzk = zzbm$zzao$zzb3 = new zzbm$zzao$zzb("TYPE_GEO", n12, n12);
        n11 = 11;
        zzl = zzbm$zzao$zzb2 = new zzbm$zzao$zzb("TYPE_CALENDAR_EVENT", n11, n11);
        n10 = 12;
        zzm = zzbm$zzao$zzb = new zzbm$zzao$zzb("TYPE_DRIVER_LICENSE", n10, n10);
        zzbm$zzao$zzb[] zzbm$zzao$zzbArray = new zzbm$zzao$zzb[13];
        zzbm$zzao$zzbArray[0] = object;
        zzbm$zzao$zzbArray[1] = zzbm$zzao$zzb12;
        zzbm$zzao$zzbArray[2] = zzbm$zzao$zzb11;
        zzbm$zzao$zzbArray[3] = zzbm$zzao$zzb10;
        zzbm$zzao$zzbArray[4] = zzbm$zzao$zzb9;
        zzbm$zzao$zzbArray[5] = zzbm$zzao$zzb8;
        zzbm$zzao$zzbArray[6] = zzbm$zzao$zzb7;
        zzbm$zzao$zzbArray[7] = zzbm$zzao$zzb6;
        zzbm$zzao$zzbArray[8] = zzbm$zzao$zzb5;
        zzbm$zzao$zzbArray[9] = zzbm$zzao$zzb4;
        zzbm$zzao$zzbArray[10] = zzbm$zzao$zzb3;
        zzbm$zzao$zzbArray[11] = zzbm$zzao$zzb2;
        zzbm$zzao$zzbArray[n10] = zzbm$zzao$zzb;
        zzp = zzbm$zzao$zzbArray;
        zzn = object = new zzdd();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzbm$zzao$zzb() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzo = var3_1;
    }

    public static zzbm$zzao$zzb[] values() {
        return (zzbm$zzao$zzb[])zzp.clone();
    }

    public static zzgh zzb() {
        return zzde.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzbm$zzao$zzb.class.getName();
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

